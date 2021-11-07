/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ViewProductsPanel extends JPanel{
    private JTextField[] products;
    
    public ViewProductsPanel(){
        this.setSize(400, 400);
        this.setBackground(Color.red);
    }
}
