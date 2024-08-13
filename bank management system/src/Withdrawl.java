import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JTextField amountField;
    JButton withdrawButton, backButton;
    JLabel maxWithdrawLabel, enterAmountLabel, backgroundLabel;
    String userPin;

    Withdrawl(String userPin) {
        this.userPin = userPin;
        
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image atmImage = atmIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledAtmIcon = new ImageIcon(atmImage);
        backgroundLabel = new JLabel(scaledAtmIcon);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);
        
        maxWithdrawLabel = new JLabel("MAXIMUM WITHDRAWAL IS $1000");
        maxWithdrawLabel.setForeground(Color.WHITE);
        maxWithdrawLabel.setFont(new Font("System", Font.BOLD, 16));
        
        enterAmountLabel = new JLabel("PLEASE ENTER YOUR AMOUNT");
        enterAmountLabel.setForeground(Color.WHITE);
        enterAmountLabel.setFont(new Font("System", Font.BOLD, 16));
        
        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 25));
        
        withdrawButton = new JButton("WITHDRAW");
        backButton = new JButton("BACK");
        
        setLayout(null);
        
        maxWithdrawLabel.setBounds(190, 350, 400, 20);
        backgroundLabel.add(maxWithdrawLabel);
        
        enterAmountLabel.setBounds(190, 400, 400, 20);
        backgroundLabel.add(enterAmountLabel);
        
        amountField.setBounds(190, 450, 330, 30);
        backgroundLabel.add(amountField);
        
        withdrawButton.setBounds(390, 588, 150, 35);
        backgroundLabel.add(withdrawButton);
        
        backButton.setBounds(390, 633, 150, 35);
        backgroundLabel.add(backButton);
        
        withdrawButton.addActionListener(this);
        backButton.addActionListener(this);
        
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        try {        
            String amount = amountField.getText();
            if (amount.equals("") || Double.parseDouble(amount) <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Amount you want to Withdraw");
                return;
            }
            
            Date date = new Date();
            if(ae.getSource() == withdrawButton) {
                Conn dbConnection = new Conn();
                ResultSet resultSet = null;
                double balance = 0.0;
                
                try {
                    resultSet = dbConnection.s.executeQuery("select * from bank where pin_number = '" + userPin + "'");
                    while(resultSet.next()) {
                        if(resultSet.getString("transaction_type").equals("Deposit")) {
                            balance += Double.parseDouble(resultSet.getString("amount"));
                        } else {
                            balance -= Double.parseDouble(resultSet.getString("amount"));
                        }
                    }
                    
                    if(balance < Double.parseDouble(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    
                    dbConnection.s.executeUpdate("insert into bank (pin_number, transaction_date, transaction_type, amount) values('" + userPin + "', '" + date + "', 'Withdrawal', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "$ " + amount + " Withdrawn Successfully");
                    
                    setVisible(false);
                    new Transactions(userPin).setVisible(true);
                    
                } finally {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    dbConnection.s.close();
                   
                }
            } else if(ae.getSource() == backButton) {
                setVisible(false);
                new Transactions(userPin).setVisible(true);
            }
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
    }
}    