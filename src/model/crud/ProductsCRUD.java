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

    public ProductsCRUD(){
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
    
    public void delete(String codigo){
        String delete = "DELETE FROM Productos WHERE codigo = '" + codigo + "'";
        consult.deleteProduct(codigo, delete);
    }
    
    public void modify(String codigo, String nombre, String tipo, String descripcion, Float precio){    
        consult.modifyProduct(codigo, nombre, tipo, descripcion, precio);
    }
    
    public void insert(){
        consult.insertProduct(codigo, nombre, tipo, descripcion, precio, 
            CODIGOALMACEN);
    }
    
}
