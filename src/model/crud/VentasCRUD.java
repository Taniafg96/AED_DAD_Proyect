package model.crud;

import model.storedProcedure.Consults;

/**
 *
 * @author Usuario
 */
public class VentasCRUD {
    private static int ID;
    private final int productLot;
    private final float totalPrice;
    private final String dni;
    private String codProduct;
    private final String idClient;

    private final Consults consult = new Consults(); 
    
    public VentasCRUD(int productLot, float totalPrice, String dni, String idClient) {
        this.ID++;
        this.productLot = productLot;
        this.totalPrice = totalPrice;
        this.dni = dni;
        this.idClient = idClient;
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
    
    public void insertSale(){
        consult.insertSale(productLot, totalPrice, dni, codProduct, idClient, "Ventas");
    }
    
    public void modify(){
        String fields= "";
        
        if(productLot != 0) fields += "CantidadProducto = '" + productLot + "', ";
        if(totalPrice != 0) fields += "PrecioTotal = '" + totalPrice + "', ";

        if(!fields.isEmpty()) fields = fields.substring(0, fields.split("").length-2);
        consult.modify(String.valueOf(ID), fields, "Ventas");
    }
    
    public void delete(){
        String delete = "DELETE FROM Ventas WHERE Id_Venta = '" + ID + "'";
        consult.delete(String.valueOf(ID), delete , "Ventas");
    }
    
}
