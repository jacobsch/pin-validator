// Pin Validator Java Semi Final Project
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.io.File;

import javax.swing.JOptionPane;

public class Panel3 extends JPanel {

    private JPanel container;

    private JButton toLogin;
    private JButton btnQuit;

    JLabel lblTitle;
    JLabel lblName1;
    JLabel lblName2;
    JLabel lblLine;
    JLabel lblpg;

    public Panel3(JPanel c) {

        container = c;
        this.setLayout(null);
        initComponents();

        toLogin = new JButton("Logout");
        toLogin.setBounds (300, 365, 135, 25);
        this.add(toLogin);
        this.setBackground(Color.GREEN);
        toLogin.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "Login");
            }
        });
    }

    public void initComponents() {

        //construct components
        lblTitle = new JLabel ("Bank of Jah");
        lblName1 = new JLabel ("By Owen Holman");
        lblName2 = new JLabel ("and Jacob Schwartz");
        lblLine = new JLabel ("-------------------------------");
        lblpg = new JLabel ("Account Page");

        lblTitle.setBounds (330, 15, 80, 25);
        lblName1.setBounds (315, 45, 120, 25);
        lblName2.setBounds (307, 60, 125, 25);
        lblLine.setBounds (300, 30, 125, 25);

        //add components
        add (lblTitle);
        add (lblName1);
        add (lblName2);
        add (lblLine);
        add (lblpg);

        try {

            BufferedImage xPic = ImageIO.read(new File("src/xxxtentacion.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(xPic));
            picLabel.setBounds(125, 100, 500, 250);
            add(picLabel);

        } catch(Exception ex) {
            JOptionPane.showMessageDialog(container, "Image Exception!");
        }
        //Adding quit functionality and quit button to the program
        btnQuit = new JButton("Quit");
        btnQuit.setBounds(300, 400, 135, 25);
        add(btnQuit);
        btnQuit.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
    }

}