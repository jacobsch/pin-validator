// Pin Validator Java Semi Final Project
/*
   Created by Owen Holman and Jacob Schwartz
   Pin Validator mimics a bank ATM
   Our program extends over 4 files and uses
   different windows. The program will read and write
   accounts into .json files so you can quit the program
   and will not lose information at the Bank of Jah
*/
// Importing Required packages
import java.awt.*; // Everything needed
import javax.swing.*; // GUI
import java.awt.event.*; // Making buttons work
import java.awt.event.ActionEvent; // Making buttons work
import java.awt.event.ActionListener; // Making buttons work

public class JahWindow extends JFrame {
	JPanel container;
	Panel1 register;
	Panel2 login;
	Panel3 accepted;
	// Panel4 accepted;

	public JahWindow() {

                this.setSize(750, 500);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setTitle("JahWindow");

                container = new JPanel();
                container.setLayout( new CardLayout());

                register = new Panel1(container);
                login = new Panel2(container);
                accepted = new Panel3(container);
                // accepted = new Panel4(container);

                container.add(register, "Register");
                container.add(login, "Login");
                // container.add(denied, "Denied");
                container.add(accepted, "Accepted");

                this.add(container);
                this.setVisible(true);
        }

        public static void main(String[] args) {
              new JahWindow(); //init the window, run the program
      }
}