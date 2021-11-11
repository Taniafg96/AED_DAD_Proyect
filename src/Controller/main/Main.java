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

          //ProductsCRUD pro = new ProductsCRUD("HFS", "FGFHFG", "FGFHGF", "FGFGH", 20);
          ProductsCRUD pro = new ProductsCRUD("HFS");
          pro.delete();
          //pro.insert();
//          
//          Utils util = new Utils();
//          util.exits("HFS", "Productos");
//          System.out.print(util.getExitsElement());
//        pro.setNombre("sdgdfgf");
//        pro.updateProduct();
//        pro.deleteProduct();
//        
        //VentasCRUD ventas = new VentasCRUD(100, "11111111A", "HFS", "QAZ123"); 
//        VentasCRUD ventas = new VentasCRUD(1);
////        ventas.insert();
//    ventas.setProductLot(200);
//        ventas.modify();
        try(Statement stm = CONNECT.createStatement();){
            ResultSet rs = stm.executeQuery("SELECT * "
                                            + "FROM Productos");
            
            while(rs.next()){
                System.out.println(rs.getString("codigo"));
                System.out.println(rs.getString("nombre")); 
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
