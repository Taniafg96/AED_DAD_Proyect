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
import javax.swing.JOptionPane;
import model.Connection.ConnectDB;
import model.crud.ProductsCRUD;
import model.storedProcedure.SPProducts;


/**
 *
 * @author Cristo
 */
public class Main {
    public static void main(String[] args) {
        ConnectDB connect = new ConnectDB();
        Connection CONNECT = connect.getConetion();
        
        try(Statement stm = CONNECT.createStatement();){
            ResultSet rs = stm.executeQuery("SELECT * "
                                            + "FROM Productos");
            
            while(rs.next()){
                System.out.println(rs.getString("codigo"));      
            }
            
            rs.close();
            stm.close();  
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: \nDe lectura"
                        + "\n", "Producto", JOptionPane.WARNING_MESSAGE);
        }
        new SPProducts().insertProducts("DKJHDGKJ", "Alfombrilla", "Electronico", null, 12);
    }
}
