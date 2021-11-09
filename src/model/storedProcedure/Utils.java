/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.storedProcedure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Connection.ConnectDB;

/**
 *
 * @author tania
 */
public class Utils {
    private Connection CONNECT = new ConnectDB().getConetion();
    private Boolean validateCod = false;

    public Boolean getValidateCod() {
        return validateCod;
    }
    
    public void validateCodProducts(String codigo){       
        if(codigo.length() > 13) 
            JOptionPane.showMessageDialog(null, "ERROR:\n El codigo del producto"
                    + " es demasiado largo", "Logitud", JOptionPane.WARNING_MESSAGE);
        
        try(Statement stm = CONNECT.createStatement();){
            ResultSet rs = stm.executeQuery("SELECT * "
                            + "FROM Productos "
                            + "WHERE codigo = " + "'" + codigo + "'");
            
            int rowCount = 0;
            while(rs.next()){ rowCount++;} 
                
            if(rowCount == 0) validateCod = true;       
            else JOptionPane.showMessageDialog(null, "ERROR:\n El Producto ya "
                    + "existe", "Primary Key", JOptionPane.WARNING_MESSAGE);
            
            rs.close();
            stm.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: Consulta codigo Producto en DB", "Error Consulta", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public void validateEmail(String email){
        String pattern = "^[a-zA-Z]@^[a-zA-Z].com";
        if(!email.matches(pattern)) JOptionPane.showMessageDialog(null, "ERROR:"
                + "\n El correo no es correcto", "Correo Incorrecto", JOptionPane.WARNING_MESSAGE);
    }
}
