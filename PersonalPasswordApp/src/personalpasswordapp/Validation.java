/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalpasswordapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//It works always add in team and then commit. Finally push to the group
public class Validation {

    static String user;
    static String pass;
    static String q;
    static String security;
    static List<String> list = new ArrayList<>();
    static ArrayList accounts = new ArrayList<>();
    public static AccountsOB account;

    public static void setUserPass() throws IOException {
        String fileName = "register.text";
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("accounts.text"), true));
        user = list.get(0);
        pass = list.get(1);
        q = list.get(2);
        security = list.get(3);
    }

    public static void setAccount() throws IOException {
        String fileName = "accounts.text";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void setAccountsList() {
        for (int i = 0; i < list.size();) {
            String name = list.get(i);
            i++;
            String user = list.get(i);
            i++;
            String pass = list.get(i);
            i++;
            account = new AccountsOB(name, user, pass);
            accounts.add(account);
            System.out.println(accounts.size());
        }
    }

}
