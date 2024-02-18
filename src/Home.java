import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame
        implements ActionListener {
    JButton view, add, update, remove;

    Home() {
        setLayout(null);
        setSize(1120, 630);
        setLocation(250, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Image label in the center
        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setBounds(0, 30, 1120, 60);

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
        heading.setForeground(new Color(32, 22, 88));

        image.add(heading);

        // Centering the buttons horizontally and vertically
        int buttonWidth = 150;
        int buttonHeight = 40;

        int centerX = (1120 - buttonWidth) / 2;
        int centerY = (630 - buttonHeight * 4) / 2;

        add = new JButton("Add Employees");
        add.setBounds(centerX, centerY, buttonWidth, buttonHeight);
        add.setBackground(new Color(32, 22, 88));
        add.setForeground(new Color(227, 225, 217));
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employees");
        view.setBounds(centerX, centerY + 60, buttonWidth, buttonHeight);
        view.setBackground(new Color(32, 22, 88));
        view.setForeground(new Color(227, 225, 217));
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Employees");
        update.setBounds(centerX, centerY + 120, buttonWidth, buttonHeight);
        update.setBackground(new Color(32, 22, 88));
        update.setForeground(new Color(227, 225, 217));
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove Employees");
        remove.setBounds(centerX, centerY + 180, buttonWidth, buttonHeight);
        remove.setBackground(new Color(32, 22, 88));
        remove.setForeground(new Color(227, 225, 217));
        remove.addActionListener(this);
        image.add(remove);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == remove) {
            setVisible(false);
            new RemoveEmployee();
        }
    }
}
