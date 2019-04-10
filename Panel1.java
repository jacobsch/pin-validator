 // Pin Validator Java Semi Final Project
    import java.awt.*;
    import javax.swing.*;
    import java.awt.event.*;
    
    import org.json.simple.JSONObject;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Paths;
    
    import javax.swing.JOptionPane;
    
    public class Panel1 extends JPanel {
        // Init all buttons and tags in the program so we can use them later
        private JPanel container;
    
        private JButton toLogin;
        private JButton btnSubmit;
        private JButton btnQuit;
        private JButton btnClear;
    
        JLabel lblTitle;
        JLabel lblName1;
        JLabel lblName2;
        JLabel lblLine;
        JLabel lblpg;
        JLabel lblFirst;
        JTextField txtFirst;
        JLabel lblLast;
        JTextField txtLast;
        JLabel lblReqf;
        JPasswordField pwdPin;
        JLabel lblPin;
        JLabel lblEmail;
        JLabel lblPhone;
        JLabel lblAge;
        JTextArea txtAge;
        JLabel lblAddress;
        JTextField txtAddress;
        JTextField txtPhone;
        JTextField txtEmail;
        JComboBox comboxGender;
        JLabel lblGender;
    
        public Panel1(JPanel c) {
        // One of our panels
            container = c;
            this.setLayout(null);
            initComponents();
    
            toLogin = new JButton("I'm already registered");
            toLogin.setBounds(75, 310, 180, 25); // Adding text to the panel
            this.add(toLogin); // Adding button to the panel
            this.setBackground(Color.RED); // Giving background colour to the panel to differentiate them
            toLogin.addActionListener( new ActionListener() {
    
                public void actionPerformed(ActionEvent e) {
                    CardLayout cardLayout = (CardLayout) container.getLayout();
                    cardLayout.show(container, "Login"); // Performed after button is pressed
                }
    
            });
        }
    
        public void initComponents() {
            //Giving value to all our tags we initialized earlier
            //construct array for combo box (pre-component)
            String[] comboxGenderItems = {"Male", "Female", "Vatougios"};
    
            //construct components
            lblTitle = new JLabel ("Bank of Jah");
            lblName1 = new JLabel ("By Owen Holman");
            lblName2 = new JLabel ("and Jacob Schwartz");
            lblLine = new JLabel ("-------------------------------");
            lblpg = new JLabel ("Register Page");
            lblFirst = new JLabel ("First Name *");
            txtFirst = new JTextField (5);
            lblLast = new JLabel ("Last Name *");
            txtLast = new JTextField (5);
            lblReqf = new JLabel ("* = required field");
            pwdPin = new JPasswordField (5);
            lblPin = new JLabel ("Pin *");
            lblEmail = new JLabel ("Email *");
            lblPhone = new JLabel ("Phone # *");
            lblAge = new JLabel ("Age *");
            txtAge = new JTextArea (5, 5);
            lblAddress = new JLabel ("Address *");
            txtAddress = new JTextField (5);
            txtPhone = new JTextField (5);
            txtEmail = new JTextField (5);
            comboxGender = new JComboBox (comboxGenderItems);
            lblGender = new JLabel ("Sex *");
            //Giving our values positioning on the panels
            //set component bounds (only needed by Absolute Positioning)
            lblTitle.setBounds (330, 15, 80, 25);
            lblName1.setBounds (315, 45, 120, 25);
            lblName2.setBounds (307, 60, 125, 25);
            lblLine.setBounds (300, 30, 125, 25);
            lblFirst.setBounds (80, 115, 100, 25);
            txtFirst.setBounds (75, 135, 180, 25);
            lblLast.setBounds (80, 175, 100, 25);
            txtLast.setBounds (75, 195, 180, 25);
            lblReqf.setBounds (545, 95, 115, 25);
            pwdPin.setBounds (75, 245, 180, 25);
            lblPin.setBounds (80, 225, 100, 25);
            lblEmail.setBounds (280, 115, 100, 25);
            lblPhone.setBounds (280, 175, 100, 25);
            lblAge.setBounds (280, 225, 100, 25);
            txtAge.setBounds (275, 245, 180, 25);
            lblAddress.setBounds (470, 175, 100, 25);
            txtAddress.setBounds (470, 195, 180, 25);
            txtPhone.setBounds (275, 195, 180, 25);
            txtEmail.setBounds (275, 135, 180, 25);
            comboxGender.setBounds (470, 135, 180, 25);
            lblGender.setBounds (470, 115, 80, 25);
            //Actually adding the components to the panel
            //add components
            add (lblTitle);
            add (lblName1);
            add (lblName2);
            add (lblLine);
            add (lblpg);
            add (lblFirst);
            add (txtFirst);
            add (lblLast);
            add (txtLast);
            add (lblReqf);
            add (pwdPin);
            add (lblPin);
            add (lblEmail);
            add (lblPhone);
            add (lblAge);
            add (txtAge);
            add (lblAddress);
            add (txtAddress);
            add (txtPhone);
            add (txtEmail);
            add (comboxGender);
            add (lblGender);
    
            btnSubmit = new JButton("Register"); //Giving the register button a label
            btnSubmit.setBounds (300, 310, 135, 25); //Giving the register button possitioning and size
            add(btnSubmit); //Placing the submit button on the window
            btnSubmit.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //writing to the json file
                String fileName = txtFirst.getText() + txtLast.getText() + ".json"; //titling the json file
                String empty = "";
                
                //If the form has any empty fields or errors we handle them here
                if (txtFirst.getText().equals(empty) || 
                    txtLast.getText().equals(empty) || 
                    txtEmail.getText().equals(empty) || 
                    txtPhone.getText().equals(empty) || 
                    txtAddress.getText().equals(empty) || 
                    pwdPin.getText().equals(empty) ||
                    txtAge.getText().equals(empty)) 
                {
                    // Alert Box
                    JOptionPane.showMessageDialog(container, "Please fill in all the required fields!");

                } else {
                    try {
                        submitToJSON(fileName);
                        btnClear.doClick();
                        // Success Alert Box
                        JOptionPane.showMessageDialog(container, "Successfully registered!");

                    } catch(Exception ex) {
                        // Error Handling
                        System.out.println("An Error Occured.");
                    }
                }
            }
        });
        
        //Creating a Clear button that resets all values of the boxs in the form
        btnClear = new JButton("Clear"); //Giving value to the button
        btnClear.setBounds (470, 245, 100, 25); //Giving placement properties to the button
        add(btnClear); // Adding the button to the window
        btnClear.addActionListener( new ActionListener() {
            // Empty value to reset values too
            String clr = "";

            public void actionPerformed(ActionEvent e) {
                txtFirst.setText(clr);
                txtLast.setText(clr);
                txtAge.setText(clr);
                pwdPin.setText(clr);
                txtEmail.setText(clr);
                txtAddress.setText(clr);
                txtPhone.setText(clr);
                comboxGender.setSelectedIndex(2); //Setting the comboxGender box to the third option
            }

        });

        btnQuit = new JButton("Quit"); //Giving value to the button
        btnQuit.setBounds (470, 310, 100, 25); //Giving placement properties to the button
        add(btnQuit); // Adding the button to the window
        btnQuit.addActionListener( new ActionListener() {
            //Action that happens when you press quit (it quits)
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
    }
    //Creating the json array
    public void submitToJSON(String fileName) throws Exception {

        JSONObject information = new JSONObject();
        information.put("fname", txtFirst.getText());
        information.put("lname", txtLast.getText());
        information.put("age", Integer.parseInt(txtAge.getText()));
        information.put("pin", pwdPin.getText());
        information.put("email", txtEmail.getText());
        information.put("address", txtAddress.getText());
        information.put("phone", txtPhone.getText());
        information.put("sex", String.valueOf(comboxGender.getSelectedItem()));
        //Writing the file to the /accounts path with the fileName created earlier
        Files.write(Paths.get("accounts/"+fileName), information.toJSONString().getBytes());

    }

}