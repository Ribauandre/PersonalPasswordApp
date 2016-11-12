/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPasswordField;
import static personalpasswordapp.Registration.q;

/**
 *
 * @author rds5451
 */
public class SecurityKEy extends JFrame {

    private JLabel label, message, question;
    private JButton add;
    public JTextField inputSecurityKey;
    private JButton Submit, cancel, back;

    public SecurityKEy() {

        super("SecurityKEy");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        label = new JLabel("Please answer security question.");
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 0;
        add(label, c);

        message = new JLabel("Security Question: ");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(message, c);
        //inputSecurityQ = new JScoll():

        message = new JLabel("Answer: ");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        add(message, c);
        inputSecurityKey = new JTextField();
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 2;
        add(inputSecurityKey, c);

        back = new JButton("Back");
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 4;
        add(back, c);
        back.addActionListener((ActionEvent e) -> {
            Login log = new Login();
            log.setVisible(true);
            log.setSize(400, 150);
            log.setDefaultCloseOperation(EXIT_ON_CLOSE);
            dispose();
        });

        cancel = new JButton("Cancel");
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 3;
        add(cancel, c);
        cancel.addActionListener((ActionEvent event) -> {
            inputSecurityKey.setText("");
        });

        Submit = new JButton("Submit");
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 3;
        add(Submit, c);
        Submit.addActionListener((ActionEvent event) -> {
            try {
                Validation.setUserPass();
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!inputSecurityKey.getText().equals(Validation.security)) {
                Submit.setEnabled(false);
                System.out.println("Security answer does not match.");
                Submit.setEnabled(true);
            } else {
                Submit.setEnabled(true);
                System.out.println("Your password is: "+Validation.pass);
                Login login = new Login();
                login.setVisible(true);
                login.setSize(400, 150);
                login.setDefaultCloseOperation(EXIT_ON_CLOSE);
                dispose();
            }
        });

        try {
            Validation.setUserPass();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        question = new JLabel(Validation.q);
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        add(question, c);
    }
}
