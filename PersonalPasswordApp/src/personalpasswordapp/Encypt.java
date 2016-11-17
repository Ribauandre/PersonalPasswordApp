/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JTextField;

/**
 *
 * @author schil
 */
public class Encypt 
{
    byte[] input;
    byte[] keyBytes ="12345678".getBytes();
    byte[] ivBytes = "input123".getBytes();
        SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        Cipher cipher;
        byte[] cipherText;
        int ctLength;
    
//encypt
try{
    Security.addProvider(new org.boucycastle.jce.provider.BouncyCastleProvider());
    input= JTextField().gerText().getBytes();
    SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
    IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
    cipher = Cipher.getInstance("DES/CTR/NoPadding", "BC");
    
    cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
    cipherText = new byte[cipher.getOutputSize(input.length)];
    ctLength = cipher.update(input, 0, input.length, cipherText, 0);
    ctLength += cipher.doFinal(cipherText, ctLength);
    //Encrpt_txt is the file we are goin to write
    //Needs to be changed to the right file
    Encrypt_txt.set(new String(cipherText));
    //System.out.println("cipher: " + new String(cipherText});
}catch (Exception ex){
    JOptionPane.showMessageDialog(null, ex);
}

//decrypt
try{

}catch(){
    
}



}
