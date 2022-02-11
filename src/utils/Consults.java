package utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.ConnectDB;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import crud.ProductsCRUD;
import crud.VentasCRUD;


/**
 *
 * @author Usuario
 */
public class Consults {
    private static final Connection CONNECT = new ConnectDB().getConetion();
    private final Utils util = new Utils();
    
    public Consults(){}
    
    public VentasCRUD searchVenta(int ID){
        VentasCRUD sale = null;
        String consult = "SELECT * FROM Ventas WHERE Id_Venta = '" + ID + "'";
        util.exitsSale(ID);
        if(util.getExistSale()){
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
        }
        
        return sale;
    }
    
    public ProductsCRUD searchProducto(String codigo){
        ProductsCRUD product = null;
        String consult = "SELECT * FROM Productos WHERE codigo = '" + codigo + "'";
        util.exitsProduct(codigo);
        if(util.getExitsProduct()){
            
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
        }
        
        return product;
    }
        
    public void insertProduct(String codigo, String nombre, String tipo, String descripcion, float precio,
            String codigoAlmacen){
        
        String insert = "insert into Productos values (?, ?, ?, ?, ?, ?)";
        util.validateCod(codigo);
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
                    JOptionPane.showMessageDialog(null, "El Producto se "
                            + "ha insertado con exito", "Producto Insertado", JOptionPane.INFORMATION_MESSAGE);

                    pstm.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR: \nAl insertar el Producto\n" + ex.getMessage()
                            , "Producto Insertado", JOptionPane.WARNING_MESSAGE);
                }

            }else JOptionPane.showMessageDialog(null, "ERROR: \nEl codigo del Producto "
                    + "no puede estar vacio: \n", "Producto Insertado", 
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void insertSale(int productLot, float totalPrice, String dni, String codProduct, String idClient){
        if(!codProduct.isEmpty() && !idClient.isEmpty() && !dni.isEmpty()){
            String call = "{call insertSale(?,?,?,?,?)}";
            try(CallableStatement cstm = CONNECT.prepareCall(call)){
                
                cstm.setInt("productLot", productLot);
                cstm.setFloat("totalPrice", totalPrice);
                cstm.setString("dni", dni);
                cstm.setString("codProduct", codProduct);
                cstm.setString("idClient", idClient);

                cstm.executeUpdate();

                JOptionPane.showMessageDialog(null, "La Venta se ha insertado con exito"
                        , "Venta Insertada", JOptionPane.INFORMATION_MESSAGE);
                cstm.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: \n Insertar la venta\n" + ex.getMessage()
                        , "Venta Insertada\n", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void modifyProduct(String codigo, String nombre, String tipo, String descripcion, Float precio){
        util.validateCod(codigo);
        if(util.getExitsProduct()){
            if(!codigo.isEmpty()){
                try(PreparedStatement pstm = CONNECT.prepareStatement("UPDATE Productos "
                        + "SET nombre = ?, tipo = ?, descripcion = ?, precio=? WHERE codigo = '" + codigo + "'");){
                                    
                    pstm.setString(1, nombre);
                    pstm.setString(2, tipo);
                    pstm.setString(3, descripcion);
                    pstm.setFloat(4, precio);
                    pstm.executeUpdate();

                    JOptionPane.showMessageDialog(null, "La modificacion se ha "
                        + "realizado con exito", "Producto Modificado", JOptionPane.INFORMATION_MESSAGE);
                     pstm.close();
                }
                catch(SQLException ex){
                    if(ex.getErrorCode() == 1054){
                        JOptionPane.showMessageDialog(null, "ERROR: \nNo existe el "
                                + "codigo del Producto \n"  + ex.getMessage(), "Codigo de Producto", JOptionPane.WARNING_MESSAGE);

                    }else JOptionPane.showMessageDialog(null, "ERROR: \nError en la "
                            + "modificacion\n" + ex.getMessage(), "Producto Modificado", JOptionPane.WARNING_MESSAGE);
                }

            }else JOptionPane.showMessageDialog(null, "ERROR: \nEl codigo del Producto " 
                    + " esta vacio", "Codigo de Producto", JOptionPane.WARNING_MESSAGE);

        }
    }
    
        public void modifySale(int id, String update){
        util.exitsSale(id);
        if(util.getExistSale()){
            if(id != 0){
                try(Statement stm = CONNECT.createStatement();){
                     stm.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "La modificacion se ha "
                        + "realizado con exito", "Venta Modificada", JOptionPane.INFORMATION_MESSAGE);
                     stm.close();

                }
                catch(SQLException ex){
                    if(ex.getErrorCode() == 1054){
                        JOptionPane.showMessageDialog(null, "ERROR: \nNo existe el "
                                + "id de la Venta\n" + ex.getMessage(), "Venta Modificada", JOptionPane.WARNING_MESSAGE);

                    }else JOptionPane.showMessageDialog(null, "ERROR: \nError en la "
                            + "modificacion\n" + ex.getMessage(), "Venta Modificada", JOptionPane.WARNING_MESSAGE);
                }

            }else JOptionPane.showMessageDialog(null, "ERROR: \nEl id esta vacio"
                    , "Venta Modificada", JOptionPane.WARNING_MESSAGE);

        }
    }
    
    public void deleteProduct(String codigo, String delete){
        try(Statement stm = CONNECT.createStatement();){
            stm.executeUpdate(delete);
            JOptionPane.showMessageDialog(null, "Se ha borrado el Producto"
                    + "\n" + codigo, "Producto Borrado", JOptionPane.INFORMATION_MESSAGE);

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: \nNo se pudo borrar el Producto\n" + ex.getMessage(),
                    "Producto Borrado", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteSale(int id, String delete){
        util.exitsSale(id);
        if(util.getExistSale()){
            try(Statement stm = CONNECT.createStatement();){
                stm.executeUpdate(delete);
                JOptionPane.showMessageDialog(null, "Se ha borrado la Venta "+ id
                        , "Venta Borrado", JOptionPane.INFORMATION_MESSAGE);

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR: \nNo se pudo borrar la Venta"
                        , "Venta Borrado", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
}