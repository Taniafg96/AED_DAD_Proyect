package model.crud;

import javax.swing.JOptionPane;
import model.storedProcedure.Consults;

/**
 *
 * @author Usuario
 */
public class ProductsCRUD {
    private String codigo;
    private String nombre;
    private String tipo;
    private String descripcion;
    private float precio;
    private String CODIGOALMACEN;
    
    private final Consults consult = new Consults(); 
    
    public ProductsCRUD(String codigo, String nombre, String tipo, String descripcion, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.CODIGOALMACEN = "QWERTY001"; 
    } 

    public ProductsCRUD(String codigo, String nombre, String tipo, String descripcion, float precio, String codAlmacen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.CODIGOALMACEN = codAlmacen;
    } 
    
    public ProductsCRUD(String codigo){
        consult.searchProducto(codigo);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
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
    
    public void delete(){
        String delete = "DELETE FROM Productos WHERE codigo = '" + codigo + "'";
        consult.delete(codigo, delete, "Productos", "codigo");
    }
    
    public void modify(){    
        String fields = "";
        
        if(!nombre.isEmpty()) fields += "nombre = '" + nombre + "', ";
        if(!tipo.isEmpty()) fields += "tipo = '" + tipo + "', ";
        if(!descripcion.isEmpty()) fields += "descripcion = '" + descripcion + "', ";
        if(precio != 0 ) fields += "precio = '" + precio + "', ";

        if(!fields.isEmpty()){
            fields = fields.substring(0, fields.split("").length-2);
            String update = "UPDATE Productos SET " + fields
                            + " WHERE codigo = '" + codigo + "'"; 

            consult.modify(codigo, update, "Productos", "codigo");
        }else JOptionPane.showMessageDialog(null, "No se ha insertado ningun valor", 
                "Modificacion", JOptionPane.WARNING_MESSAGE);
    }
    
    public void insert(){
        consult.insertProduct(codigo, nombre, tipo, descripcion, precio, 
            CODIGOALMACEN, "Productos", "codigo");
    }
    
}
