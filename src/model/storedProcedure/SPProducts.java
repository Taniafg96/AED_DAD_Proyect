/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.storedProcedure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Connection.ConnectDB;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class SPProducts {
    private static final Connection CONNECT = new ConnectDB().getConetion();
    private Utils util = new Utils();
    
    public SPProducts(){
    }
    
    public void insertProducts(String codigo, String nombre, 
            String tipo, String descripcion, float precio){
        
        String insert = "insert into Productos values (?, ?, ?, ?, ?, ?)";
        Boolean validate = false;
        util.validateCodProducts(codigo);
        if(util.getValidateCod()) validate = true;
        if(validate){
            if(!codigo.isEmpty()){
                try(PreparedStatement pstm = CONNECT.prepareStatement(insert);){
                    pstm.setString(1, codigo);
                    pstm.setString(2, nombre);
                    pstm.setString(3, tipo);
                    pstm.setString(4, descripcion);
                    pstm.setFloat(5, precio);
                    pstm.setString(6, "QWERTY001");
                    
                    pstm.executeUpdate();
                    JOptionPane.showMessageDialog(null, "ERROR: \nEl prodcuto se "
                            + "ha insertado con exito", "Producto Insertado", JOptionPane.INFORMATION_MESSAGE);
                    
                    pstm.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR: \nAl insertar el "
                            + "producto\n" + codigo + ex.getMessage(), "Insertar Producto", JOptionPane.WARNING_MESSAGE);
                }

            }else JOptionPane.showMessageDialog(null, "ERROR: \nEl codigo del producto "
                    + "no puede estar vacio: \n", "Insertar Producto", 
                    JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public void modifyProduct(String codigo, String nombre, 
            String tipo, String descripcion, float precio){
        
        String fields = "";
        if(!codigo.isEmpty()){
            if(!nombre.isEmpty()) fields += "nombre = " + nombre + ", ";
            if(!tipo.isEmpty()) fields += "tipo = " + tipo + ", ";
            if(!descripcion.isEmpty()) fields += "descripcion = " + descripcion + ", ";
            if(precio != 0 ) fields += "precio = " + String.valueOf(precio) + ", ";

            if(!fields.isEmpty()) fields = fields.substring(0, fields.split("").length-2);
            String query = "UPDATE Productos SET " + fields
                            + " WHERE codigo = " + codigo; 
            try(Statement stm = CONNECT.createStatement();){
                 stm.executeUpdate(query);
                 
            JOptionPane.showMessageDialog(null, "ERROR: \nLa modificacion se ha "
                    + "realizado con exito", "Producto Modificado", JOptionPane.INFORMATION_MESSAGE);
                 stm.close();

            }
            catch(SQLException ex){
                System.out.println("ERROR: + " + ex.getErrorCode());
                if(ex.getErrorCode() == 1054){
                    JOptionPane.showMessageDialog(null, "ERROR: \nNo existe el "
                            + "codigo de Producto: \n" + codigo, "Codigo de Producto", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else JOptionPane.showMessageDialog(null, "ERROR: \nEl codigo del Producto "
                + "esta vacio", "Codigo de Producto", JOptionPane.WARNING_MESSAGE);
    }
    
    public void deleteProduct(String codigo){
        try(Statement stm = CONNECT.createStatement();){
            String delete = "DELETE FROM Productos WHERE codigo = " + codigo;
            stm.executeUpdate(delete);
            JOptionPane.showMessageDialog(null, "ERROR: \nSe ha borrado el "
                    + "Producto\n" + codigo, "Producto Borrado", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: \nNo se pudo borrar el "
                    + "producto\n", "Error Borrado", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
