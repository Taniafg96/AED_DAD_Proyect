package connection;

import java.sql.*;

/**
 *
 * @author Usuario
 */
public class ConnectDB{
    private static Connection CONNECT;
    private static String DATABASE = "jdbc:mysql://localhost:3306/AED_DAD";
    private static String USER;
    private static String PASSWORD;
    
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
    
    private void connectDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                CONNECT = DriverManager.getConnection(DATABASE, USER, PASSWORD);
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex.getMessage());
                if(ex.getErrorCode() == 1049) new CreateDB(USER, PASSWORD);
            }              
        }catch(ClassNotFoundException ex){
            System.out.println("ERROR: " + ex.getMessage());
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
