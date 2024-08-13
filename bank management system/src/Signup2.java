import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup2 extends JFrame implements ActionListener {

    JTextField idNo, ssnfield; 
    JButton next;
    String formno;
    JRadioButton syes, syno, eyes, eno;
    JComboBox<String> race, catCombo, inComboBox, eduComboBox, occuComboBox;

    Signup2(String formno) {
        
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
        setSize(850, 800);
        setLocation(350, 10);
        getContentPane().setBackground(Color.WHITE);

        JLabel additionalLabel = new JLabel("Page 2: Additional Details");
        additionalLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalLabel.setBounds(290, 80, 400, 40);
        add(additionalLabel);

        JLabel racebox = new JLabel("Race:");
        racebox.setBounds(100, 140, 100, 30);
        racebox.setFont(new Font("Raleway", Font.BOLD, 20));
        add(racebox);

        String[] valRace = {"Asian", "African", "White", "Native American", "Other"};
        race = new JComboBox<>(valRace);
        race.setBounds(300, 140, 400, 30);
        race.setBackground(Color.WHITE);
        add(race);

        JLabel father = new JLabel("Category:");
        father.setFont(new Font("Raleway", Font.BOLD, 20));
        father.setBounds(100, 190, 200, 30);
        add(father);

        String[] valCat = {"General", "Saving", "Checking", "Other"};
        catCombo = new JComboBox<>(valCat);
        catCombo.setBackground(Color.WHITE);
        catCombo.setBounds(300, 190, 400, 30);
        add(catCombo);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 400, 30);
        add(dob);

        String[] valIncome = {"None", "<20000", "<50000", "<100000", "Other"};
        inComboBox = new JComboBox<>(valIncome);
        inComboBox.setBackground(Color.WHITE);
        inComboBox.setBounds(300, 240, 400, 30);
        add(inComboBox);
        JLabel gender  = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20 ));
        gender.setBounds(100, 280, 200 , 30);
        add(gender);



        JLabel email  = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20 ));
        email.setBounds(100, 310, 200 , 30);
        add(email);

        String valEducation[] = {"HighSchool", "Bachelors", "Masters" ,"Phd","Other"};
        eduComboBox = new JComboBox<>(valEducation);
        eduComboBox.setBackground(Color.WHITE);
        eduComboBox.setBounds(300, 315, 200, 30);
        add(eduComboBox);


        JLabel ms = new JLabel("Occupation:");
        ms.setFont(new Font("Raleway", Font.BOLD, 20));
        ms.setBounds(100, 340, 200, 30);
        add(ms);

        String[] valOccupation = {"Salaried", "Self Employed", "Hourly", "Business", "Other"};
        occuComboBox = new JComboBox<>(valOccupation);
        occuComboBox.setBackground(Color.WHITE);
        occuComboBox.setBounds(300, 350, 400, 30);
        add(occuComboBox);

        JLabel address = new JLabel("SSN:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 390, 200, 30);
        add(address);

        ssnfield = new JTextField();
        ssnfield.setBounds(300, 390, 400, 30);
        ssnfield.setFont(new Font("Arial", Font.BOLD, 20));
        add(ssnfield);

        JLabel city = new JLabel("ID Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 440, 200, 30);
        add(city);

        idNo = new JTextField();
        idNo.setFont(new Font("Raleway", Font.BOLD, 14));
        idNo.setBounds(300, 440, 400, 30);
        add(idNo);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 490, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syno = new JRadioButton("No");
        syes.setBounds(300, 490, 100, 30);
        syes.setBackground(Color.WHITE);
        syno.setBounds(450, 490, 100, 30);
        syno.setBackground(Color.WHITE);
        add(syes);
        add(syno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(syno);

        JLabel zip = new JLabel("Existing Account:");
        zip.setFont(new Font("Raleway", Font.BOLD, 20));
        zip.setBounds(100, 540, 200, 30);
        add(zip);

        eyes = new JRadioButton("Yes");
        eno = new JRadioButton("No");
        eyes.setBounds(300, 540, 100, 30);
        eyes.setBackground(Color.WHITE);
        eno.setBounds(450, 540, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eyes);
        add(eno);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(eyes);
        accountGroup.add(eno);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 690, 80, 30);
        add(next);
        next.addActionListener(this);

        setVisible(true);
    }

   
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Retrieve form data
        String srace = (String) race.getSelectedItem();
        String category = (String) catCombo.getSelectedItem();
        String education = (String) eduComboBox.getSelectedItem();
        String income = (String) inComboBox.getSelectedItem();
        String occupation = (String) occuComboBox.getSelectedItem();
        String ssn = ssnfield.getText().trim();
        String id = idNo.getText().trim();
        String exisitingAcc = eyes.isSelected() ? "Yes" : eno.isSelected() ? "No" : null;
        String Senior = syes.isSelected() ? "Yes" : syno.isSelected() ? "No" : null;
    
        // Validation
        if (srace == null || srace.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Race is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (category == null || category.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Category is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (education == null || education.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Education is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (income == null || income.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Income is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (occupation == null || occupation.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Occupation is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (ssn.isEmpty() || !ssn.matches("\\d+")) {  // SSN should be numeric
            JOptionPane.showMessageDialog(this, "Valid SSN (numeric only) is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID number is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (exisitingAcc == null) {
            JOptionPane.showMessageDialog(this, "Existing account status is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Senior == null) {
            JOptionPane.showMessageDialog(this, "Senior citizen status is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // If all validations pass, insert data into the database
        try {
            Conn c = new Conn();
            String query = "INSERT INTO signup2 (formno, race, category, education, income, occupation, ssn, id, senior_citizen, existing_account) " +
                           "VALUES ('" + formno + "', '" + srace + "', '" + category + "', '" + education + "', '" + income + "', '" + occupation + "', '" +
                           ssn + "', '" + id + "', '" + Senior + "', '" + exisitingAcc + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details Added Successfully");
            setVisible(false);
            new Signup3(formno).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}