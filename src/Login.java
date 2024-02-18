import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername, tfpassword;

    Login() {
        getContentPane().setBackground(new Color(255, 255, 255));
        setLayout(null);

        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(40, 20, 100, 30);
        add(lbusername);

        tfusername = new JTextField(); // Assign to the instance variable, not create a new local variable
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        JLabel lbpassword = new JLabel("Password");
        lbpassword.setBounds(40, 70, 100, 30);
        add(lbpassword);

        tfpassword = new JTextField(); // Assign to the instance variable, not create a new local variable
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        // Continue button
        JButton Button = new JButton("Login");
        Button.setBounds(150, 140, 150, 30);
        Button.setBackground(new Color(32, 22, 88));
        Button.setForeground(new Color(227, 225, 217));
        Button.addActionListener(this);
        add(Button);

        // Image label in the center
        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/Second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            Conn c = new Conn();

            String query = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
