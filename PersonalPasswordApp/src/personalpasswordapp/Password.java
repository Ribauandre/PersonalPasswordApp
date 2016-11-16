/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author andreribau
 */
public class Password extends JFrame {
    
    private JLabel label;
    private JButton back, delete;
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
        GridBagConstraints c2 = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        label = new JLabel("<HTML><FONT color=\"#00009\"><b><h3>Account Info</b></h3></FONT></HTML>");
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 0;
        add(label, c);
        
        for(int i = 0; i<Validation.accounts.size(); i++){
            if(Validation.accounts.get(i).accountName.equals(Account.select)){
                accName = Validation.accounts.get(i).accountName;
                accUser = Validation.accounts.get(i).accountUser;
                accPass = Validation.accounts.get(i).accountPass;  
            }
        }
        
        label = new JLabel("Account Name:   ");
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 1;
        add(label, c);
        label = new JLabel(accName);
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 1;
        add(label, c);
        
        label = new JLabel("Account Username:   ");
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 2;
        add(label, c);
        label = new JLabel(accUser);
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 2;
        add(label, c);
        
        label = new JLabel("Account Password:   ");
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 3;
        add(label, c);
        label = new JLabel(accPass);
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 3;
        add(label, c);
        
        back = new JButton("Return");
        c2.gridwidth = 1;
        c2.gridx = 0;
        c2.gridy = 4;
        add(back, c2);
        back.addActionListener((ActionEvent event) -> {
            Account acc = new Account();
                    acc.setVisible(true);
                    acc.setSize(400, 150);
                    acc.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    dispose();
        });
        
        delete = new JButton("Delete");
        c2.gridwidth = 1;
        c2.gridx = 1;
        c2.gridy = 4;
        add(delete, c2);
        delete.addActionListener((ActionEvent event) -> {
            Delete.removeLineFromFile("accounts.text", accName);
            Validation.accounts.clear();
            Account acc = new Account();
            acc.setVisible(true);
            acc.setSize(400, 150);
            acc.setDefaultCloseOperation(EXIT_ON_CLOSE);
            dispose();

        });
        
        
        
    }
}
