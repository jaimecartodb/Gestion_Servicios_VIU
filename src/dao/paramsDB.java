/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jaime
 */
public class paramsDB {
    private static String data;
    private static String user;
    private  static String password;
    public paramsDB(){
        try {
            File myObj = new File("config.txt").getAbsoluteFile();
            Scanner myReader = new Scanner(myObj);
            data = myReader.nextLine();
            user = myReader.nextLine();
            password = myReader.nextLine();
            System.out.println(data);
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getData() {
        return data;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
}
