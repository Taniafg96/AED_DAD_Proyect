/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cristo
 */
public class Conexion {
    
    //Atributos
    private static String user = "root";
    private static String passw = "password";
    
    public Conexion(){
        establecerConexion();
    }
    
    //Metodo para establecer conexion | STATIC 
    public static Connection establecerConexion(){
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/aed_dad", user, passw);
        } catch (SQLException ex) {
            System.out.println(ex);
            if(ex.getErrorCode() == 1049) new CreateDB();            
        } 
        return conexion;
    }  
}
