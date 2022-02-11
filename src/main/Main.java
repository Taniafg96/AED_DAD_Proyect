
package main;


import connection.ConnectDB;
import connection.CreateDB;
import view.Login2;

/**
 *
 * @author Cristo
 */
public class Main {
    public static void main(String[] args) {
        new ConnectDB("root", "admin");
        Login2 login = new Login2();
    }
}
