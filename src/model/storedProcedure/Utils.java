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
    private Boolean exitsProduct = false;
    
    public Boolean getValidateCod() {
        return validateCod;
    }

    public Boolean getExitsProduct() {
        return exitsProduct;
    }
    
    public void validateCodProducts(String codigo){       
        if(codigo.length() > 13){
            JOptionPane.showMessageDialog(null, "ERROR:\n El codigo del producto"
                    + " es demasiado largo", "Logitud", JOptionPane.WARNING_MESSAGE);
        
            exits(codigo, "Productos");
            if(exitsProduct == true) validateCod = true;
        }
    }
    
    public void exits(String codigo, String tableName){
        try(Statement stm = CONNECT.createStatement();){
            String consult = "SELECT * FROM " + tableName +" WHERE codigo ='" + codigo + "'";
            
            ResultSet rs = stm.executeQuery(consult);
            int rowCount = 0;
            while(rs.next()){ rowCount++;} 
                
            if(rowCount == 0) exitsProduct = true;       
            
            stm.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: Consulta codigo Producto "
                    + "en DB", "Error Consulta", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void validateEmail(String email){
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(!email.matches(pattern)) JOptionPane.showMessageDialog(null, "ERROR:"
                + "\n El correo no es correcto", "Correo Incorrecto", JOptionPane.WARNING_MESSAGE);
    }

}
