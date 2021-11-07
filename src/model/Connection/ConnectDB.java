package model.Connection;

import java.sql.*;

/**
 *
 * @author Usuario
 */
public class ConnectDB{
    private Connection connect;
    private String dataBase = "jdbc:mysql://localhost:3306/AED_DAD";
    private String user = "root";
    private String password = "admin";
    
    public ConnectDB(){
        connectDB();
    }
    
    public ConnectDB(String dataBase, String user, String password){
        this.dataBase = dataBase;
        this.user = user;
        this.password = password;
        connectDB();
    }
    
    public Connection getConetion(){
        return connect;
    }
    
    private void connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connect = DriverManager.getConnection(dataBase, user, password);
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex.getMessage());
                if(ex.getErrorCode() == 1049) new CreateDB(user, password);
            }              
        }catch(ClassNotFoundException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    
    private void closeDB(){
        try {
            connect.close();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
