/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import CRUD.ClienteCRUD;
import Conexion.*;
import java.util.ArrayList;

/**
 *
 * @author Cristo
 */
public class Main {
    public static void main(String[] args) {
        //Clientes cl = new Clientes("qazsdq", "Lucas", "Lucas", "45", "asf@");
        //System.out.println(cl.toString());
        
        
//        ArrayList <String> campos = new ArrayList <String>();
//        campos.add("Nombre");
//        campos.add("edad");
//        campos.add("Apellidos");
//        new ClienteCRUD().select(campos);

        //Clientes cl = new Clientes("qazsdq", "Lugo", cl.getDireccion(), "", "");
        //new ClienteCRUD().update(cl);
        
        new CreateDB();
    }
}
