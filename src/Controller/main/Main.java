/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;


import model.Connection.CreateDB;
import view.Login2;

/**
 *
 * @author Cristo
 */
public class Main {
    public static void main(String[] args) {
        new CreateDB("root", "EstoesunaPRUEBA!!DAM");
        Login2 login = new Login2();
    }
}
