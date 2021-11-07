/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.crud;

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
    private String codigoAlmacen;

    public ProductsCRUD(String codigo, String nombre, String tipo, String descripcion, float precio, String codigoAlmacen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.codigoAlmacen = codigoAlmacen;
    } 
    
}
