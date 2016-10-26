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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
    private JButton login, cancel;
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

        cancel = new JButton("Cancel");
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 3;
        add(cancel, c);
        cancel.addActionListener((ActionEvent event) -> {
            inputName.setText("");
            inputPass.setText("");
            inputName.setEditable(true);
            inputPass.setEditable(true);
        });

        login = new JButton("Login");
        c.gridwidth = 1;
        c.gridx = 2;
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
                        System.out.println(line);
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
                if (inputName.getText().equals("") || inputPass.getText().equals(""))
                {
                    login.setEnabled(false);
                    System.out.println("Enter Username and Password");
                    login.setEnabled(true);
                }
                if (inputName.getText().equals("user") && inputPass.getText().equals("pass"))
                {
                    label.setText("Login Successful");
                    inputName.setEditable(false);
                    inputPass.setEditable(false);
                    inputName.setBackground(Color.LIGHT_GRAY);
                    inputPass.setBackground(Color.LIGHT_GRAY);
                }
                else
                {
                    System.out.println("Enter correct Username and Password");
                }

            }
        }
    public static boolean checkLogin(String username, String password) throws IOException {
        boolean checked = false;
        for (String line : Files.readAllLines(Paths.get("/path/to/file.txt"))) {
            /*It's not much.*/
        }

        return checked;
    }

}
