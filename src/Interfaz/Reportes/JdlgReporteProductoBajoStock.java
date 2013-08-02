/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Reportes;

import Clases.Auxiliares.BusquedasBaseDatos;
import Clases.Auxiliares.Reportes;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jobren8
 */
public class JdlgReporteProductoBajoStock extends javax.swing.JDialog {

    //Variables
    String condicionSQL = "";

    public JdlgReporteProductoBajoStock(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializarDatos();
        setLocationRelativeTo(null);
    }

    private void inicializarDatos() {
        try {
            ResultSet rs;

            //CATEGORIAS
            //Se obtiene el ResultSet con las categorias
            rs = BusquedasBaseDatos.buscarCategorias();

            //Llenamos el modelo del combobox
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            while (rs.next()) {
                modeloCombo.addElement(rs.getObject(1));
            }
            jcbxCategoria.setModel(modeloCombo);
            //Cerramos la conexion
            BusquedasBaseDatos.cerrar();

            //UNIDADES MEDIDA
            //Se obtiene el ResultSet con las unidades de medida
            rs = BusquedasBaseDatos.buscarUnidadesMedida();
            modeloCombo = new DefaultComboBoxModel();

            //Llenamos el modelo del combobox
            while (rs.next()) {
                modeloCombo.addElement(rs.getObject(1));
            }
            jcbxUnidadMedida.setModel(modeloCombo);
            //Cerramos la conexion
            BusquedasBaseDatos.cerrar();
        } catch (Exception e) {
        }
    }

    private void creaCondicion() {
        //Borramos los datos anteriores
        condicionSQL = "";

        //NOMBRE
        if (jckbNombre.isSelected()) {
            condicionSQL += " AND productos.Nombre LIKE '%" + jtxtNombre.getText().replace("'", "''") + "%'";
        }

        //CATEGORIA
        if (jckbCategoria.isSelected()) {
            condicionSQL += " AND productos.Categoria = '"
                    + jcbxCategoria.getSelectedItem().toString().replace("'", "''") + "'";
        }

        //UNIDAD MEDIDA
        if (jckbUnidadMedida.isSelected()) {
            condicionSQL += " AND productos.UnidadMedida = '"
                    + jcbxUnidadMedida.getSelectedItem().toString().replace("'", "''") + "'";
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

        jpnlDatosBuscar = new javax.swing.JPanel();
        jckbNombre = new javax.swing.JCheckBox();
        jtxtNombre = new javax.swing.JTextField();
        jckbCategoria = new javax.swing.JCheckBox();
        jcbxCategoria = new javax.swing.JComboBox();
        jckbUnidadMedida = new javax.swing.JCheckBox();
        jcbxUnidadMedida = new javax.swing.JComboBox();
        jbtnBuscarMovimientos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte Productos con Bajo Stock");
        setResizable(false);

        jpnlDatosBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros"));

        jckbNombre.setText("Nombre");

        jtxtNombre.setToolTipText("Parte del nombre de producto a buscar");
        jtxtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtNombreFocusLost(evt);
            }
        });

        jckbCategoria.setText("Categoría");

        jcbxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbxCategoria.setToolTipText("Categoría a buscar");
        jcbxCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbxCategoriaFocusGained(evt);
            }
        });

        jckbUnidadMedida.setText("Unidad Medida");

        jcbxUnidadMedida.setToolTipText("Unidad de medida a buscar");
        jcbxUnidadMedida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbxUnidadMedidaFocusGained(evt);
            }
        });

        jbtnBuscarMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnBuscarProducto32x32.png"))); // NOI18N
        jbtnBuscarMovimientos.setToolTipText("Buscar productos según filtro");
        jbtnBuscarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarMovimientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlDatosBuscarLayout = new javax.swing.GroupLayout(jpnlDatosBuscar);
        jpnlDatosBuscar.setLayout(jpnlDatosBuscarLayout);
        jpnlDatosBuscarLayout.setHorizontalGroup(
            jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlDatosBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addComponent(jckbCategoria)
                        .addGap(28, 28, 28)
                        .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addComponent(jckbUnidadMedida)
                        .addGap(6, 6, 6)
                        .addComponent(jcbxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnBuscarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlDatosBuscarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jckbNombre)
                .addGap(38, 38, 38)
                .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnlDatosBuscarLayout.setVerticalGroup(
            jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jckbNombre)
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnBuscarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jckbCategoria)
                            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jckbUnidadMedida)
                            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jcbxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnlDatosBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnlDatosBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNombreFocusGained
        jckbNombre.setSelected(true);
    }//GEN-LAST:event_jtxtNombreFocusGained

    private void jtxtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNombreFocusLost
        if ((jtxtNombre.getText().trim()).equals("")) {
            jtxtNombre.setText("");
            jckbNombre.setSelected(false);
        }
    }//GEN-LAST:event_jtxtNombreFocusLost

    private void jcbxCategoriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbxCategoriaFocusGained
        jckbCategoria.setSelected(true);
    }//GEN-LAST:event_jcbxCategoriaFocusGained

    private void jcbxUnidadMedidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbxUnidadMedidaFocusGained
        jckbUnidadMedida.setSelected(true);
    }//GEN-LAST:event_jcbxUnidadMedidaFocusGained

    private void jbtnBuscarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarMovimientosActionPerformed
        creaCondicion();
        Reportes reporte = new Reportes();
        if (!reporte.reporteProductoBajoStock(condicionSQL)) {
            JOptionPane.showMessageDialog(this, "No seha podido mostrar el reporte!",
                    "Uuupppsss!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnBuscarMovimientosActionPerformed

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
            java.util.logging.Logger.getLogger(JdlgReporteProductoBajoStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlgReporteProductoBajoStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlgReporteProductoBajoStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlgReporteProductoBajoStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JdlgReporteProductoBajoStock dialog = new JdlgReporteProductoBajoStock(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnBuscarMovimientos;
    private javax.swing.JComboBox jcbxCategoria;
    private javax.swing.JComboBox jcbxUnidadMedida;
    private javax.swing.JCheckBox jckbCategoria;
    private javax.swing.JCheckBox jckbNombre;
    private javax.swing.JCheckBox jckbUnidadMedida;
    private javax.swing.JPanel jpnlDatosBuscar;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}