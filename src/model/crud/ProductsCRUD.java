/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Connection.ConnectDB;
import model.storedProcedure.SPProducts;

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
    private static final Connection CONNECT = new ConnectDB().getConetion();
    
    public ProductsCRUD(String codigo, String nombre, String tipo, String descripcion, float precio, String codigoAlmacen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.codigoAlmacen = codigoAlmacen;
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
        return codigoAlmacen;
    }
    
}
