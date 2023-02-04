/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class DatabaseConnection {
  
    private static Connection con = null;
    private static paramsDB p = new paramsDB();
    static
    {
        String url = p.getData();//"jdbc:mysql://database-1.cz5ftoafk12s.us-east-1.rds.amazonaws.com/proyecto?characterEncoding=utf8";
        String user = p.getUser();
        String pass = p.getPassword();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}