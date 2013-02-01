/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JOptionPane;

/**
 *
 * @author JoBren8
 */
public class jdfMovimientoSalida extends javax.swing.JDialog {

    /**
     * Creates new form jdfMovimientoSalida
     */
    public jdfMovimientoSalida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnPrincipal = new VistaJPanelConFondo.JPanelConFondo();
        jpnlTituloVentana = new javax.swing.JPanel();
        jlblTituloVentana = new javax.swing.JLabel();
        jpnDatosEntrada = new javax.swing.JPanel();
        jlblTituloConsecutivo = new javax.swing.JLabel();
        jtxtConsecutivo = new javax.swing.JTextField();
        jlblTituloFecha = new javax.swing.JLabel();
        jtxtFecha = new javax.swing.JTextField();
        jlblTituloObservacion = new javax.swing.JLabel();
        jtxtObservacion = new javax.swing.JTextField();
        jlblTituloEncargado = new javax.swing.JLabel();
        jtxtEncargado = new javax.swing.JTextField();
        jpnlDatosProducto = new javax.swing.JPanel();
        jbtnBuscarProducto = new javax.swing.JButton();
        jlblTituloCodigo = new javax.swing.JLabel();
        jtxtCodigo = new javax.swing.JTextField();
        jlblTituloNombre = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jlblTituloUnidadMedida = new javax.swing.JLabel();
        jtxtUnidadMedida = new javax.swing.JTextField();
        jlblTituloCategoria = new javax.swing.JLabel();
        jcbxCategoria = new javax.swing.JComboBox();
        jlblTituloCantidad = new javax.swing.JLabel();
        jtxtCantidad = new javax.swing.JTextField();
        jlblDatosPorAplicar = new javax.swing.JPanel();
        jspnProductos = new javax.swing.JScrollPane();
        jtblProductos = new javax.swing.JTable();
        jbtnAplicar = new javax.swing.JButton();
        jbtnDescartar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Salida de Productos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnlTituloVentana.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnlTituloVentana.setLayout(new java.awt.GridLayout());

        jlblTituloVentana.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jlblTituloVentana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTituloVentana.setText("Salida de Productos");
        jpnlTituloVentana.add(jlblTituloVentana);

        jpnPrincipal.add(jpnlTituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 750, 70));

        jpnDatosEntrada.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnDatosEntrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblTituloConsecutivo.setText("Consecutivo:");
        jpnDatosEntrada.add(jlblTituloConsecutivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, 73, -1));

        jtxtConsecutivo.setText("236");
        jtxtConsecutivo.setToolTipText("Consecutivo del Movimiento");
        jtxtConsecutivo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxtConsecutivo.setEnabled(false);
        jpnDatosEntrada.add(jtxtConsecutivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 13, 77, -1));

        jlblTituloFecha.setText("Fecha:");
        jpnDatosEntrada.add(jlblTituloFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 16, 43, -1));

        jtxtFecha.setText("11/01/2013");
        jtxtFecha.setToolTipText("Fecha del Movimiento");
        jtxtFecha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxtFecha.setEnabled(false);
        jpnDatosEntrada.add(jtxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 13, 77, -1));

        jlblTituloObservacion.setText("Observación:");
        jpnDatosEntrada.add(jlblTituloObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, 74, -1));

        jtxtObservacion.setToolTipText("Descripción de la Salida");
        jpnDatosEntrada.add(jtxtObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 51, 630, -1));

        jlblTituloEncargado.setText("Encargado:");
        jpnDatosEntrada.add(jlblTituloEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 92, 65, -1));

        jtxtEncargado.setToolTipText("Encargado de la Salida");
        jpnDatosEntrada.add(jtxtEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 89, 630, -1));

        jpnPrincipal.add(jpnDatosEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 750, 120));

        jpnlDatosProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnBuscarProducto32x32.png"))); // NOI18N
        jbtnBuscarProducto.setMaximumSize(new java.awt.Dimension(32, 32));
        jbtnBuscarProducto.setMinimumSize(new java.awt.Dimension(32, 32));
        jbtnBuscarProducto.setPreferredSize(new java.awt.Dimension(36, 36));
        jbtnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarProductoActionPerformed(evt);
            }
        });

        jlblTituloCodigo.setText("Código:");
        jlblTituloCodigo.setPreferredSize(new java.awt.Dimension(47, 14));

        jtxtCodigo.setToolTipText("Código del Producto");
        jtxtCodigo.setEnabled(false);

        jlblTituloNombre.setText("Nombre:");
        jlblTituloNombre.setPreferredSize(new java.awt.Dimension(51, 14));

        jtxtNombre.setToolTipText("Nombre del Producto");
        jtxtNombre.setEnabled(false);

        jlblTituloUnidadMedida.setText("Unidad Medida:");
        jlblTituloUnidadMedida.setPreferredSize(new java.awt.Dimension(84, 14));

        jtxtUnidadMedida.setToolTipText("Unidad de Medida");
        jtxtUnidadMedida.setEnabled(false);

        jlblTituloCategoria.setText("Categoría:");
        jlblTituloCategoria.setPreferredSize(new java.awt.Dimension(61, 14));

        jcbxCategoria.setToolTipText("Categoría del Producto");
        jcbxCategoria.setPreferredSize(new java.awt.Dimension(190, 20));

        jlblTituloCantidad.setText("Cantidad:");
        jlblTituloCantidad.setPreferredSize(new java.awt.Dimension(57, 14));

        jtxtCantidad.setToolTipText("Cantidad a Retirar");

        javax.swing.GroupLayout jpnlDatosProductoLayout = new javax.swing.GroupLayout(jpnlDatosProducto);
        jpnlDatosProducto.setLayout(jpnlDatosProductoLayout);
        jpnlDatosProductoLayout.setHorizontalGroup(
            jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatosProductoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDatosProductoLayout.createSequentialGroup()
                        .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblTituloNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblTituloCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlDatosProductoLayout.createSequentialGroup()
                                .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlblTituloUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlblTituloCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jpnlDatosProductoLayout.createSequentialGroup()
                        .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnlDatosProductoLayout.createSequentialGroup()
                                .addComponent(jlblTituloCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jpnlDatosProductoLayout.setVerticalGroup(
            jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatosProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDatosProductoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlblTituloCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDatosProductoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlblTituloNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblTituloCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblTituloCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlblTituloUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jpnPrincipal.add(jpnlDatosProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 213, 750, 160));

        jlblDatosPorAplicar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlblDatosPorAplicar.setLayout(new java.awt.GridLayout());

        jtblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Categoría", "Unidad Medida", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtblProductos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jspnProductos.setViewportView(jtblProductos);

        jlblDatosPorAplicar.add(jspnProductos);

        jpnPrincipal.add(jlblDatosPorAplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 383, 750, 191));

        jbtnAplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAplicar44x44.png"))); // NOI18N
        jbtnAplicar.setToolTipText("Aplicar Cambios");
        jpnPrincipal.add(jbtnAplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 580, 48, 48));

        jbtnDescartar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnDescartar44x44.png"))); // NOI18N
        jbtnDescartar.setToolTipText("Descartar Cambios");
        jbtnDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDescartarActionPerformed(evt);
            }
        });
        jpnPrincipal.add(jbtnDescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, 48, 48));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarProductoActionPerformed
        jdfBuscarProducto ventanaBuscarProducto = new jdfBuscarProducto(this, true);
        ventanaBuscarProducto.setVisible(true);
    }//GEN-LAST:event_jbtnBuscarProductoActionPerformed

    private void jbtnDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDescartarActionPerformed
        //Al presionar el boton, se pregunta si se desea cdescartar los cambios
        if (JOptionPane.showConfirmDialog(null, "¿Realmente desea descartar los cambios?", "Descartar", JOptionPane.YES_NO_OPTION) == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_jbtnDescartarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //Al presionar el boton, se pregunta si se desea cerrar la ventana
        if (JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?", "Salir", JOptionPane.YES_NO_OPTION) == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(jdfMovimientoSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdfMovimientoSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdfMovimientoSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdfMovimientoSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                jdfMovimientoSalida dialog = new jdfMovimientoSalida(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnAplicar;
    private javax.swing.JButton jbtnBuscarProducto;
    private javax.swing.JButton jbtnDescartar;
    private javax.swing.JComboBox jcbxCategoria;
    private javax.swing.JPanel jlblDatosPorAplicar;
    private javax.swing.JLabel jlblTituloCantidad;
    private javax.swing.JLabel jlblTituloCategoria;
    private javax.swing.JLabel jlblTituloCodigo;
    private javax.swing.JLabel jlblTituloConsecutivo;
    private javax.swing.JLabel jlblTituloEncargado;
    private javax.swing.JLabel jlblTituloFecha;
    private javax.swing.JLabel jlblTituloNombre;
    private javax.swing.JLabel jlblTituloObservacion;
    private javax.swing.JLabel jlblTituloUnidadMedida;
    private javax.swing.JLabel jlblTituloVentana;
    private javax.swing.JPanel jpnDatosEntrada;
    private VistaJPanelConFondo.JPanelConFondo jpnPrincipal;
    private javax.swing.JPanel jpnlDatosProducto;
    private javax.swing.JPanel jpnlTituloVentana;
    private javax.swing.JScrollPane jspnProductos;
    private javax.swing.JTable jtblProductos;
    private javax.swing.JTextField jtxtCantidad;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtConsecutivo;
    private javax.swing.JTextField jtxtEncargado;
    private javax.swing.JTextField jtxtFecha;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtObservacion;
    private javax.swing.JTextField jtxtUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
