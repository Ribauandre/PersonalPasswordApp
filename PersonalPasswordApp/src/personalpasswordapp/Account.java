/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;

import java.awt.Color;
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

/**
 *
 * @author andreribau
 */
public class Account extends JFrame {
    
    private JLabel label, message;
    private JButton add;

    
public Account()
    {
        super("Account");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        label = new JLabel("Accounts (Needs to be finished)");
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 0;
        add(label, c);
       
        
        add = new JButton("Add (does not work)");
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 3;
        add(add, c);
         add.addActionListener((ActionEvent event) -> {
            Add add= new Add();
                    add.setVisible(true);
                    add.setSize(250, 150);
                    add.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    dispose();
        });
        
    }
    
} 
