package model.Connection;

import java.sql.*;

/**
 *
 * @author Usuario
 */
public class ConnectDB{
    private static Connection CONNECT;
    private static String DATABASE = "jdbc:mysql://localhost:3306/AED_DAD";
    private static String USER = "root";
    private static String PASSWORD = "admin";
    
    public ConnectDB(){
        connectDB();
    }
    
    public ConnectDB(String user, String password){
        this.USER = user;
        this.PASSWORD = password;
        connectDB();
    }
    
    public Connection getConetion(){
        return CONNECT;
    }
    
    public static Connection connectDB(){
        try {
            CONNECT = DriverManager.getConnection(DATABASE, USER, PASSWORD);
            return CONNECT;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    private void closeDB(){
        try {
            CONNECT.close();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
