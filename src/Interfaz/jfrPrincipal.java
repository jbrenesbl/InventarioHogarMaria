/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author JoBren8
 */
public class jfrPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form jfrPrincipal
     */
    public jfrPrincipal() {
        aplicaAspecto();
        initComponents();        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null); //Centrar la ventana        
    }

    private void aplicaAspecto() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlFondo = new VistaJPanelConFondo.JPanelConFondo();
        jpnlBarraEstado = new javax.swing.JPanel();
        jlblTituloUsuario = new javax.swing.JLabel();
        jlblUsuario = new javax.swing.JLabel();
        jmbMenuPrincipal = new javax.swing.JMenuBar();
        jmInventario = new javax.swing.JMenu();
        jmMovimientos = new javax.swing.JMenu();
        jmiEntrada = new javax.swing.JMenuItem();
        jmiSalida = new javax.swing.JMenuItem();
        jmProductos = new javax.swing.JMenu();
        jmiConsultar = new javax.swing.JMenuItem();
        jmiMantenimiento = new javax.swing.JMenuItem();
        jmiBajoStock = new javax.swing.JMenuItem();
        jmReportes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hogar María");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jpnlFondo.setAlignmentX(0.0F);
        jpnlFondo.setAlignmentY(0.0F);
        jpnlFondo.setImagen("/Imagenes/Background.jpg");

        jpnlBarraEstado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnlBarraEstado.setAlignmentX(0.0F);
        jpnlBarraEstado.setAlignmentY(0.0F);

        jlblTituloUsuario.setText("Usuario:");

        jlblUsuario.setText("Texto");

        javax.swing.GroupLayout jpnlBarraEstadoLayout = new javax.swing.GroupLayout(jpnlBarraEstado);
        jpnlBarraEstado.setLayout(jpnlBarraEstadoLayout);
        jpnlBarraEstadoLayout.setHorizontalGroup(
            jpnlBarraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlBarraEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTituloUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
        );
        jpnlBarraEstadoLayout.setVerticalGroup(
            jpnlBarraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlBarraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jlblTituloUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpnlFondoLayout = new javax.swing.GroupLayout(jpnlFondo);
        jpnlFondo.setLayout(jpnlFondoLayout);
        jpnlFondoLayout.setHorizontalGroup(
            jpnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlBarraEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnlFondoLayout.setVerticalGroup(
            jpnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlFondoLayout.createSequentialGroup()
                .addGap(0, 508, Short.MAX_VALUE)
                .addComponent(jpnlBarraEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jmInventario.setText("Inventario");

        jmMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnMovimiento32x32.png"))); // NOI18N
        jmMovimientos.setText("Movimientos");

        jmiEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEntrada32x32.png"))); // NOI18N
        jmiEntrada.setText("Entrada");
        jmiEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEntradaActionPerformed(evt);
            }
        });
        jmMovimientos.add(jmiEntrada);

        jmiSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnSalida32x32.png"))); // NOI18N
        jmiSalida.setText("Salida");
        jmiSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalidaActionPerformed(evt);
            }
        });
        jmMovimientos.add(jmiSalida);

        jmInventario.add(jmMovimientos);

        jmProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnProductos32x32.png"))); // NOI18N
        jmProductos.setText("Productos");

        jmiConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnConsultarProductos32x32.png"))); // NOI18N
        jmiConsultar.setText("Consultar");
        jmiConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultarActionPerformed(evt);
            }
        });
        jmProductos.add(jmiConsultar);

        jmiMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnMantenimientoProductos32x32.png"))); // NOI18N
        jmiMantenimiento.setText("Mantenimiento");
        jmiMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMantenimientoActionPerformed(evt);
            }
        });
        jmProductos.add(jmiMantenimiento);

        jmiBajoStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnBajoStock32x32.png"))); // NOI18N
        jmiBajoStock.setText("Bajo Stock");
        jmiBajoStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBajoStockActionPerformed(evt);
            }
        });
        jmProductos.add(jmiBajoStock);

        jmInventario.add(jmProductos);

        jmbMenuPrincipal.add(jmInventario);

        jmReportes.setText("Reportes");
        jmbMenuPrincipal.add(jmReportes);

        setJMenuBar(jmbMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEntradaActionPerformed
        jdfMovimientoEntrada ventanaMovimientoEntrada = new jdfMovimientoEntrada(this, true);
        ventanaMovimientoEntrada.setVisible(true);
    }//GEN-LAST:event_jmiEntradaActionPerformed

    private void jmiSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalidaActionPerformed
        jdfMovimientoSalida ventanaMovimientoSalida = new jdfMovimientoSalida(this, true);
        ventanaMovimientoSalida.setVisible(true);
    }//GEN-LAST:event_jmiSalidaActionPerformed

    private void jmiConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultarActionPerformed
        jdfConsultarProducto ventanaConsultarProducto = new jdfConsultarProducto(this, true);
        ventanaConsultarProducto.setVisible(true);
    }//GEN-LAST:event_jmiConsultarActionPerformed

    private void jmiMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiMantenimientoActionPerformed

    private void jmiBajoStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBajoStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiBajoStockActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new jfrPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlblTituloUsuario;
    private javax.swing.JLabel jlblUsuario;
    private javax.swing.JMenu jmInventario;
    private javax.swing.JMenu jmMovimientos;
    private javax.swing.JMenu jmProductos;
    private javax.swing.JMenu jmReportes;
    private javax.swing.JMenuBar jmbMenuPrincipal;
    private javax.swing.JMenuItem jmiBajoStock;
    private javax.swing.JMenuItem jmiConsultar;
    private javax.swing.JMenuItem jmiEntrada;
    private javax.swing.JMenuItem jmiMantenimiento;
    private javax.swing.JMenuItem jmiSalida;
    private javax.swing.JPanel jpnlBarraEstado;
    private VistaJPanelConFondo.JPanelConFondo jpnlFondo;
    // End of variables declaration//GEN-END:variables
}
