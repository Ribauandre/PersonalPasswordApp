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

    private JLabel label, message;
    private JTextField inputName, inputUser, inputPass;
    private JButton add, cancel;
    public String initUserName;
    public String initUser;
    private String initPassword;
    boolean equals = false;

    public Add() {
        super("Add");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        label = new JLabel("Please enter Account Info.");
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 0;
        add(label, c);
        message = new JLabel("Account Name ");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(message, c);
        inputName = new JTextField();
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        add(inputName, c);
        message = new JLabel("Account UserName ");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        add(message, c);
        inputUser = new JTextField();
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 2;
        add(inputUser, c);
        message = new JLabel("Account Pass ");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        add(message, c);
        inputPass = new JPasswordField();
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 3;
        add(inputPass, c);
        cancel = new JButton("Cancel");
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 4;
        add(cancel, c);
        cancel.addActionListener((ActionEvent event) -> {
            Account account = new Account();
                    account.setVisible(true);
                    account.setSize(400, 150);
                    account.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    dispose();
        });
        
        add = new JButton("Add");
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 4;
        add(add, c);
        add.addActionListener((ActionEvent event) -> {
            initUserName = inputName.getText();
            initPassword = inputPass.getText();
            initUser = inputUser.getText();
                
        });
        
        Handler handler = new Handler();
        add.addActionListener(handler);
    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event){
            boolean equals = false;
            for(int i = 0; i < Validation.accounts.size(); i++){
                if(inputName.getText().equals(Validation.accounts.get(i).accountName)){
                    equals = true;
                }
                
            }
            if (inputName.getText().equals("") || inputPass.getText().equals("") || inputUser.getText().equals("")) {
                System.out.println("Enter Username and Password");
                label.setText("All fields must be populated");
              
            }
            else if (equals) {

                System.out.println("Enter Username and Password");
                label.setText("Account Already Exists or Similar account.");
            }
            else {
                label.setText("Add Successfully Completed");
                inputName.setEditable(false);
                inputPass.setEditable(false);
                inputName.setBackground(Color.LIGHT_GRAY);
                inputPass.setBackground(Color.LIGHT_GRAY);
                try {
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
                    log.setSize(400, 150);
                    log.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    dispose();
                } catch (IOException e) {
                    System.out.println("Error is " + e);
                    label.setText("Add Successfully Completed");
                    inputName.setEditable(false);
                    inputPass.setEditable(false);
                    inputName.setBackground(Color.LIGHT_GRAY);
                    inputPass.setBackground(Color.LIGHT_GRAY);
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("accounts.text"), true));
                        bw.write(inputName.getText());
                        bw.newLine();
                        bw.write(inputUser.getText());
                        bw.newLine();
                        bw.write(inputPass.getText());
                        bw.newLine();
                        bw.close();
                    } catch (IOException i) {
                        System.out.println("Error is " + e);
                    }
                    Validation.accounts.clear();
                    Validation.list.clear();
                    Account log = new Account();
                    log.setVisible(true);
                    log.setSize(400, 150);
                    log.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    dispose();
                }
                    }
            
                
             
            }
        }
    }
