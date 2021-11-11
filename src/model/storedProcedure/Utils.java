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
    private Boolean validateCod = false;
    private Boolean exitsElement = false;
    
    public Boolean getValidateCod() {
        return validateCod;
    }

    public Boolean getExitsElement() {
        return exitsElement;
    }   
    
    public void validateCod(String codigo, String tableName, String PK){   
        exits(codigo, tableName, PK);
        if(exitsElement){
            if(codigo.length() > 13){
                JOptionPane.showMessageDialog(null, "ERROR:\n El codigo del producto"
                        + " es demasiado largo", "Logitud", JOptionPane.WARNING_MESSAGE);
                validateCod = true;
            }
        }
    }
    
    public void exits(String codigo, String tableName, String PK){
        String consult = "SELECT * FROM " + tableName +" WHERE " + PK + " ='" + codigo + "'";
        try(Connection CONNECT = new ConnectDB().getConetion();
                Statement stm = CONNECT.createStatement();){
            
            ResultSet rs = stm.executeQuery(consult);
            exitsElement = rs.next();
            
            rs.close();
            stm.close();
            CONNECT.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR:\n" + codigo
                    + " no existe en la Base de Datos" + ex.getMessage(), "Error Consulta", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void validateEmail(String email){
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(!email.matches(pattern)) JOptionPane.showMessageDialog(null, "ERROR:"
                + "\n El correo no es correcto", "Correo Incorrecto", JOptionPane.WARNING_MESSAGE);
    }

    public String generateIDSales(){
        int id = 0;
        try(Connection CONNECT = new ConnectDB().getConetion();
                Statement stm = CONNECT.createStatement();){
            String consult = "SELECT Id_Venta FROM Ventas";
            ResultSet rs  = stm.executeQuery(consult);
            
            if(!rs.next()) id = 1;
            while(rs.next()){
                if(rs.isLast()) id = Integer.parseInt(rs.getString("Id_Venta")) + 2;
            }
            
            rs.close();
            stm.close();
            CONNECT.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return String.valueOf(id);
    }
    
    public float calculateTotalPriceSale(int lot, String codProduct){
        float amount = 0;
        try(Connection CONNECT = new ConnectDB().getConetion();
                Statement stm = CONNECT.createStatement();){
            String consult = "SELECT precio FROM Productos WHERE codigo = '" + codProduct +"'";
            ResultSet rs  = stm.executeQuery(consult);
            
            if(rs.next()) amount = rs.getInt("precio") * lot;
            else JOptionPane.showMessageDialog(null, "ERROR:"
                + "\n ", "Codigo Incorrecto", JOptionPane.WARNING_MESSAGE);
                
            rs.close();
            stm.close();
            CONNECT.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return amount;
    }
}
