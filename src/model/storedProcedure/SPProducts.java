/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import model.Connection.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.crud.ProductsCRUD;

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
    
    public void insertProducts(String codigo, String nombre, 
            String tipo, String descripcion, float precio){
        String codigoAlmacen = "PLMOKN123";
        String insert = "insert into Productos values (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement db = CONNECT.prepareStatement(insert);){
            db.setString(1, codigo);
            db.setString(2, nombre);
            db.setString(3, tipo);
            db.setString(4, descripcion);
            db.setFloat(5, precio);
            db.setString(6, codigoAlmacen);
            System.out.println("Se han insertado los valores con exito");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
}
