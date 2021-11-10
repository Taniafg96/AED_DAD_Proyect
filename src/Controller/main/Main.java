package controller.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Connection.ConnectDB;
import model.crud.ProductsCRUD;
import model.storedProcedure.Consults;

import java.util.Arrays;
import model.Connection.ConnectDB;
import model.crud.VentasCRUD;
import model.storedProcedure.Consults;
import model.storedProcedure.Utils;

/**
 *
 * @author Cristo
 */
public class Main {
    public static void main(String[] args) {
        ConnectDB connect = new ConnectDB();
        Connection CONNECT = connect.getConetion();

          //ProductsCRUD pro = new ProductsCRUD("HFSDKJK", "FGFHFG", "FGFHGF", "FGFGH", 20);
          ProductsCRUD pro = new ProductsCRUD("12345678");
          //pro.modify();
          pro.delete();
          //pro.insert();
//        pro.setNombre("sdgdfgf");
//        pro.updateProduct();
//        pro.deleteProduct();
//        
        //VentasCRUD ventas = new VentasCRUD(100, 200, "fhfhgfh", "ghgfhfg", "ghfghgh"); 
        ///VentasCRUD ventas = new VentasCRUD("7");
        //ventas.setProductLot(10);
        //ventas.insert();
        //ventas.modify();
        try(Statement stm = CONNECT.createStatement();){
            ResultSet rs = stm.executeQuery("SELECT * "
                                            + "FROM Ventas");
            
            while(rs.next()){
                System.out.println(rs.getString("Id_Venta"));
                System.out.println(rs.getInt("CantidadProducto")); 
            }
            
            rs.close();
            stm.close();  
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: \nDe lectura"
                        + "\n", "Producto", JOptionPane.WARNING_MESSAGE); 
        }
        

//        product.insertProduct();
//        product.updateProduct();
//        product.deleteProduct();
        
        
        
//        for(int i = 1; i <= product.data().size(); i++){
//            System.out.println(i + "    " + product.data().get(i-1));
//        }
    }
}
