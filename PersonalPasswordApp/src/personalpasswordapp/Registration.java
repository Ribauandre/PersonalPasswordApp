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
import javax.swing.JComboBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPasswordField;

/**
 *
 * @author bryaningram
 */
public class Registration extends JFrame {

    private JLabel label, message;
    private JTextField inputName, security;
    private JPasswordField inputPass, inputPass2;
    private JButton register, cancel;
    public String initUserName, initSecurity;
    private String initPassword;
    private String[] questions = {"","What is your best friends first name?", 
                "What is the name of your first high school?", "What is the name of your first pet?"};
    static JComboBox<String> q;

    public Registration() {
        super("Registration");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints c2 = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c2.fill = GridBagConstraints.BOTH;
        label = new JLabel("<HTML><FONT color=\"#00009\"><b><h3>Please Enter Username and Password</b></h3></FONT></HTML>");
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
        message = new JLabel("Re-enter: ");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        add(message, c);
        inputPass2 = new JPasswordField();
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 3;
        add(inputPass2, c);

        cancel = new JButton("Cancel");
        c2.gridwidth = 1;
        c2.gridx = 1;
        c2.gridy = 6;
        c2.anchor = GridBagConstraints.EAST;
        c2.weightx = 1;
        add(cancel, c2);
        cancel.addActionListener((ActionEvent event) -> {
            inputName.setText("");
            inputPass.setText("");
            inputPass2.setText("");
            security.setText("");
            inputName.setEditable(true);
            inputPass.setEditable(true);
            inputPass2.setEditable(true);
            security.setEditable(true);
        });

        register = new JButton("Register");
        c2.gridwidth = 1;
        c2.gridx = 2;
        c2.gridy = 6;
        c2.anchor = GridBagConstraints.EAST;
        add(register, c2);
        register.addActionListener((ActionEvent event) -> {
            initUserName = inputName.getText();
            initPassword = inputPass.getText();
            initSecurity = security.getText();
        });
        
        message = new JLabel("Security Question:");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 4;
        add(message, c);
        q = new JComboBox<>(questions);
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 4;
        add(q, c);
        message = new JLabel("Answer:");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 5;
        add(message, c);
        security = new JTextField();
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 5;
        add(security, c);
        
        Handler handler = new Handler();
        register.addActionListener(handler);
    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (inputName.getText().equals("") || inputPass.getText().equals("") || inputPass2.getText().equals("") || q.getSelectedItem().equals("") || security.getText().equals("")) {
                register.setEnabled(false);
                System.out.println("All fields must be filled");
                register.setEnabled(true);
            } else if (!inputPass.getText().equals(inputPass2.getText())) {
                register.setEnabled(false);
                System.out.println("Password Fields Don't Match");
                register.setEnabled(true);
            } else {
                register.setEnabled(true);
                if (initUserName == initUserName && initPassword == initPassword) {
                    label.setText("Registration Successfully Completed");
                    inputName.setEditable(false);
                    inputPass.setEditable(false);
                    inputName.setBackground(Color.LIGHT_GRAY);
                    inputPass.setBackground(Color.LIGHT_GRAY);
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("register.text"), true));
                        bw.write(inputName.getText());
                        bw.newLine();
                        bw.write(inputPass.getText());
                        bw.newLine();
                        bw.write((String) q.getSelectedItem());
                        bw.newLine();
                        bw.write(security.getText());
                        bw.newLine();
                        
                        bw.close();
                    } catch (IOException e) {
                        System.out.println("Error is " + e);
                    }
                    Login log = new Login();
                    log.setVisible(true);
                    log.setSize(400, 150);
                    log.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    dispose();
                }
            }

        }
    }

}
