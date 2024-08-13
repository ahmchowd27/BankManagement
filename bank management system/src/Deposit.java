import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField depositAmountField;
    JButton depositButton, backButton;
    JLabel instructionLabel, backgroundLabel;
    String userPin;

    Deposit(String userPin) {
        this.userPin = userPin;
        
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image atmImage = atmIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledAtmIcon = new ImageIcon(atmImage);
        backgroundLabel = new JLabel(scaledAtmIcon);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);
        
        instructionLabel = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setFont(new Font("System", Font.BOLD, 16));
        
        depositAmountField = new JTextField();
        depositAmountField.setFont(new Font("Raleway", Font.BOLD, 22));
        
        depositButton = new JButton("DEPOSIT");
        backButton = new JButton("BACK");
        
        setLayout(null);
        
        instructionLabel.setBounds(190, 350, 400, 35);
        backgroundLabel.add(instructionLabel);
        
        depositAmountField.setBounds(190, 420, 320, 25);
        backgroundLabel.add(depositAmountField);
        
        depositButton.setBounds(390, 588, 150, 35);
        backgroundLabel.add(depositButton);
        
        backButton.setBounds(390, 633, 150, 35);
        backgroundLabel.add(backButton);
        
        depositButton.addActionListener(this);
        backButton.addActionListener(this);
        
        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {        
            String amount = depositAmountField.getText();
            Date date = new Date();
            if(ae.getSource() == depositButton) {
                if(depositAmountField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
                } else {
                    Conn dbConnection = new Conn();
                    dbConnection.s.executeUpdate("INSERT INTO bank (pin_number, transaction_date, transaction_type, amount) VALUES('" + userPin + "', '" + date + "', 'Deposit', '" + amount + "')");

                    JOptionPane.showMessageDialog(null, "$" + amount + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(userPin).setVisible(true);
                }
            } else if(ae.getSource() == backButton) {
                setVisible(false);
                new Transactions(userPin).setVisible(true);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}