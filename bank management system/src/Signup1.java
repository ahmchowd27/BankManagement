import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class Signup1 extends JFrame implements ActionListener {
    
    Long random;
    JTextField  nameField,fatherField,dob,emailField,addressField,cityField,stateField,countryField,zipField;
    JButton next;
    JRadioButton male, female, married,Unmarried,other;
    JDateChooser dateChooser;
    
    
    
    Signup1(){
        setLayout(null);
        setSize(850, 800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L + 1000L));

        JLabel formno = new JLabel("Application Form No: "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38 ));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personalLabel = new JLabel("Page1: Personal Details");
        personalLabel.setFont(new Font("Raleway", Font.BOLD, 22 ));
        personalLabel.setBounds(290, 80, 400 , 40);
        add(personalLabel);

        JLabel name  = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20 ));
        name.setBounds(100, 140, 100 , 30);
        add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("Raleway", Font.BOLD , 14));
        nameField.setBounds(300, 140, 400, 30);
        add(nameField);

        JLabel father  = new JLabel("Father's Name:");
        father.setFont(new Font("Raleway", Font.BOLD, 20 ));
        father.setBounds(100, 190, 200 , 30);
        add(father);

        fatherField = new JTextField();
        fatherField.setFont(new Font("Raleway", Font.BOLD , 14));
        fatherField.setBounds(300, 190, 400, 30);
        add(fatherField);

        JLabel dob  = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20 ));
        dob.setBounds(100, 240, 400 , 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        

        JLabel gender  = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20 ));
        gender.setBounds(100, 290, 200 , 30);
        add(gender);

        male = new JRadioButton("Male");
        female = new JRadioButton("FeMale");
        male.setBounds(300, 290,  60, 30);
        male.setBackground(Color.white);
        add(male);
        female.setBounds(450, 290, 120 , 30  );
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);


        JLabel email  = new JLabel("E-Mail:");
        email.setFont(new Font("Raleway", Font.BOLD, 20 ));
        email.setBounds(100, 340, 200 , 30);
        add(email);

        emailField = new JTextField();
        emailField.setFont(new Font("Raleway", Font.BOLD , 14));
        emailField.setBounds(300, 340, 400, 30);
        add(emailField);

        
        married = new JRadioButton("Married");
        Unmarried = new JRadioButton("Single");
        other = new JRadioButton("Other");
        other.setBackground(Color.WHITE);
        other.setBounds(630, 390, 100, 30);

        married.setBounds(300, 390,  100, 30);
        Unmarried.setBackground(Color.white);
        add(married);
        Unmarried.setBounds(450, 390, 120 , 30  );
        married.setBackground(Color.white);
        add(Unmarried);

        add(other);

        ButtonGroup marrButtonGroup = new ButtonGroup();
        marrButtonGroup.add(married);
        marrButtonGroup.add(Unmarried);
        marrButtonGroup.add(other);



        JLabel ms  = new JLabel("Marital Status:");
        ms.setFont(new Font("Raleway", Font.BOLD, 20 ));
        ms.setBounds(100, 390, 200 , 30);
        add(ms);

        JLabel address  = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20 ));
        address.setBounds(100, 440, 200 , 30);
        add(address);

        addressField = new JTextField();
        addressField.setFont(new Font("Raleway", Font.BOLD , 14));
        addressField.setBounds(300, 440, 400, 30);
        add(addressField);

        JLabel city  = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20 ));
        city.setBounds(100, 490, 200 , 30);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("Raleway", Font.BOLD , 14));
        cityField.setBounds(300, 490, 400, 30);
        add(cityField);


        JLabel state  = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20 ));
        state.setBounds(100, 540, 200 , 30);
        add(state);

        stateField = new JTextField();
        stateField.setFont(new Font("Raleway", Font.BOLD , 14));
        stateField.setBounds(300, 540, 400, 30);
        add(stateField);


        JLabel country  = new JLabel("Country:");
        country.setFont(new Font("Raleway", Font.BOLD, 20 ));
        country.setBounds(100, 590, 200 , 30);
        add(country);

        countryField = new JTextField();
        countryField.setFont(new Font("Raleway", Font.BOLD , 14));
        countryField.setBounds(300, 590, 400, 30);
        add(countryField);


        JLabel zip  = new JLabel("ZIP:");
        zip.setFont(new Font("Raleway", Font.BOLD, 20 ));
        zip.setBounds(100, 640, 200 , 30);
        add(zip);

        zipField = new JTextField();
        zipField.setFont(new Font("Raleway", Font.BOLD , 14));
        zipField.setBounds(300, 640, 400, 30);
        add(zipField);

        JButton next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14 ) );
        next.setBounds(620, 690, 80, 30);
        add(next);
        next.addActionListener(this);
        
}
@Override
public void actionPerformed(ActionEvent ae) {
    // Get form data
    String formno = "" + random;
    String name = nameField.getText().trim();
    String father = fatherField.getText().trim();
    String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().trim();
    String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : null;
    String email = emailField.getText().trim();
    String maritalStatus = married.isSelected() ? "Married" : Unmarried.isSelected() ? "Single" : other.isSelected() ? "Other" : null;
    String address = addressField.getText().trim();
    String city = cityField.getText().trim();
    String state = stateField.getText().trim();
    String country = countryField.getText().trim();
    String zip = zipField.getText().trim();

    // Validate input
    if (name.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Name is required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (father.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Father's name is required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (dob.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Date of Birth is required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (gender == null) {
        JOptionPane.showMessageDialog(this, "Gender is required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (email.isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
        JOptionPane.showMessageDialog(this, "Valid email is required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (maritalStatus == null) {
        JOptionPane.showMessageDialog(this, "Marital status is required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (address.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Address is required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (city.isEmpty()) {
        JOptionPane.showMessageDialog(this, "City is required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (state.isEmpty()) {
        JOptionPane.showMessageDialog(this, "State is required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (country.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Country is required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (zip.isEmpty() || !zip.matches("\\d{5}(-\\d{4})?")) {  // Simple ZIP code validation
        JOptionPane.showMessageDialog(this, "Valid ZIP code is required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

   
    try {
        Conn c = new Conn();
        String query = "INSERT INTO signup (formno, name, father, dob, gender, email, maritalStatus, address, city, state, country, zip) " +
                       "VALUES('" + formno + "', '" + name + "', '" + father + "', '" + dob + "', '" + gender + "', '" + email + "', '" +
                       maritalStatus + "', '" + address + "', '" + city + "', '" + state + "', '" + country + "', '" + zip + "')";
        c.s.executeUpdate(query);
        setVisible(false);
        new Signup2(formno).setVisible(true);
    } catch (Exception e) {
        System.out.println(e);
    }
}
}