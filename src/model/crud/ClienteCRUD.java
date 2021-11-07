/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.crud;

import model.Connection.ConnectDB;
import controller.main.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristo
 */
public class ClienteCRUD {
    private Connection con = new ConnectDB().getConetion();
    private PreparedStatement ps;
    
    //Metodo Create
    public void create(Clientes cliente){
        String insertar = "INSERT INTO clientes (Id, Nombre, Direccion, Telefono, Correo) VALUES (?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(insertar);
            ps.setString(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getCorreo());
            ps.executeUpdate();
            System.out.println("Datos introducidos correctamente");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }   
    }
    
    //Metodo Select
    /**
     * Al método se le pasa por parámetro un ArrayList que contendrá los campos de los que se quiera hacer una consulta
     * Ese ArrayList será pasado a una variable tipo String
     */
    public void select(ArrayList <String> campos){
        ResultSet rs;
        String select = "select ? from clientes";
        String camposSelect = "";
        
        //ArrayList a String
        for (String str: campos){
            camposSelect += str + ", ";
        }
        camposSelect = camposSelect.substring(0, camposSelect.length() - 2);
        
        try{
            ps = con.prepareStatement(select);
            ps.setString(0, camposSelect);
            rs = ps.executeQuery();
            
            while(rs.next() != false){
                
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void update(Clientes cliente){
        Statement st;
        String update = "update clientes set nombre='"+cliente.getNombre()+"', Direccion='"+cliente.getDireccion()+"' where id='"+cliente.getId()+"'";
        try {
            st = con.createStatement();
            st.execute(update);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
