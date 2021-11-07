/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.crud;

import java.sql.Connection;
import model.Connection.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class SPProducts {
    private static final Connection CONNECT = new ConnectDB().getConetion();
    
    public SPProducts(){
        consultProducts();
    }
    
    public List<ProductsCRUD> consultProducts(){
        List<ProductsCRUD> productos = new ArrayList<>();
        
        try(Statement stm = CONNECT.createStatement();){
            ResultSet rs = stm.executeQuery("SELECT * "
                                            + "FROM Productos");
            
            while(rs.next()){
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                String codigoAlmacen = rs.getString("cod_almacen");
                
                productos.add(new ProductsCRUD(codigo, nombre, tipo, 
                        descripcion, precio, codigoAlmacen));
            }
            rs.close();
            stm.close();  
        } catch (SQLException ex) {
            Logger.getLogger(SPProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productos;
    }
}
