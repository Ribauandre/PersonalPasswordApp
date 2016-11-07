/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author bryaningram
 */
public class Login extends JFrame {

    String fileName = "temp.txt";
    String line = null;
    private JLabel label, message;
    private JTextField inputName;
    private JPasswordField inputPass;
    private JButton login, cancel, reset;
    public String initUserName;
    private String initPassword;

    public Login() {
        super("Login");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        label = new JLabel("Please enter Username and Password.");
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 0;
        add(label, c);

        message = new JLabel("Username: ");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(message, c);
        inputName = new JTextField();
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        add(inputName, c);
        message = new JLabel("Password: ");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        add(message, c);
        inputPass = new JPasswordField();
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 2;
        add(inputPass, c);

     reset = new JButton("<HTML><FONT color=\"#00009\"><u>Forgot password?</U></FONT></HTML>");
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 2;
        reset.setHorizontalAlignment(SwingConstants.LEFT);
        reset.setBorderPainted(false);
        reset.setOpaque(false);
        reset.setBackground(Color.WHITE);
        reset.setToolTipText("Reset password");
        add(reset, c);
        reset.addActionListener((ActionEvent event) -> {
            SecurityKEy sequrQestion = new SecurityKEy();
                    sequrQestion.setVisible(true);
                    sequrQestion.setSize(400, 150);
                    sequrQestion.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    dispose();
        });

        login = new JButton("Login");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 3;
        add(login, c);
        login.addActionListener((ActionEvent event) -> {
            initUserName = inputName.getText();
            initPassword = inputPass.getText();
        });

        LoginHandler handler = new LoginHandler();
        login.addActionListener(handler);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    FileReader file = new FileReader("register.text");
                    BufferedReader br = new BufferedReader(file);
                    String line;

                    while ((line = br.readLine()) != null) {
                    }
                } catch (IOException e) {
                    System.out.println("Error is " + e);
                }
            }
        });
        
    }
    
    class LoginHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                try {
                    Validation.setUserPass();
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (inputName.getText().equals("") || inputPass.getText().equals(""))
                {
                    login.setEnabled(false);
                    System.out.println("Enter Username and Password");
                    login.setEnabled(true);
                    
                }
                if (inputName.getText().equals(Validation.user) && inputPass.getText().equals(Validation.pass))
                {
                    label.setText("Login Successful");
                    inputName.setEditable(false);
                    inputPass.setEditable(false);
                    inputName.setBackground(Color.LIGHT_GRAY);
                    inputPass.setBackground(Color.LIGHT_GRAY);
                    Account account = new Account();
                    account.setVisible(true);
                    account.setSize(400, 150);
                    account.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    dispose();
                }
                else
                {
                    System.out.println("Enter correct Username and Password");
                    label.setText("Incorrect Login");
                }

            }
        }
}
