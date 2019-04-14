import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

public class Panel2 extends JPanel {

    private JPanel container;
    Panel3 accepted;

    private JButton toRegister;
    private JButton btnLogin;
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
    JPasswordField pwdPin;
    JLabel lblPin;
    JLabel lblEmail;
    JTextField txtEmail;

    public Panel2(JPanel c) {

      container = c;
      this.setLayout(null);
      initComponents();

      toRegister = new JButton("Make an account");
      toRegister.setBounds(75, 245, 180, 25);
      this.add(toRegister);
      this.setBackground(Color.YELLOW);
      toRegister.addActionListener( new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            CardLayout cardLayout = (CardLayout) container.getLayout();
            cardLayout.show(container, "Register");
        }
    });
  }

    public void initComponents() {

            //construct components
        lblTitle = new JLabel ("Bank of Jah");
        lblName1 = new JLabel ("By Owen Holman");
        lblName2 = new JLabel ("and Jacob Schwartz");
        lblLine = new JLabel ("-------------------------------");
        lblpg = new JLabel ("Login Page");
        lblFirst = new JLabel ("First Name *");
        txtFirst = new JTextField (5);
        lblLast = new JLabel ("Last Name *");
        txtLast = new JTextField (5);
        pwdPin = new JPasswordField (5);
        lblPin = new JLabel ("Pin *");
        lblEmail = new JLabel ("Email *");
        txtEmail = new JTextField (5);

        //set component bounds (only needed by Absolute Positioning)
        lblTitle.setBounds (330, 15, 80, 25);
        lblName1.setBounds (315, 45, 120, 25);
        lblName2.setBounds (307, 60, 125, 25);
        lblLine.setBounds (300, 30, 125, 25);
        lblFirst.setBounds (80, 115, 100, 25);
        txtFirst.setBounds (75, 135, 180, 25);
        lblLast.setBounds (80, 175, 100, 25);
        txtLast.setBounds (75, 195, 180, 25);
        pwdPin.setBounds (275, 195, 180, 25);
        lblPin.setBounds (280, 175, 100, 25);
        lblEmail.setBounds (280, 115, 100, 25);
        txtEmail.setBounds (275, 135, 180, 25);

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
        add (pwdPin);
        add (lblPin);
        add (lblEmail);
        add (txtEmail);

        btnLogin = new JButton("Login");
        btnLogin.setBounds (300, 245, 135, 25);
        add(btnLogin);
        btnLogin.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String fileName = txtFirst.getText() + txtLast.getText() + ".json";
                String empty = "";

                String inputEmail = txtEmail.getText();
                String inputPin = pwdPin.getText();

                if (txtFirst.getText().equals(empty) || 
                    txtLast.getText().equals(empty) || 
                    txtEmail.getText().equals(empty) ||  
                    pwdPin.getText().equals(empty))
                {
                        // Alert Box
                    JOptionPane.showMessageDialog(container, "Please fill in all the required fields!");

                } else {
                    try {
                      if (checkJSON(fileName, inputEmail, inputPin)) {
                        JOptionPane.showMessageDialog(container, "Valid!");

                        accepted = new Panel3(container); //init panels in the window
                        container.add(accepted, "Accepted");

                        CardLayout cardLayout = (CardLayout) container.getLayout();
                        cardLayout.show(container, "Accepted");

                    } else {
                        JOptionPane.showMessageDialog(container, "Invalid!");
                    }
                    btnClear.doClick();

                } catch(Exception ex) {
                            // Error Handling
                    System.out.println("An Error Occured.");
                }
            }
        }
    });

        btnClear = new JButton("Clear");
        btnClear.setBounds (470, 135, 100, 25);
        add(btnClear);
        btnClear.addActionListener( new ActionListener() {

            String clr = "";

            public void actionPerformed(ActionEvent e) {
                txtFirst.setText(clr);
                txtLast.setText(clr);
                pwdPin.setText(clr);
                txtEmail.setText(clr);
            }

        });

        btnQuit = new JButton("Quit");
        btnQuit.setBounds (470, 195, 100, 25);
        add(btnQuit);
        btnQuit.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
    }

    public boolean checkJSON(String fileName, String inputEmail, String inputPin) throws Exception {

            // String content = new String(Files.readAllBytes(Paths.get(fileName)));


        JSONObject databaseInfo = (JSONObject) readJSON(fileName);

        String dbPin = String.valueOf(databaseInfo.get("pin"));
        String dbEmail = String.valueOf(databaseInfo.get("email"));

        String userPin = inputPin;
        String userEmail = inputEmail;

        if (userPin.equals(dbPin) && userEmail.equalsIgnoreCase(dbEmail)) {
            return true;
        }

        return false;

    }

    public Object readJSON(String fileName) throws Exception {

        FileReader reader = new FileReader("accounts/" + fileName);
        JSONParser jsonParser = new JSONParser();

        return jsonParser.parse(reader);

    }

}