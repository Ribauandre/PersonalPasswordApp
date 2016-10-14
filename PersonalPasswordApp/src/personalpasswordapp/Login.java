/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author bryaningram
 */
public class Login {
    String fileName = "temp.txt";
    String line = null;
    private JLabel label, message;
    private JTextField inputName;
    private JPasswordField inputPass;
    private JButton register;
    
    public Login()
    {
        super("Login");
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
    }
    
     public static boolean checkLogin(String username, String password) throws IOException{
         boolean checked = false;
         for (String line : Files.readAllLines(Paths.get("/path/to/file.txt"))) {
               /*It's not much.*/
         }
         
         
         
         
         return checked;
     }

    
}
