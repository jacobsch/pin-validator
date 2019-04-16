// Pin Validator Java Semi Final Project

// Register panel
    import java.awt.*; // Everything needed
    import javax.swing.*; // GUI
    import java.awt.event.*; // Making buttons and more work
    import org.json.simple.JSONObject; // Allowing us to create .json arrays
    import java.io.IOException; // Allowing more error control such as try/catch
    import java.nio.file.Files; // Writing our previously .json arrays as files
    import java.nio.file.Paths; // Being able to create file paths to write our files
    
    import javax.swing.JOptionPane; // Giving us more control with our Panels

    // Start of Panel1
    public class Panel1 extends JPanel {
    
        private JPanel container; // Adding the container locally so it does not interfere with the other panel files
        private JButton toLogin; // Adding the container locally so it does not interfere with the other panel files
        private JButton btnSubmit; // Adding the container locally so it does not interfere with the other panel files
        private JButton btnQuit; // Adding the container locally so it does not interfere with the other panel files
        private JButton btnClear; // Adding the container locally so it does not interfere with the other panel files
    
        JLabel lblTitle; // Init this label to the program as lblTitle;
        JLabel lblName1; // Init this label to the program
        JLabel lblName2; // Init this label to the program
        JLabel lblLine; // Init this label to the program
        JLabel lblpg; // Init this label to the program
        JLabel lblFirst; // Init this label to the program
        JTextField txtFirst; // Init this textfield to the program
        JLabel lblLast; // Init this label to the program
        JTextField txtLast; // Init this textfield to the program
        JLabel lblReqf; // Init this label to the program
        JPasswordField pwdPin; // Init this password field to the program
        JLabel lblPin; // Init this label to the program
        JLabel lblEmail; // Init this label to the program
        JLabel lblPhone; // Init this label to the program
        JLabel lblAge; // Init this label to the program
        JTextArea txtAge; // Init this textarea to the program
        JLabel lblAddress; // Init this label to the program
        JTextField txtAddress; // Init this textfield to the program
        JTextField txtPhone; // Init this textfield to the program
        JTextField txtEmail; // Init this textfield to the program
        JComboBox comboxGender; // Init this combobox to the program
        JLabel lblGender; // Init this label to the program
    
        public Panel1(JPanel c) {
            // Container for panel1
            container = c;
            this.setLayout(null); // Setting the layout to null
            initComponents(); // Running the method which is summoning our components to be rendered in the window
    
            toLogin = new JButton("I'm already registered"); // Adding a button
            toLogin.setBounds(75, 310, 180, 25); // Adding boundaries to the button
            this.add(toLogin); // Adding actions to the button
            this.setBackground(Color.RED); // Changing background colour when button pressed
            toLogin.addActionListener( new ActionListener() {
    
                public void actionPerformed(ActionEvent e) {
                    // This is the action to the button once pressed
                    CardLayout cardLayout = (CardLayout) container.getLayout(); // Running the next panel once pressed
                    cardLayout.show(container, "Login"); // Running the next panel
                }
    
            });
        }
    
        public void initComponents() {
            // This method will give values to all of the textfields, combobox, labels etc that we initialized earlier
            //construct array for combo box (pre-component)
            String[] comboxGenderItems = {"Male", "Female", "Vatougios"};
    
            //construct components
            lblTitle = new JLabel ("Bank of Jah"); // Giving value to our labels
            lblName1 = new JLabel ("By Owen Holman"); // Giving value to our labels
            lblName2 = new JLabel ("and Jacob Schwartz"); // Giving value to our labels
            lblLine = new JLabel ("-------------------------------"); // Giving value to our labels
            lblpg = new JLabel ("Register Page"); // Giving value to our labels
            lblFirst = new JLabel ("First Name *"); // Giving value to our labels
            txtFirst = new JTextField (5); // Giving value to our text field
            lblLast = new JLabel ("Last Name *"); // Giving value to our labels
            txtLast = new JTextField (5); // Giving value to our text field
            lblReqf = new JLabel ("* = required field"); // Giving value to our labels
            pwdPin = new JPasswordField (5); // Giving value to our password field
            lblPin = new JLabel ("Pin *"); // Giving value to our labels
            lblEmail = new JLabel ("Email *"); // Giving value to our labels
            lblPhone = new JLabel ("Phone # *"); // Giving value to our labels
            lblAge = new JLabel ("Age *"); // Giving value to our labels
            txtAge = new JTextArea (5, 5); // Giving value to our text area
            lblAddress = new JLabel ("Address *"); // Giving value to our labels
            txtAddress = new JTextField (5); // Giving value to our text field
            txtPhone = new JTextField (5); // Giving value to our text field
            txtEmail = new JTextField (5); // Giving value to our text field
            comboxGender = new JComboBox (comboxGenderItems); // Giving value to our combobox (the String array previously created (line70))
            lblGender = new JLabel ("Sex *"); // Giving value to our labels
    
            //set component bounds (only needed by Absolute Positioning)
            lblTitle.setBounds (330, 15, 80, 25); // Giving boundaries to our tags
            lblName1.setBounds (315, 45, 120, 25); // Giving boundaries to our tags
            lblName2.setBounds (307, 60, 125, 25); // Giving boundaries to our tags
            lblLine.setBounds (300, 30, 125, 25); // Giving boundaries to our tags
            lblFirst.setBounds (80, 115, 100, 25); // Giving boundaries to our tags
            txtFirst.setBounds (75, 135, 180, 25); // Giving boundaries to our tags
            lblLast.setBounds (80, 175, 100, 25); // Giving boundaries to our tags
            txtLast.setBounds (75, 195, 180, 25); // Giving boundaries to our tags
            lblReqf.setBounds (545, 95, 115, 25); // Giving boundaries to our tags
            pwdPin.setBounds (75, 245, 180, 25); // Giving boundaries to our tags
            lblPin.setBounds (80, 225, 100, 25); // Giving boundaries to our tags
            lblEmail.setBounds (280, 115, 100, 25); // Giving boundaries to our tags
            lblPhone.setBounds (280, 175, 100, 25); // Giving boundaries to our tags
            lblAge.setBounds (280, 225, 100, 25); // Giving boundaries to our tags
            txtAge.setBounds (275, 245, 180, 25); // Giving boundaries to our tags
            lblAddress.setBounds (470, 175, 100, 25); // Giving boundaries to our tags
            txtAddress.setBounds (470, 195, 180, 25); // Giving boundaries to our tags
            txtPhone.setBounds (275, 195, 180, 25); // Giving boundaries to our tags
            txtEmail.setBounds (275, 135, 180, 25); // Giving boundaries to our tags
            comboxGender.setBounds (470, 135, 180, 25); // Giving boundaries to our tags
            lblGender.setBounds (470, 115, 80, 25); // Giving boundaries to our tags
    
            add (lblTitle); //adding components to the window
            add (lblName1); //adding components to the window
            add (lblName2); //adding components to the window
            add (lblLine); //adding components to the window
            add (lblpg); //adding components to the window
            add (lblFirst); //adding components to the window
            add (txtFirst); //adding components to the window
            add (lblLast); //adding components to the window
            add (txtLast); //adding components to the window
            add (lblReqf); //adding components to the window
            add (pwdPin); //adding components to the window
            add (lblPin); //adding components to the window
            add (lblEmail); //adding components to the window
            add (lblPhone); //adding components to the window
            add (lblAge); //adding components to the window
            add (txtAge); //adding components to the window
            add (lblAddress); //adding components to the window
            add (txtAddress); //adding components to the window
            add (txtPhone); //adding components to the window
            add (txtEmail); //adding components to the window
            add (comboxGender); //adding components to the window
            add (lblGender); //adding components to the window
    
            btnSubmit = new JButton("Register"); //Giving the register button a label
            btnSubmit.setBounds (300, 310, 135, 25); //Giving the register button positioning and size
            add(btnSubmit); //Placing the submit button on the window
            btnSubmit.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //writing to the json file
                String fileName = txtFirst.getText() + txtLast.getText() + ".json"; //titling the json file
                String empty = ""; // Making error control much easier
                
                //If the form has any empty fields or errors we handle them here
                if (txtFirst.getText().equals(empty) || 
                    txtLast.getText().equals(empty) || 
                    txtEmail.getText().equals(empty) || 
                    txtPhone.getText().equals(empty) || 
                    txtAddress.getText().equals(empty) || 
                    pwdPin.getText().equals(empty) ||
                    txtAge.getText().equals(empty)) 
                {
                    JOptionPane.showMessageDialog(container, "Please fill in all the required fields!"); // Alert Box
                } else {
                    //if the form is valid we move on to here
                    try {
                        submitToJSON(fileName); // Naming the file the string from earlier
                        btnClear.doClick(); // Clearing the page if succesful
                        // Success Alert Box
                        JOptionPane.showMessageDialog(container, "Successfully registered!"); // Alert box
                        CardLayout cardLayout = (CardLayout) container.getLayout(); // Grabbing the next panel
                        cardLayout.show(container, "Login"); // Opening the next panel

                    } catch(Exception ex) {
                        // Error Handling
                        System.out.println("An Error Occured.");
                    }
                }
            }
        }); // End of btnSubmit
        
        //Creating a Clear button that resets all values of the boxs in the form
        btnClear = new JButton("Clear"); // Giving value to the button
        btnClear.setBounds (470, 245, 100, 25); // Giving placement properties to the button
        add(btnClear); // Adding the button to the window
        btnClear.addActionListener( new ActionListener() {
            String clr = ""; // Empty value to reset values too

            public void actionPerformed(ActionEvent e) {
                // Cleaning all the fields to the clr String (black)
                txtFirst.setText(clr);
                txtLast.setText(clr);
                txtAge.setText(clr);
                pwdPin.setText(clr);
                txtEmail.setText(clr);
                txtAddress.setText(clr);
                txtPhone.setText(clr);
                comboxGender.setSelectedIndex(2); //Setting the comboxGender box to the third option
            } // end of actionPerformed clr
        }); // End of btnClear

        btnQuit = new JButton("Quit"); // Giving value to the button
        btnQuit.setBounds (470, 310, 100, 25); // Giving placement properties to the button
        add(btnQuit); // Adding the button to the window
        btnQuit.addActionListener( new ActionListener() {
            //Action that happens when you press quit (it quits)
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Once clicked, program is quit
            } // end of actionPerformed quit

        }); // End of btnQuit
    } // End of initComponents
    //Creating the json array
    public void submitToJSON(String fileName) throws Exception {

        JSONObject information = new JSONObject(); // init the first object (array)
        // In the .json object (array) we previously created we will add the following:
        information.put("fname", txtFirst.getText());
        information.put("lname", txtLast.getText());
        information.put("age", Integer.parseInt(txtAge.getText())); // Parsing the age as a number
        information.put("pin", pwdPin.getText());
        information.put("email", txtEmail.getText());
        information.put("address", txtAddress.getText());
        information.put("phone", txtPhone.getText());
        information.put("sex", String.valueOf(comboxGender.getSelectedItem())); // Aquiring the String value of the combobox, rather than seeing "2" you see "Vatougios"
        //Writing the file to the /accounts path with the fileName created earlier
        Files.write(Paths.get("accounts/" + fileName), information.toJSONString().getBytes());

    } // End of submittoJSON

} // End of Panel1