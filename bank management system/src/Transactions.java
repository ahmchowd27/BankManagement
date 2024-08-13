import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Transactions extends JFrame implements ActionListener {

    JButton  deposit,  withdrawal, fastcash, ministate,  pinchange ,  balance , exit;
    String pinNumber;

Transactions(String pinNumber){
    this.pinNumber = pinNumber;
    setSize(900,900);
    setLocation(300,0);
    //setUndecorated(true);
    setVisible(true);
    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);

    JLabel text = new JLabel("Please select your Transaction");
    text.setBounds(210,300,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("Raleway", Font.BOLD,16));
    image.add(text);

    deposit = new JButton("Deposit");
    deposit.setBounds(170,415,150,30);
    deposit.addActionListener(this);
    image.add(deposit);
   
    withdrawal = new JButton("Withdraw");
    withdrawal.setBounds(355,415,150,30);
    withdrawal.addActionListener(this);
    image.add(withdrawal);
    
    fastcash = new JButton("FastCash");
    fastcash.addActionListener(this);
    fastcash.setBounds(170,450,150,30);
    image.add(fastcash);

    ministate = new JButton("Mini Statement");
    ministate.addActionListener(this);
    ministate.setBounds(355,415,150,30);
    image.add(ministate);
    
    pinchange = new JButton("Change Pin");
    pinchange.addActionListener(this);
    pinchange.setBounds(170,485,150,30);
    image.add(pinchange);

    balance = new JButton("Show Balance");
    balance.addActionListener(this);
    balance.setBounds(355,485,150,30);
    image.add(pinchange);

    exit = new JButton("Exit");
    exit.addActionListener(this);
    exit.setBounds(170,520,150,30);
    image.add(exit);



}
public void actionPerformed(ActionEvent ae){
if(ae.getSource() == exit){
    System.exit(0);
}
else if(ae.getSource() == deposit ){
    setVisible(false);
    new Deposit(pinNumber);
}
else if(ae.getSource() == withdrawal ){
    setVisible(false);
    new Withdrawl(pinNumber);
}
else if(ae.getSource() == pinchange){
    setVisible(false);
    new Pin(pinNumber);
}
else if(ae.getSource() == fastcash ){
    setVisible(false);
    new FastCash(pinNumber);
}
else if(ae.getSource() == ministate ){
    setVisible(false);
    new BalanceEnquiry(pinNumber);
}

}




}