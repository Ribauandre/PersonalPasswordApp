/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;

/**
 *
 * @author andreribau
 */
public class AccountsOB {
    String accountName;
    String accountUser;
    String accountPass;
    
    public AccountsOB(String name, String user, String pass ){
        accountName = name;
        accountUser = user;
        accountPass = pass;
    }
    public String getName(){
        return accountName;
    }
}
