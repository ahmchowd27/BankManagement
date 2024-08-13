import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener {
    
    JPasswordField newPinField, confirmNewPinField;
    JButton changeButton, backButton;                               
    JLabel titleLabel, newPinLabel, confirmNewPinLabel;
    String currentPin;

    Pin(String currentPin) {
        this.currentPin = currentPin;

        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image atmImage = atmIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledAtmIcon = new ImageIcon(atmImage);
        JLabel backgroundLabel = new JLabel(scaledAtmIcon);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);
        
        titleLabel = new JLabel("CHANGE YOUR PIN");
        titleLabel.setFont(new Font("System", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        
        newPinLabel = new JLabel("New PIN:");
        newPinLabel.setFont(new Font("System", Font.BOLD, 16));
        newPinLabel.setForeground(Color.WHITE);
        
        confirmNewPinLabel = new JLabel("Re-Enter New PIN:");
        confirmNewPinLabel.setFont(new Font("System", Font.BOLD, 16));
        confirmNewPinLabel.setForeground(Color.WHITE);
        
        newPinField = new JPasswordField();
        newPinField.setFont(new Font("Raleway", Font.BOLD, 25));
        
        confirmNewPinField = new JPasswordField();
        confirmNewPinField.setFont(new Font("Raleway", Font.BOLD, 25));
        
        changeButton = new JButton("CHANGE");
        backButton = new JButton("BACK");
        
        changeButton.addActionListener(this);
        backButton.addActionListener(this);
        
        setLayout(null);
        
        titleLabel.setBounds(280, 330, 800, 35);
        backgroundLabel.add(titleLabel);
        
        newPinLabel.setBounds(180, 390, 150, 35);
        backgroundLabel.add(newPinLabel);
        
        confirmNewPinLabel.setBounds(180, 440, 200, 35);
        backgroundLabel.add(confirmNewPinLabel);
        
        newPinField.setBounds(350, 390, 180, 25);
        backgroundLabel.add(newPinField);
        
        confirmNewPinField.setBounds(350, 440, 180, 25);
        backgroundLabel.add(confirmNewPinField);
        
        changeButton.setBounds(390, 588, 150, 35);
        backgroundLabel.add(changeButton);
        
        backButton.setBounds(390, 633, 150, 35);
        backgroundLabel.add(backButton);
        
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String newPin = new String(newPinField.getPassword());
            String confirmedPin = new String(confirmNewPinField.getPassword());
            
            if (!newPin.equals(confirmedPin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if (ae.getSource() == changeButton) {
                if (newPin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                } else if (confirmedPin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                } else {
                    Conn connection = new Conn();
                    String updateBankQuery = "update bank set pin_number = '"+newPin+"' where pin_number = '"+currentPin+"'";
                    String updateLoginQuery = "update login set pin_number = '"+newPin+"' where pin_number = '"+currentPin+"'";
                    String updateSignupQuery = "update signup3 set pin_number = '"+newPin+"' where pin_number = '"+currentPin+"'";
                    System.out.println("Update Bank Query: " + updateBankQuery);
                    System.out.println("Update Login Query: " + updateLoginQuery);
                    System.out.println("Update Signup Query: " + updateSignupQuery);


                    connection.s.executeUpdate(updateBankQuery);
                    connection.s.executeUpdate(updateLoginQuery);
                    connection.s.executeUpdate(updateSignupQuery);

                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new Transactions(newPin).setVisible(true);
                }
            } else if (ae.getSource() == backButton) {
                new Transactions(currentPin).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
