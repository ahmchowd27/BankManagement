import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    Signup3(String formno) {
        this.formno = formno;
        setLayout(null);
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 150, 20);
        add(r1);

        r2 = new JRadioButton("Growth Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 150, 20);
        add(r2);

        r3 = new JRadioButton("FD Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 150, 20);
        add(r3);

        r4 = new JRadioButton("Current Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 150, 20);
        add(r4);

        ButtonGroup gac = new ButtonGroup();
        gac.add(r1);
        gac.add(r2);
        gac.add(r3);
        gac.add(r4);

        JLabel cardNo = new JLabel("Card Number:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNo.setBounds(100, 300, 200, 30);
        add(cardNo);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4178");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel demo = new JLabel("Your 16 Digit Card No is:");
        demo.setFont(new Font("Raleway", Font.BOLD, 12));
        demo.setBounds(100, 330, 300, 20);
        add(demo);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pinN = new JLabel("XXXX");
        pinN.setFont(new Font("Raleway", Font.BOLD, 22));
        pinN.setBounds(330, 370, 300, 30);
        add(pinN);

        JLabel pdemo = new JLabel("Your 4 Digit pin No is:");
        pdemo.setFont(new Font("Raleway", Font.BOLD, 12));
        pdemo.setBounds(100, 400, 300, 20);
        add(pdemo);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 400, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Online Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("Monthly Statements");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Growth Account";
            } else if (r3.isSelected()) {
                accountType = "FD Account";
            } else if (r4.isSelected()) {
                accountType = "Current Account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 900000000000000L) + 5040936000000000L);
            String pinNumber = "" +  Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if (c1.isSelected()) {
                facility += "ATM CARD";
            } else if (c2.isSelected()) {
                facility += "Online Banking";
            } else if (c3.isSelected()) {
                facility += "Mobile Banking";
            } else if (c4.isSelected()) {
                facility += "Email & SMS Alerts";
            } else if (c5.isSelected()) {
                facility += "Cheque Book";
            } else if (c6.isSelected()) {
                facility += "Monthly Statements";
            }
            
            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type Required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "INSERT INTO signup3 (formno, account_type, card_number, pin_number, facilities) values ('" + formno + "', '" + accountType + "', '" + cardNumber + "', '" + pinNumber + "', '" + facility + "')";
                    conn.s.executeUpdate(query1);
                    String query2 = "INSERT INTO login (formno, card_number, pin_number) VALUES ('" 
                    + formno + "', '" 
                    + cardNumber + "', '" 
                    + pinNumber + "')";
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: "+ cardNumber+ "\n" +"PIN: "+ pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } 
        else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login();            
            
        }
    }
}