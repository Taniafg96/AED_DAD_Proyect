/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

/**
 *
 * @author Cristo
 */
public class Clientes {
    //Atributos
    private String id;
    private String Nombre;
    private String Direccion = null;
    private String Telefono = null;
    private String Correo = null;
    
    //Contructores
    public Clientes(){};
    
    public Clientes (String id, String Nombre, String Direccion, String Telefono, String Correo){
        this.id = id;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }
    
    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    //Metodo toString
    @Override
    public String toString(){
        return id + " " + Nombre + " " + Direccion + " " + Telefono + " " + Correo; 
    }
}
