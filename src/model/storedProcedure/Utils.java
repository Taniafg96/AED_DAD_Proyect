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
    private final Connection CONNECT = new ConnectDB().getConetion();
    private Boolean validateCod = false;
    private Boolean exitsElement = false;
    
    public Boolean getValidateCod() {
        return validateCod;
    }

    public Boolean getExitsElement() {
        return exitsElement;
    }   
    
    public void validateCod(String codigo, String tableName){   
        exits(codigo, tableName);
        if(exitsElement){
            if(codigo.length() > 13){
                JOptionPane.showMessageDialog(null, "ERROR:\n El codigo del producto"
                        + " es demasiado largo", "Logitud", JOptionPane.WARNING_MESSAGE);
                validateCod = true;
            }
        }
    }
    
    public void exits(String codigo, String tableName){
        String consult = null;
        try(Statement stm = CONNECT.createStatement();){
            if(tableName.equals("Ventas")) consult = "SELECT * FROM " + tableName +" WHERE Id_Venta ='" + codigo + "'";
            if(tableName.equals("Productos")) consult = "SELECT * FROM " + tableName +" WHERE codigo ='" + codigo + "'";
            
            ResultSet rs = stm.executeQuery(consult);
            exitsElement = rs.next();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR:\n" + codigo
                    + " no existe en la Base de Datos", "Error Consulta", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void validateEmail(String email){
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(!email.matches(pattern)) JOptionPane.showMessageDialog(null, "ERROR:"
                + "\n El correo no es correcto", "Correo Incorrecto", JOptionPane.WARNING_MESSAGE);
    }

    public String generateIDSales(){
        int id = 0;
        try(Statement stm = CONNECT.createStatement();){
            String consult = "SELECT Id_Venta FROM Ventas";
            ResultSet rs  = stm.executeQuery(consult);
            
            if(!rs.next()) id = 1;
            while(rs.next()){
                if(rs.isLast()) id = Integer.parseInt(rs.getString("Id_Venta")) + 1;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return String.valueOf(id);
    }
    
}
