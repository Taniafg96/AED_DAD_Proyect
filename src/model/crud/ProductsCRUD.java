package model.crud;

import model.storedProcedure.Consults;

/**
 *
 * @author Usuario
 */
public class ProductsCRUD {
    private final String codigo;
    private final String nombre;
    private final String tipo;
    private final String descripcion;
    private final float precio;
    private static final String CODIGOALMACEN = "QWERTY001";
    private final Consults consult = new Consults(); 
    
    public ProductsCRUD(String codigo, String nombre, String tipo, String descripcion, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
    } 

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public String getCodigoAlmacen() {
        return CODIGOALMACEN;
    }
    
    public void deleteProduct(){
        String delete = "DELETE FROM Productos WHERE codigo = '" + codigo + "'";
        consult.delete(codigo, delete, "producto");
    }
    
    public void updateProduct(){
        String fields= "";
        
        if(!nombre.isEmpty()) fields += "nombre = '" + nombre + "', ";
        if(!tipo.isEmpty()) fields += "tipo = '" + tipo + "', ";
        if(!descripcion.isEmpty()) fields += "descripcion = '" + descripcion + "', ";
        if(precio != 0 ) fields += "precio = '" + precio + "', ";

        if(!fields.isEmpty()) fields = fields.substring(0, fields.split("").length-2);

        String update = "UPDATE Productos SET " + fields
                        + " WHERE codigo = '" + codigo + "'"; 
        
        consult.modify(codigo, update, "Productos");
    }
    
    public void insertProduct(){
        consult.insertProduct(codigo, nombre, tipo, descripcion, precio, 
            CODIGOALMACEN, "Productos");
    }
    
}
