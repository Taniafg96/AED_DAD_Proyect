
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
        //prueba
    }
}
