// Pin Validator Java Semi Final Project

// Jah
import java.awt.*; // Everything needed
import javax.swing.*; // GUI
import java.awt.event.*; // Making buttons and more work
import java.awt.image.BufferedImage; // Allow images to work
import javax.imageio.ImageIO; // Allow images to work
import java.io.*; // Allow external sources
import java.io.File; // Allow external files
import javax.swing.JOptionPane; // Giving us more control with our Panels
import java.io.FileInputStream; // Allow files to work in program
import java.io.InputStream; // Allow files to work in program

// Start of Panel3
public class Panel3 extends JPanel {

    private JPanel container; // Adding the container locally so it does not interfere with the other panel files
    private Panel3 accepted; // Adding the container locally so it does not interfere with the other panel files
    private JButton toLogin; // Adding the container locally so it does not interfere with the other panel files
    private JButton btnQuit; // Adding the container locally so it does not interfere with the other panel files
    // private AudioStream audioStream; // Creating a private variable to hold the audio that plays

    JLabel lblTitle; // Init this label to the program
    JLabel lblName1; // Init this label to the program
    JLabel lblName2; // Init this label to the program
    JLabel lblLine; // Init this label to the program
    JLabel lblpg; // Init this label to the program

    public Panel3(JPanel c) {

        accepted = this; // from Panel2 (line 21)

        container = c;
        this.setLayout(null); // Setting the layout to null
        initComponents(); // Running the method which is summoning our components to be rendered in the window

        // music("play"); Playing some toons! ♪

        toLogin = new JButton("Logout"); // Adding a button
        toLogin.setBounds (300, 365, 135, 25); // Adding boundaries to the button
        this.add(toLogin); // Adding actions to the button
        this.setBackground(Color.GREEN); // Changing background colour when button pressed
        toLogin.addActionListener( new ActionListener() {
            // action when btn clicked
            public void actionPerformed(ActionEvent e) {
                
                c.remove(accepted);
                revalidate();
                repaint();
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "Login");
                
            } // end of actionPerformed
        }); // end of toLogin btn

    } // End of Panel3

    public void initComponents() {

        //construct components
        lblTitle = new JLabel ("Bank of Jah"); // Giving value to our labels
        lblName1 = new JLabel ("By Owen Holman"); // Giving value to our labels
        lblName2 = new JLabel ("and Jacob Schwartz"); // Giving value to our labels
        lblLine = new JLabel ("-------------------------------"); // Giving value to our labels
        lblpg = new JLabel ("Account Page"); // Giving value to our labels
        
        //set component bounds (only needed by Absolute Positioning)
        lblTitle.setBounds (330, 15, 80, 25); // Giving boundaries to our tags
        lblName1.setBounds (315, 45, 120, 25); // Giving boundaries to our tags
        lblName2.setBounds (307, 60, 125, 25); // Giving boundaries to our tags
        lblLine.setBounds (300, 30, 125, 25); // Giving boundaries to our tags

        //add components
        add (lblTitle); //adding components to the window
        add (lblName1); //adding components to the window
        add (lblName2); //adding components to the window
        add (lblLine); //adding components to the window
        add (lblpg); //adding components to the window

        try {

            BufferedImage xPic = ImageIO.read(new File("src/xxxtentacion.jpg")); // init image to the panel
            Image sclImg = xPic.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            ImageIcon imgIcon = new ImageIcon(sclImg);
            JLabel picLabel = new JLabel(imgIcon); // Giving value to the image
            picLabel.setBounds(225, 100, 250, 250); // Giving boundaries to our image
            add(picLabel); // adding image to the panel

        } catch(Exception ex) {
            JOptionPane.showMessageDialog(container, "Image Exception!");
        }
        //Adding quit functionality and quit button to the program
        btnQuit = new JButton("Quit"); // Giving value to the button
        btnQuit.setBounds(300, 400, 135, 25); // Giving placement properties to the button
        add(btnQuit); // Adding the button to the window
        btnQuit.addActionListener( new ActionListener() {
            //Action that happens when you press quit (it quits)
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Once clicked, program is quit
            } // end of actionPerformed quit

        }); // end of btnQuit
    } // end of initComponents

} 

// end of file