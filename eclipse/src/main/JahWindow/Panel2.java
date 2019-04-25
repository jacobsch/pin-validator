package main.JahWindow;
// Pin Validator Java Semi Final Project

// Login panel
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONObject; // Allowing us to create .json arrays
import org.json.simple.parser.JSONParser; // Allowing us to parse the json
import java.io.FileReader; // Allowing us to read the .json file we wrote in panel1

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane; // Giving us more control with our Panels
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// Start of Panel2
@SuppressWarnings("serial")
public class Panel2 extends JPanel {

	private JPanel container; // Adding the container locally so it does not interfere with the other panel
								// files
	Panel3 accepted; // for Panel3 (line 36)

	private JButton btnLogin; // Adding the container locally so it does not interfere with the other panel
								// files
	private JButton toRegister; // Adding the container locally so it does not interfere with the other panel
								// files
	private JButton btnQuit; // Adding the container locally so it does not interfere with the other panel
								// files
	private JButton btnClear; // Adding the container locally so it does not interfere with the other panel
								// files

	JLabel lblTitle; // Init this label to the program
	JLabel lblName1; // Init this label to the program
	JLabel lblName2; // Init this label to the program
	JLabel lblLine; // Init this label to the program
	JLabel lblpg; // Init this label to the program
	JLabel lblFirst; // Init this label to the program
	JTextField txtFirst; // Init this textfield to the program
	JLabel lblLast; // Init this label to the program
	JTextField txtLast; // Init this textfield to the program
	JPasswordField pwdPin; // Init this password field to the program
	JLabel lblPin; // Init this label to the program
	JLabel lblEmail; // Init this label to the program
	JTextField txtEmail; // Init this textfield to the program

	public Panel2(JPanel c) {
		// Container for panel2
		container = c;
		this.setLayout(null); // Setting the layout to null
		initComponents(); // Running the method which is summoning our components to be rendered in the
							// window

		toRegister = new JButton("Make an account"); // Adding a button
		toRegister.setBounds(75, 245, 180, 25); // Adding boundaries to the button
		this.add(toRegister); // Adding actions to the button
		this.setBackground(Color.YELLOW); // Changing background colour when button pressed
		toRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// This is the action to the button once pressed
				CardLayout cardLayout = (CardLayout) container.getLayout(); // Running the next panel once pressed
				cardLayout.show(container, "Register"); // Running the next panel
			}
		});
	}

	public void initComponents() {

		// construct components
		lblTitle = new JLabel("Bank of Jah"); // Giving value to our labels
		lblName1 = new JLabel("By Owen Holman"); // Giving value to our labels
		lblName2 = new JLabel("and Jacob Schwartz"); // Giving value to our labels
		lblLine = new JLabel("-------------------------------"); // Giving value to our labels
		lblpg = new JLabel("Login Page"); // Giving value to our labels
		lblFirst = new JLabel("First Name *"); // Giving value to our labels
		txtFirst = new JTextField(5); // Giving value to our text field
		lblLast = new JLabel("Last Name *"); // Giving value to our labels
		txtLast = new JTextField(5); // Giving value to our text field
		pwdPin = new JPasswordField(5); // Giving value to our text field
		lblPin = new JLabel("Pin *"); // Giving value to our labels
		lblEmail = new JLabel("Email *"); // Giving value to our labels
		txtEmail = new JTextField(5); // Giving value to our text field

		// set component bounds (only needed by Absolute Positioning)
		lblTitle.setBounds(330, 15, 80, 25); // Giving boundaries to our tags
		lblName1.setBounds(315, 45, 120, 25); // Giving boundaries to our tags
		lblName2.setBounds(307, 60, 125, 25); // Giving boundaries to our tags
		lblLine.setBounds(300, 30, 125, 25); // Giving boundaries to our tags
		lblFirst.setBounds(80, 115, 100, 25); // Giving boundaries to our tags
		txtFirst.setBounds(75, 135, 180, 25); // Giving boundaries to our tags
		lblLast.setBounds(80, 175, 100, 25); // Giving boundaries to our tags
		txtLast.setBounds(75, 195, 180, 25); // Giving boundaries to our tags
		pwdPin.setBounds(275, 195, 180, 25); // Giving boundaries to our tags
		lblPin.setBounds(280, 175, 100, 25); // Giving boundaries to our tags
		lblEmail.setBounds(280, 115, 100, 25); // Giving boundaries to our tags
		txtEmail.setBounds(275, 135, 180, 25); // Giving boundaries to our tags

		// add components
		add(lblTitle); // adding components to the window
		add(lblName1); // adding components to the window
		add(lblName2); // adding components to the window
		add(lblLine); // adding components to the window
		add(lblpg); // adding components to the window
		add(lblFirst); // adding components to the window
		add(txtFirst); // adding components to the window
		add(lblLast); // adding components to the window
		add(txtLast); // adding components to the window
		add(pwdPin); // adding components to the window
		add(lblPin); // adding components to the window
		add(lblEmail); // adding components to the window
		add(txtEmail); // adding components to the window

		btnLogin = new JButton("Login"); // Giving the login button a label
		btnLogin.setBounds(300, 245, 135, 25); // Giving the login button positioning and size
		add(btnLogin); // adding component to the window
		btnLogin.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String fileName = txtFirst.getText() + txtLast.getText() + ".json"; // recreating the json title so we
																					// can match the file with the user
																					// assuming they already created an
																					// account
				String empty = ""; // Making error control much easier

				String inputEmail = txtEmail.getText(); // Adding inputString for the next part of code
				String inputPin = pwdPin.getText(); // Adding inputString for the next part of code

				// If any of these boxs are empty a prompt will appear alerting user to fill in
				// all required fields
				if (txtFirst.getText().equals(empty) || txtLast.getText().equals(empty)
						|| txtEmail.getText().equals(empty) || pwdPin.getText().equals(empty)) {
					JOptionPane.showMessageDialog(container, "Please fill in all the required fields!"); // Alert Box

				} else {
					try {
						// if all fields are valid we move onto here
						// if account name, email and password are a match this statement is true and it
						// is executed
						if (checkJSON(fileName, inputEmail, inputPin)) {
							JOptionPane.showMessageDialog(container, "Valid!"); // Valid alert popup

							accepted = new Panel3(container); // init panel3 in the window
							container.add(accepted, "Accepted"); // Add panel3 to the window

							CardLayout cardLayout = (CardLayout) container.getLayout(); // Opening panel3
							cardLayout.show(container, "Accepted"); // Running the next container

						} else {
							JOptionPane.showMessageDialog(container, "Invalid!"); // Alert prompt saying info is
																					// Invalid!
						}
						btnClear.doClick(); // Running the method so you return to a window with empty fields

					} catch (Exception ex) {
						System.out.println("An Error Occured."); // Error Handling
					}
				}
			}
		}); // end of btnLogin actionListener

		btnClear = new JButton("Clear"); // Giving value to the button
		btnClear.setBounds(470, 135, 100, 25); // Giving placement properties to the button
		add(btnClear); // Adding the button to the window
		btnClear.addActionListener(new ActionListener() {

			String clr = ""; // Empty value to reset values too

			public void actionPerformed(ActionEvent e) {
				// Cleaning all the fields to the clr String (black)
				txtFirst.setText(clr);
				txtLast.setText(clr);
				pwdPin.setText(clr);
				txtEmail.setText(clr);
			} // end of actionPerformed clr
		}); // end of btnClear

		btnQuit = new JButton("Quit"); // Giving value to the button
		btnQuit.setBounds(470, 195, 100, 25); // Giving placement properties to the button
		add(btnQuit); // Adding the button to the window
		btnQuit.addActionListener(new ActionListener() {
			// Action that happens when you press quit (it quits)
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Once clicked, program is quit
			} // end of actionPerformed quit

		}); // end of btnQuit
	} // end of initComponents

	public boolean checkJSON(String fileName, String inputEmail, String inputPin) throws Exception {
		// creating a boolean to confirm json is valid
		// String content = new String(Files.readAllBytes(Paths.get(fileName)));

		JSONObject databaseInfo = (JSONObject) readJSON("src/accounts/" + fileName); // init .json object of our file, basically bringing
																	// the file into our code

		String dbPin = String.valueOf(databaseInfo.get("pin")); // Creating the String to pull data out of json array
		String dbEmail = String.valueOf(databaseInfo.get("email")); // Creating the String to pull data out of json
																	// array

		String userPin = inputPin; // Creating the String to pull data out of json array
		String userEmail = inputEmail; // Creating the String to pull data out of json array

		if (userPin.equals(dbPin) && userEmail.equalsIgnoreCase(dbEmail)) {
			return true; // returns valid
		}

		return false; // returns invalid

	} // end of checkJSON

	public Object readJSON(String fileName) throws Exception {
		// has "accounts/" because it is in a folder
		FileReader reader = new FileReader(fileName); // pulling file
		JSONParser jsonParser = new JSONParser(); // parse file

		return jsonParser.parse(reader); // return the parsed file ready to be crawled

	} // end of readJSON

} // End of Panel2