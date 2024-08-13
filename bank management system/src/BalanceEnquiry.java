import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JLabel balanceLabel;
    JButton btnBack;
    String userPin;

    BalanceEnquiry(String userPin) {
        this.userPin = userPin;

        // Set up the ATM background image
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image atmImage = atmIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledAtmIcon = new ImageIcon(atmImage);
        JLabel backgroundLabel = new JLabel(scaledAtmIcon);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);

        // Initialize and set up the balance label
        balanceLabel = new JLabel();
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setFont(new Font("System", Font.BOLD, 16));

        // Initialize and set up the back button
        btnBack = new JButton("BACK");

        setLayout(null);

        // Add components to the background label
        balanceLabel.setBounds(190, 350, 400, 35);
        backgroundLabel.add(balanceLabel);

        btnBack.setBounds(390, 633, 150, 35);
        backgroundLabel.add(btnBack);

        // Retrieve the account balance from the database
        int balance = 0;
        try {
            Conn databaseConnection = new Conn();
            ResultSet resultSet = databaseConnection.s.executeQuery("SELECT * FROM bank WHERE pin_number = '" + userPin + "'");
            while (resultSet.next()) {
                if (resultSet.getString("transaction_type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display the account balance
        balanceLabel.setText("Your Current Account Balance is Rs " + balance);

        // Set up event listeners
        btnBack.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(userPin).setVisible(true);
    }

}
