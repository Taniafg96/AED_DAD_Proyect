/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

import model.Connection.ConnectDB;
import model.storedProcedure.SPProducts;


/**
 *
 * @author Cristo
 */
public class Main {
    public static void main(String[] args) {
        new ConnectDB();
        new SPProducts().insertProducts("DKJHDGKJ", "Alfombrilla", "Electronico", null, 12);
    }
}
