/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import images.img.Borr2;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Cristo
 */
public class PrincipalFrame extends javax.swing.JFrame {

     private Inicio in = new Inicio();
     
    public PrincipalFrame() {
        initComponents();
        nuevoPanel(in); 
        setLocationRelativeTo (null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        menuLogout = new javax.swing.JLabel();
        menuInicio = new javax.swing.JLabel();
        menuClientes = new javax.swing.JLabel();
        menuProductos = new javax.swing.JLabel();
        menuVentas = new javax.swing.JLabel();
        menuGrafico = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        menu.setBackground(new java.awt.Color(0, 148, 174));
        menu.setPreferredSize(new java.awt.Dimension(1042, 50));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menuLogout.setForeground(new java.awt.Color(255, 255, 255));
        menuLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuLogout.setText("LOGOUT");
        menuLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuLogoutMouseExited(evt);
            }
        });
        menu.add(menuLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 80, 50));

        menuInicio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menuInicio.setForeground(new java.awt.Color(255, 255, 255));
        menuInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuInicio.setText("INICIO");
        menuInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuInicioMouseExited(evt);
            }
        });
        menu.add(menuInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 50));

        menuClientes.setBackground(new java.awt.Color(102, 255, 102));
        menuClientes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menuClientes.setForeground(new java.awt.Color(255, 255, 255));
        menuClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuClientes.setText("CLIENTES");
        menuClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuClientesMouseExited(evt);
            }
        });
        menu.add(menuClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 80, 50));

        menuProductos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menuProductos.setForeground(new java.awt.Color(255, 255, 255));
        menuProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuProductos.setText("PROUDCTOS");
        menuProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuProductosMouseExited(evt);
            }
        });
        menu.add(menuProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 100, 50));

        menuVentas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menuVentas.setForeground(new java.awt.Color(255, 255, 255));
        menuVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuVentas.setText("VENTAS");
        menuVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuVentasMouseExited(evt);
            }
        });
        menu.add(menuVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 80, 50));

        menuGrafico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menuGrafico.setForeground(new java.awt.Color(255, 255, 255));
        menuGrafico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuGrafico.setText("GRAFICO");
        menuGrafico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuGrafico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuGraficoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuGraficoMouseExited(evt);
            }
        });
        menu.add(menuGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 80, 50));

        getContentPane().add(menu, java.awt.BorderLayout.PAGE_START);

        contenedor.setBackground(new java.awt.Color(230, 251, 255));
        contenedor.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(230, 251, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1042, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        contenedor.add(jPanel1, "card2");

        getContentPane().add(contenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseEntered
        menuClientes.setForeground(new Color(0, 80, 94));
    }//GEN-LAST:event_menuClientesMouseEntered

    private void menuClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseExited
        menuClientes.setForeground(Color.white);
    }//GEN-LAST:event_menuClientesMouseExited

    private void menuInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuInicioMouseEntered
        menuInicio.setForeground(new Color(0, 80, 94));
    }//GEN-LAST:event_menuInicioMouseEntered

    private void menuInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuInicioMouseExited
        menuInicio.setForeground(Color.white);
    }//GEN-LAST:event_menuInicioMouseExited

    private void menuProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProductosMouseEntered
        menuProductos.setForeground(new Color(0, 80, 94)); 
    }//GEN-LAST:event_menuProductosMouseEntered

    private void menuProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProductosMouseExited
        menuProductos.setForeground(Color.white);
    }//GEN-LAST:event_menuProductosMouseExited

    private void menuVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuVentasMouseEntered
        menuVentas.setForeground(new Color(0, 80, 94));
    }//GEN-LAST:event_menuVentasMouseEntered

    private void menuVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuVentasMouseExited
        menuVentas.setForeground(Color.white);
    }//GEN-LAST:event_menuVentasMouseExited

    private void menuGraficoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGraficoMouseEntered
        menuGrafico.setForeground(new Color(0, 80, 94));
    }//GEN-LAST:event_menuGraficoMouseEntered

    private void menuGraficoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGraficoMouseExited
        menuGrafico.setForeground(Color.white);
    }//GEN-LAST:event_menuGraficoMouseExited

    private void menuLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseEntered
        menuLogout.setForeground(new Color(0, 80, 94));
    }//GEN-LAST:event_menuLogoutMouseEntered

    private void menuLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseExited
         menuLogout.setForeground(Color.white);
    }//GEN-LAST:event_menuLogoutMouseExited

    private void menuClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseClicked
        Clientess cl = new Clientess();
        nuevoPanel(cl);
    }//GEN-LAST:event_menuClientesMouseClicked

    private void menuInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuInicioMouseClicked
        nuevoPanel(in); 
    }//GEN-LAST:event_menuInicioMouseClicked

    //Metodo para pintar los paneles
    public void nuevoPanel(JPanel panel){
        contenedor.removeAll();
        contenedor.add(panel);
        contenedor.repaint();
        contenedor.revalidate();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel menuClientes;
    private javax.swing.JLabel menuGrafico;
    private javax.swing.JLabel menuInicio;
    private javax.swing.JLabel menuLogout;
    private javax.swing.JLabel menuProductos;
    private javax.swing.JLabel menuVentas;
    // End of variables declaration//GEN-END:variables
}
