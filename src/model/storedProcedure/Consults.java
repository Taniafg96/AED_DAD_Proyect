package model.storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Connection.ConnectDB;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.crud.ProductsCRUD;
import model.crud.VentasCRUD;


/**
 *
 * @author Usuario
 */
public class Consults {
    private static final Connection CONNECT = new ConnectDB().getConetion();
    private final Utils util = new Utils();
    
    public Consults(){}
    
    public VentasCRUD searchVenta(String ID){
        VentasCRUD sale = null;
        String consult = "SELECT * FROM Ventas WHERE Id_Venta = '" + ID + "'";
        try(Statement stm = CONNECT.createStatement();){
            ResultSet rs = stm.executeQuery(consult);
            if(rs.next()){
                sale = new VentasCRUD(ID, rs.getInt("CantidadProducto"),
                        rs.getFloat("PrecioTotal"), rs.getString("DNI_Empleado"),
                        rs.getString("codigo_producto"), rs.getString("id_cliente"));
                
            }else JOptionPane.showMessageDialog(null, "No existe una Venta con este ID",
                    "Consulta venta", JOptionPane.WARNING_MESSAGE);
      
            rs.close();
            stm.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR:\n Al ejecutar la consulta",
                    "Consulta venta", JOptionPane.WARNING_MESSAGE);
        }
        
        return sale;
    }
    
    public ProductsCRUD searchProducto(String codigo){
        ProductsCRUD product = null;
        String consult = "SELECT * FROM Productos WHERE codigo = '" + codigo + "'";
        try(Statement stm = CONNECT.createStatement();){
            ResultSet rs = stm.executeQuery(consult);
            if(rs.next()){
                product = new ProductsCRUD(codigo, rs.getString("nombre"),
                        rs.getString("tipo"), rs.getString("descripcion"),
                        rs.getFloat("precio"), rs.getString("cod_almacen"));
                
            }else JOptionPane.showMessageDialog(null, "No existe un Producto con este codigo",
                    "Consulta producto", JOptionPane.WARNING_MESSAGE);

            rs.close();
            stm.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR:\n Al ejecutar la consulta",
                    "Consulta Producto", JOptionPane.WARNING_MESSAGE);
        }
        
        return product;
    }
        
    public void insertProduct(String codigo, String nombre, String tipo, String descripcion, float precio,
            String codigoAlmacen, String tableName){
        
        String insert = "insert into Productos values (?, ?, ?, ?, ?, ?)";
        util.validateCod(codigo, tableName);
        if(!util.getValidateCod()){
            if(!codigo.isEmpty()){
                try(PreparedStatement pstm = CONNECT.prepareStatement(insert);){
                    pstm.setString(1, codigo);
                    pstm.setString(2, nombre);
                    pstm.setString(3, tipo);
                    pstm.setString(4, descripcion);
                    pstm.setFloat(5, precio);
                    pstm.setString(6, "QWERTY001");

                    pstm.executeUpdate();
                    JOptionPane.showMessageDialog(null, "El " + tableName + " se "
                            + "ha insertado con exito", tableName + " Insertado", JOptionPane.INFORMATION_MESSAGE);

                    pstm.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR: \nAl insertar el "
                             + tableName + ex.getMessage(), tableName + " Insertado", JOptionPane.WARNING_MESSAGE);
                }

            }else JOptionPane.showMessageDialog(null, "ERROR: \nEl codigo del" + tableName
                    + "no puede estar vacio: \n", tableName + " Insertado", 
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void insertSale(String id, int productLot, float totalPrice, String dni, String codProduct, String idClient, String tableName){
        if(!codProduct.isEmpty() && !idClient.isEmpty() && !dni.isEmpty()){
            String call = "{call insertSale(?,?,?,?,?,?)}";
            try(CallableStatement cstm = CONNECT.prepareCall(call)){
                
                cstm.setString("Id_Ventas", id);
                cstm.setInt("productLot", productLot);
                cstm.setFloat("totalPrice", totalPrice);
                cstm.setString("dni", "11111111A");
                cstm.setString("codProduct", "12345678");
                cstm.setString("idClient", "QAZ123");

                cstm.executeUpdate();

                JOptionPane.showMessageDialog(null, "El " + tableName + " se "
                    + "ha insertado con exito", tableName + " Insertado", JOptionPane.INFORMATION_MESSAGE);
                cstm.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: \n"
                         + ex.getMessage(), tableName + " Insertado", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    public void modify(String codigo, String update, String tableName){
        util.validateCod(codigo, tableName);
        if(util.getExitsElement()){
            if(!codigo.isEmpty()){
                try(Statement stm = CONNECT.createStatement();){
                     stm.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "La modificacion se ha "
                        + "realizado con exito", tableName + " Modificado", JOptionPane.INFORMATION_MESSAGE);
                     stm.close();

                }
                catch(SQLException ex){
                    if(ex.getErrorCode() == 1054){
                        JOptionPane.showMessageDialog(null, "ERROR: \nNo existe el "
                                + "codigo de \n" + tableName + ex.getMessage(), "Codigo de " + tableName, JOptionPane.WARNING_MESSAGE);

                    }else JOptionPane.showMessageDialog(null, "ERROR: \nError en la "
                            + "modificacion\n" + ex.getMessage(), "Producto Modificado", JOptionPane.WARNING_MESSAGE);
                }

            }else JOptionPane.showMessageDialog(null, "ERROR: \nEl codigo de " + tableName
                    + " esta vacio", "Codigo de " +tableName, JOptionPane.WARNING_MESSAGE);

        }
    }
    
    public void delete(String codigo, String delete, String tableName){
        util.validateCod(codigo, tableName);
        if(util.getExitsElement()){
            try(Statement stm = CONNECT.createStatement();){
                stm.executeUpdate(delete);
                JOptionPane.showMessageDialog(null, "Se ha borrado el "
                        + "\n" + tableName + " " + codigo, tableName + "Borrado", JOptionPane.INFORMATION_MESSAGE);

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR: \nNo se pudo borrar el "
                        + "\n" + tableName, "Error Borrado", JOptionPane.WARNING_MESSAGE);
            }
        }else JOptionPane.showMessageDialog(null, "ERROR: \nEl codigo del " + tableName
                + " no existe", "Codigo de " + tableName, JOptionPane.WARNING_MESSAGE);
    }
    
}
