import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField cardfield;
    JPasswordField pinfield;
    public Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label1 = new JLabel(i3);
        label1.setBounds(70, 10, 100, 100);
        add(label1);

        JLabel text = new JLabel("Welcome TO ATM");
        text.setFont(new Font("SansSerif", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("SansSerif", Font.BOLD, 20));
        card.setBounds(120, 150, 150, 30);
        add(card);
        cardfield = new JTextField();
        cardfield.setBounds(300,150,230, 30);
        cardfield.setFont(new Font("Arial",Font.BOLD, 20 ));
        add(cardfield);
        

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("SansSerif", Font.BOLD, 20));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        pinfield = new JPasswordField();
        pinfield.setBounds(300,220,230, 30);
        pinfield.setFont(new Font("Arial",Font.BOLD, 20 ));
        add(pinfield);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        add(login);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        add(signup);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        
        setSize(800, 480);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae .getSource() == clear){
            cardfield.setText("");
            pinfield.setText("");

            }
        else if (ae.getSource() == signup){
            setVisible(false);
            new Signup1().setVisible(true);
        }
        else if (ae. getSource() == login ){
           Conn conn = new Conn();
            String cardnumber = cardfield.getText();
            String pin = pinfield.getText();
            String query = "select *from login where card_number ='"+cardnumber+"'and pin_number = '"+pin+"'";
            try{
                ResultSet rn = conn.s.executeQuery(query);
                if (rn.next()) {
                    setVisible(false);
                    new Transactions("").setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or pin");
                }

            }catch(Exception e){
            System.out.println(e);
            }
            

        }



    }

}