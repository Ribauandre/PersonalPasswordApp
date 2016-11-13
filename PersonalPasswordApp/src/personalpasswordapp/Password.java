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
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPasswordField;


/**
 *
 * @author andreribau
 */
public class Password extends JFrame {
    
    private JLabel label, message;
    private JButton add, back, delete;
    public AccountsOB account;
    public String select;
    public String accName;
    public String accUser;
    public String accPass;

    
public Password()
    {
        super("Account");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        label = new JLabel("Account Info");
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 0;
        add(label, c);
        
        for(int i = 0; i<Validation.accounts.size(); i++){
            if(Validation.accounts.get(i).accountName.equals(Account.select)){
                accName = Validation.accounts.get(i).accountName;
                accUser = Validation.accounts.get(i).accountUser;
                accPass = Validation.accounts.get(i).accountPass;  
            }
        }
        
        label = new JLabel("Account Name: "+accName);
        c.gridx = 1;
        c.gridwidth = 0;
        c.gridy = 1;
        add(label, c);
        
        label = new JLabel("Account Username: "+accUser);
        c.gridx = 1;
        c.gridwidth = 0;
        c.gridy = 2;
        add(label, c);
        
        
        label = new JLabel("Account Password: "+accPass);
        c.gridx = 1;
        c.gridwidth = 0;
        c.gridy = 3;
        add(label, c);
        
        back = new JButton("Return");
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 5;
        c.anchor = GridBagConstraints.EAST;
        c.weightx = 1;
        add(back, c);
        back.addActionListener((ActionEvent event) -> {
            Account account = new Account();
                    account.setVisible(true);
                    account.setSize(400, 150);
                    account.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    dispose();
        });
        
        delete = new JButton("Delete");
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.EAST;
        c.weightx = 1;
        add(delete, c);
        delete.addActionListener((ActionEvent event) -> {
            Delete.removeLineFromFile("accounts.text", accName);
            Validation.accounts.clear();
            Account account = new Account();
            account.setVisible(true);
            account.setSize(400, 150);
            account.setDefaultCloseOperation(EXIT_ON_CLOSE);
            dispose();

        });
        
        
        
    }
}
