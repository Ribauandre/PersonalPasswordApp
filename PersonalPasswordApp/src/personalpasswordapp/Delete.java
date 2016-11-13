/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author andreribau
 */
public class Delete {

    public Delete() {

    }

    public static void removeLineFromFile(String file, String lineToRemove) {

    try {

      File inFile = new File(file);

      if (!inFile.isFile()) {
        System.out.println("Parameter is not an existing file");
        return;
      }

     
      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

      BufferedReader br = new BufferedReader(new FileReader(file));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

      String line = null;
      boolean go = true;
while ( go )
{
    String temp = "";
    for ( int i = 0; i <= 2; i++ )
    {
        line = br.readLine();
        if ( line != null )
            temp += line + "\n";
        else
            go = false;
    }

    if ( !temp.trim().contains(lineToRemove) )
    {
        pw.print( temp );
        pw.flush();
    }
}
pw.close(); br.close();

  
      if (!inFile.delete()) {
        System.out.println("Could not delete file");
        return;
      } 

      
      if (!tempFile.renameTo(inFile))
        System.out.println("Could not rename file");

    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    Validation.list.clear();
    Validation.accounts.clear();
  }
}
