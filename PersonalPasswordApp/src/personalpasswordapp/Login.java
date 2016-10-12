/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author bryaningram
 */
public class Login {
    String fileName = "temp.txt";
    String line = null;
    
     public static boolean checkLogin(String username, String password) throws IOException{
         boolean checked = false;
         for (String line : Files.readAllLines(Paths.get("/path/to/file.txt"))) {

         }
         
         
         
         
         return checked;
     }

    
}
