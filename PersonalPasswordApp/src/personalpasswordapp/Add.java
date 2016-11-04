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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPasswordField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static personalpasswordapp.Validation.accounts;

/**
 *
 * @author andreribau
 */
public class Add extends JFrame {

    private JLabel label, name, pass, message;
    private JTextField inputName, inputUser;
    private JPasswordField inputPass;
    private JButton add, cancel;
    public String initUserName;
    private String initPassword;
    private String initUser;

    public Add() {

        super("Add");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        label = new JLabel("Please enter Account Name and password.");
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 0;
        add(label, c);

        JLabel message = new JLabel("Account Name");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(message, c);
        inputName = new JTextField();
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        add(inputName, c);

        message = new JLabel("Accoount UserName");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(message, c);
        inputName = new JTextField();
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        add(inputUser, c);

        message = new JLabel("Account Password");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(message, c);
        inputName = new JTextField();
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        add(inputPass, c);

        add = new JButton("Add");
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 3;
        add(add, c);
        add.addActionListener((ActionEvent event) -> {
            initUserName = inputName.getText();
            initUser = inputUser.getText();
            initPassword = inputPass.getText();
        });
        try {
            Validation.setAccount();
        } catch (IOException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        Handler handler = new Handler();
        add.addActionListener(handler);
    }

    class Handler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            for (int i = 0; i < Validation.accounts.size(); i++) {
                if (accounts.get(i).equals(initUser) || accounts.get(i).equals(initPassword) || accounts.get(i).equals(initUserName)) {
                    label.setText("Already exists.");
                } else {
                    try {
                        label.setText("Succsess!!!");
                        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("accounts.text"), true));
                        bw.write(inputName.getText());
                        bw.newLine();
                        bw.write(inputUser.getText());
                        bw.newLine();
                        bw.write(inputPass.getText());
                        bw.newLine();
                        bw.close();
                        Account log = new Account();
                        log.setVisible(true);
                        log.setSize(250, 150);
                        log.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        dispose();
                    } catch (IOException e) {
                        System.out.println("Error is " + e);
                    }
                }

            }
        }
    }
}
