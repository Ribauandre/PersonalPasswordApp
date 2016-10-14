/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;

import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.JPasswordField;

/**
 *
 * @author bryaningram
 */
public class Registration extends JFrame {
    
    private JLabel label, message;
    private JTextField inputName;
    private JPasswordField inputPass;
    private JButton register;
    public String initUserName;
    private String initPassword;
    
    public Registration()
    {
        super("Registration");
        setLayout(new FlowLayout(FlowLayout.LEADING));
        label = new JLabel("Please enter Username and Password.");
        add(label);
        
        message = new JLabel("Username: ");
        add(message);
        inputName = new JTextField(10);
        add(inputName);
        message = new JLabel("Password: ");
        add(message);
        inputPass = new JPasswordField(10);
        add(inputPass);
        
        register = new JButton("Register");
        add(register);
        register.addActionListener((ActionEvent event) -> {
            initUserName = inputName.getText();
            initPassword = inputPass.getText();
        });

        Handler handler = new Handler();
        register.addActionListener(handler);
        
        register.addActionListener(new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent event)
             {
                 try 
                 {
                     BufferedWriter bw = new BufferedWriter(new FileWriter(new File("register.text"), true));
                     bw.write(inputName.getText());
                     bw.newLine();
                     bw.write(inputPass.getText());
                     bw.newLine();
                     bw.close();
                 } catch (IOException e) 
                   {
                        System.out.println("Error is " + e);
                   }
             }
         });
    }
    
    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (initUserName == initUserName && initPassword == initPassword)
            {
                label.setText("Registration Successfully Completed");
                inputName.setEditable(false);
                inputPass.setEditable(false);
                inputName.setBackground(Color.LIGHT_GRAY);
                inputPass.setBackground(Color.LIGHT_GRAY);
            }
        }
    }
    
    public String getUserName()
    {
        initUserName = "Username";
        return initUserName;
    }
    
    public String getPassword()
    {
        initPassword = "Password";
        return initPassword;
    }
    

}
