/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import model.Connection.ConnectDB;
import model.crud.VentasCRUD;
import model.storedProcedure.Consults;
import view.Grafico;
/**
 *
 * @author Cristo
 */
public class Main {
    public static void main(String[] args) {
        //Clientes cl = new Clientes("qazsdq", "Lucas", "Lucas", "45", "asf@");
        //System.out.println(cl.toString());
        
        
//        ArrayList <String> campos = new ArrayList <String>();
//        campos.add("Nombre");
//        campos.add("edad");
//        campos.add("Apellidos");
//        new ClienteCRUD().select(campos);

        //Clientes cl = new Clientes("qazsdq", "Lugo", cl.getDireccion(), "", "");
        //new ClienteCRUD().update(cl);
        
        System.out.println(totalPriceProducts());
    }
    
    public static HashMap <String, String> totalPriceProducts(){
         String consult = " SELECT\n" +
                         " codigo,\n" +
                         " nombre\n" +
                         " FROM Productos";
        
        HashMap <String, String> map = new HashMap <String, String> ();
        
        try(Connection CONNECT = new ConnectDB().getConetion();
                Statement stm = CONNECT.createStatement();){
                
            ResultSet rs = stm.executeQuery(consult);
            while(rs.next()){
                map.put(rs.getString("codigo"), rs.getString("nombre"));
            }
            
            stm.close();
            CONNECT.close();
        }catch(SQLException ex){
            
        }
        
        return map;
    }
}
