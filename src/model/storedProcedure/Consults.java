package model.storedProcedure;

import java.sql.CallableStatement;
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
public class Consults {
    private static final Connection CONNECT = new ConnectDB().getConetion();
    private Utils util = new Utils();
    
    public Consults(){
    }
    
    public void insertProduct(String codigo, String nombre, String tipo, String descripcion, float precio,
            String codigoAlmacen, String tableName){
        
        String insert = "insert into Productos values (?, ?, ?, ?, ?, ?)";
        util.validateCodProducts(codigo);
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
    
    public void insertSale(int productLot, float totalPrice, String dni, String codProduct, String idClient, String tableName){
        if(!codProduct.isEmpty() && !idClient.isEmpty() && !dni.isEmpty()){
            String call = "{call insertSale(?,?,?,?,?,?)}";
            try(CallableStatement cstm = CONNECT.prepareCall(call)){

                cstm.setInt("productLot", productLot);
                cstm.setFloat("totalPrice", totalPrice);
                cstm.setString("dni", dni);
                cstm.setString("codProduct", codProduct);
                cstm.setString("idClient", idClient);

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
        util.exits(codigo, tableName);
        if(!util.getExitsProduct()){
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
                                + "codigo de \n" + tableName, "Codigo de " + tableName, JOptionPane.WARNING_MESSAGE);

                    }else JOptionPane.showMessageDialog(null, "ERROR: \nError en la "
                            + "modificacion\n" + ex.getMessage(), "Producto Modificado", JOptionPane.WARNING_MESSAGE);
                }

            }else JOptionPane.showMessageDialog(null, "ERROR: \nEl codigo del " + tableName
                    + " esta vacio", "Codigo de " +tableName, JOptionPane.WARNING_MESSAGE);

        }else JOptionPane.showMessageDialog(null, "ERROR: \nEl codigo del " + tableName
                + " no existe", "Codigo de " + tableName, JOptionPane.WARNING_MESSAGE);
    }
    
    public void delete(String codigo, String delete, String tableName){
        util.exits(codigo, tableName);
        if(!util.getExitsProduct()){
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
