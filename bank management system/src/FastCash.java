import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel instructionLabel;
    JButton btn20, btn50, btn80, btn100, btn200, btn250, btnBack;
    String userPin;

    FastCash(String userPin) {
        this.userPin = userPin;
        
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image atmImage = atmIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledAtmIcon = new ImageIcon(atmImage);
        JLabel backgroundLabel = new JLabel(scaledAtmIcon);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);

        instructionLabel = new JLabel("SELECT WITHDRAWAL AMOUNT");
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setFont(new Font("System", Font.BOLD, 16));

        btn20 = new JButton("$ 20");
        btn50 = new JButton("$ 50");
        btn80 = new JButton("$ 80");
        btn100 = new JButton("$ 100");
        btn200 = new JButton("$ 200");
        btn250 = new JButton("$ 250");
        btnBack = new JButton("BACK");

        setLayout(null);

        instructionLabel.setBounds(235, 400, 700, 35);
        backgroundLabel.add(instructionLabel);

        btn20.setBounds(170, 499, 150, 35);
        backgroundLabel.add(btn20);

        btn50.setBounds(390, 499, 150, 35);
        backgroundLabel.add(btn50);

        btn80.setBounds(170, 543, 150, 35);
        backgroundLabel.add(btn80);

        btn100.setBounds(390, 543, 150, 35);
        backgroundLabel.add(btn100);

        btn200.setBounds(170, 588, 150, 35);
        backgroundLabel.add(btn200);

        btn250.setBounds(390, 588, 150, 35);
        backgroundLabel.add(btn250);

        btnBack.setBounds(390, 633, 150, 35);
        backgroundLabel.add(btnBack);

        btn20.addActionListener(this);
        btn50.addActionListener(this);
        btn80.addActionListener(this);
        btn100.addActionListener(this);
        btn200.addActionListener(this);
        btn250.addActionListener(this);
        btnBack.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String selectedAmountText = ((JButton)ae.getSource()).getText().substring(2).trim(); // Extract amount from button text
            int selectedAmount = Integer.parseInt(selectedAmountText);
            
            Conn databaseConnection = new Conn();
            ResultSet resultSet = databaseConnection.s.executeQuery("select * from bank where pin_number = '" + userPin + "'");
            int balance = 0;
            while (resultSet.next()) {
                if (resultSet.getString("transaction_type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

            if (ae.getSource() != btnBack && balance < selectedAmount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            if (ae.getSource() == btnBack) {
                this.setVisible(false);
                new Transactions(userPin).setVisible(true);
            } else {
                Date currentDate = new Date();
                databaseConnection.s.executeUpdate("insert into bank (pin_number, transaction_date, transaction_type, amount) values('" + userPin + "', '" + currentDate + "', 'Withdrawal', '" + selectedAmount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + selectedAmount + " Debited Successfully");
                
                setVisible(false);
                new Transactions(userPin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
