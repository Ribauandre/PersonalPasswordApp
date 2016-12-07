/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author andreribau
 */
public class Account extends JFrame {
    
    private JLabel label, message;
    private JButton add;
    public AccountsOB account;
    public static String select;

    
public Account()
    {
        super("Account");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        label = new JLabel("<HTML><FONT color=\"#00009\"><b><h3>Account</b></h3></FONT></HTML>");
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 0;
        add(label, c);
        Validation.accounts.clear();
        Validation.list.clear();
        Validation.setAccount();
        Validation.setAccountsList();
       
        
        add = new JButton("Add");
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 3;
        add(add, c);
         add.addActionListener((ActionEvent event) -> {
            Add add= new Add();
                    add.setVisible(true);
                    add.setSize(400, 175);
                    add.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    dispose();
        });
        if(Validation.list.size() > 0){
            String[] array = new String[Validation.accounts.size()];
            for(int i = 0; i < array.length; i++) {
            array[i] = Validation.accounts.get(i).accountName;
}
        JComboBox comboBox = new JComboBox(array);
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        add(comboBox, c);
        comboBox.addActionListener((ActionEvent event) -> {
            select = comboBox.getSelectedItem().toString();
            Password pass= new Password();
                    pass.setVisible(true);
                    pass.setSize(400, 150);
                    pass.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    dispose();
                    
        });
        }
         
        else{
        message = new JLabel("Please add an account");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(message, c);
        }
    }
    
} 
