package crud;

import javax.swing.JOptionPane;
import utils.Consults;
import utils.Utils;

/**
 *
 * @author Usuario
 */
public class VentasCRUD {
    private static int ID;
    private int productLot;
    private float totalPrice;
    private String dni;
    private String codProduct;
    private String idClient;

    private final Consults consult = new Consults(); 
    
    public VentasCRUD(int productLot, String dni, String codProduct, String idClient) {
        this.productLot = productLot;
        this.totalPrice = new Utils().calculateTotalPriceSale(productLot, codProduct);
        this.dni = dni;
        this.codProduct = codProduct;
        this.idClient = idClient;
    }

    public VentasCRUD(int ID, int productLot, float totalPrice, String dni, String codProduct, String idClient) {
        this.ID = ID;
        this.productLot = productLot;
        this.totalPrice = totalPrice;
        this.dni = dni;
        this.codProduct = codProduct;
        this.idClient = idClient;
    }
    
    public VentasCRUD(){
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
        consult.insertSale(productLot, totalPrice, dni, codProduct, idClient);
    }
    
    public void modify(int ID){
        String update = "UPDATE Ventas SET CantidadProducto = '" + productLot 
                    + "' WHERE Id_Venta = '" + ID + "'"; 

        consult.modifySale(ID, update);
    }
    
    public void delete(int ID){
        String delete = "DELETE FROM Ventas WHERE Id_Venta = '" + ID + "'";
        consult.deleteSale(ID, delete);
    }
    
}