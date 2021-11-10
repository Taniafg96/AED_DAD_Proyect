package model.crud;

import javax.swing.JOptionPane;
import model.storedProcedure.Consults;
import model.storedProcedure.Utils;

/**
 *
 * @author Usuario
 */
public class VentasCRUD {
    private static String ID;
    private int productLot;
    private float totalPrice;
    private String dni;
    private String codProduct;
    private String idClient;

    private final Consults consult = new Consults(); 
    
    public VentasCRUD(int productLot, float totalPrice, String dni, String codProduct, String idClient) {
        VentasCRUD.ID = new Utils().generateIDSales();
        this.productLot = productLot;
        this.totalPrice = totalPrice;
        this.dni = dni;
        this.codProduct = codProduct;
        this.idClient = idClient;
    }

    public VentasCRUD(String ID, int productLot, float totalPrice, String dni, String codProduct, String idClient) {
        this.ID = ID;
        this.productLot = productLot;
        this.totalPrice = totalPrice;
        this.dni = dni;
        this.codProduct = codProduct;
        this.idClient = idClient;
    }
    
    public VentasCRUD(String ID){
        consult.searchVenta(ID);
    }
    
    public void setProductLot(int productLot) {
        this.productLot = productLot;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getProductLot() {
        return productLot;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public String getDni() {
        return dni;
    }

    public String getCodProduct() {
        return codProduct;
    }

    public String getIdClient() {
        return idClient;
    }
    
    public void insert(){
        consult.insertSale(ID, productLot, totalPrice, dni, codProduct, idClient, "Ventas");
    }
    
    public void modify(){
        String fields= "";
        
        if(productLot != 0) fields += " CantidadProducto = '" + productLot + "', ";
        if(totalPrice != 0) fields += " PrecioTotal = '" + totalPrice + "', ";

        if(!fields.isEmpty()){
            fields = fields.substring(0, fields.split("").length-2);
        
            String update = "UPDATE Ventas SET " + fields
                            + " WHERE Id_Venta = '" + ID + "'"; 

            consult.modify(ID, update, "Ventas");
        }else JOptionPane.showMessageDialog(null, "No se ha insertado ningun valor", 
                "Modificacion", JOptionPane.WARNING_MESSAGE);
    }
    
    public void delete(){
        String delete = "DELETE FROM Ventas WHERE Id_Venta = '" + ID + "'";
        consult.delete(ID, delete , "Ventas");
    }
    
}
