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
    public String accountName;
    public String  accountUser;
    public String accountPass;
    
    public AccountsOB(String name, String user1, String pass1 ){
        accountName = name;
        accountUser = user1;
        accountPass = pass1;
    }
    public String getName(){
        return accountName;
    }
}
