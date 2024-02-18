import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Splash extends JFrame implements ActionListener {
    Splash() {
        getContentPane().setBackground(new Color(227, 225, 217));
        setLayout(null);
        JLabel heading = new JLabel("Employee Management System");
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setBounds(0, 30, 1200, 60);

        try {
            // Load the font from the TTF or OTF file
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(
                    "C:\\Users\\tiger\\OneDrive\\Documents\\java\\CIA\\EmployeeManagementSystem\\Helvetica CE Bold.otf"));

            // Set the font size
            customFont = customFont.deriveFont(50f);

            // Set the font for the JLabel
            heading.setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); // Print the stack trace for debugging purposes
        }

        // Image label in the center
        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/Splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        // Continue button
        JButton Button = new JButton("Click Here To Continue");
        Button.setBounds(400, 400, 300, 70);
        Button.setBackground(new Color(32, 22, 88));
        Button.setForeground(new Color(227, 225, 217));
        Button.addActionListener(this);
        image.add(Button);

        // Add the JLabel to the JFrame
        add(heading);
        heading.setForeground(new Color(32, 22, 88));
        setSize(1170, 650);
        setLocation(200, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Animation for heading
        while (true) {
            heading.setVisible(true);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            heading.setVisible(false);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    // To override an abstract method from ActionListener
    @Override
    public void actionPerformed(ActionEvent action) {
        setVisible(false); // current frame closes
        new Login();
    }

    public static void main(String args[]) {
        new Splash();
    }
}
