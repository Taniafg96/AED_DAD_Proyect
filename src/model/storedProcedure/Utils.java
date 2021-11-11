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
    private Boolean exitsProduct = false;
    private Boolean exitsSale = false;
    
    public Boolean getExistSale(){
        return exitsSale;
    }
    
    public Boolean getValidateCod() {
        return validateCod;
    }

    public Boolean getExitsProduct() {
        return exitsProduct;
    }   
    
    public void validateCod(String codigo){   
        exitsProduct(codigo);
        if(exitsProduct){
            if(codigo.length() > 13){
                JOptionPane.showMessageDialog(null, "ERROR:\n El codigo del producto"
                        + " es demasiado largo", "Logitud", JOptionPane.WARNING_MESSAGE);
                validateCod = true;
            }
        }
    }
    
    public void exitsProduct(String codigo){
        String consult = "SELECT * FROM Productos WHERE codigo ='" + codigo + "'";
        try(Connection CONNECT = new ConnectDB().getConetion();
                Statement stm = CONNECT.createStatement();){
            
            ResultSet rs = stm.executeQuery(consult);
            exitsProduct = rs.next();
            
            rs.close();
            stm.close();
            CONNECT.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR:\n" + codigo
                    + " no existe en la Base de Datos" + ex.getMessage(), "Error Consulta", JOptionPane.WARNING_MESSAGE);
        }
    }
    
        public void exitsSale(int id){
        String consult = "SELECT * FROM Ventas WHERE Id_Venta ='" + id + "'";
        try(Connection CONNECT = new ConnectDB().getConetion();
                Statement stm = CONNECT.createStatement();){
            
            ResultSet rs = stm.executeQuery(consult);
            exitsSale = rs.next();
            
            rs.close();
            stm.close();
            CONNECT.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR:\n" + id
                    + " no existe en la Base de Datos" + ex.getMessage(), "Error Consulta", JOptionPane.WARNING_MESSAGE);
        }
    }
        
    public void validateEmail(String email){
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(!email.matches(pattern)) JOptionPane.showMessageDialog(null, "ERROR:"
                + "\n El correo no es correcto", "Correo Incorrecto", JOptionPane.WARNING_MESSAGE);
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
