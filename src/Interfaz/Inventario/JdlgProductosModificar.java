/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Inventario;

import Clases.Auxiliares.BusquedasBaseDatos;
import Clases.Auxiliares.HelpMethods;
import Clases.Datos.Producto;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jobren8
 */
public class JdlgProductosModificar extends javax.swing.JDialog {

    //Variables
    boolean comboboxEditable = false;
    Producto productoModificar;

    public JdlgProductosModificar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    //Constructor para ser llamado desde un JDialog
    public JdlgProductosModificar(java.awt.Dialog parent, boolean modal, Producto producto) {
        super(parent, modal);
        initComponents();
        this.productoModificar = producto;
        setLocationRelativeTo(null); //Centrar Ventana
        inicializarDatos();
    }

    private void inicializarDatos() {
        //CATEGORIAS
        try {
            //Se obtiene el ResultSet con las categorias
            ResultSet rs = BusquedasBaseDatos.buscarCategorias();

            //Llenamos el modelo del combobox
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            while (rs.next()) {
                modeloCombo.addElement(rs.getObject(1));
            }
            jcbxCategoria.setModel(modeloCombo);
            //Cerramos la conexion
            BusquedasBaseDatos.cerrar();
        } catch (Exception ex) {
        }

        //Asignamos los valores actuales
        jtxtCodigo.setText(productoModificar.getIdProducto() + "");
        jtxtNombreProducto.setText(productoModificar.getNombre());
        jcbxCategoria.setSelectedItem(productoModificar.getCategoria());
        jtxtUnidadMedida.setText(productoModificar.getUnidadMedida());
        jtxtCantidadMinima.setText(productoModificar.getCantidadMinima() + "");
        jcbxEstado.setSelectedItem(productoModificar.getEstado());
    }

    private boolean validarCampos() {
        //NOMBRE PRODUCTO - OBLIGATORIO
        if (jtxtNombreProducto.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "El nombre del producto, no puede estar vacío!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            jtxtNombreProducto.requestFocus();
            return false;
        } else if (jtxtNombreProducto.getText().length() > 500) {
            JOptionPane.showMessageDialog(this, "El nombre del producto, no puede ser mayor a 500 carácteres!",
                    "Verifique", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //CATEGORIA - OBLIGATORIO
        if (jcbxCategoria.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "La categoría, no puede estar vacía!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            jcbxCategoria.requestFocus();
            return false;
        } else if (jcbxCategoria.getSelectedItem().toString().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "La categoría, no puede estar vacía!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            jcbxCategoria.requestFocus();
            return false;
        } else if (jcbxCategoria.getSelectedItem().toString().length() > 500) {
            JOptionPane.showMessageDialog(this, "La categoría, no puede ser mayor a 500 carácteres!",
                    "Verifique", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //UNIDAD MEDIDA - OBLIGATORIO
        if (jtxtUnidadMedida.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "La unidad de medida, no puede estar vacía!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            jtxtUnidadMedida.requestFocus();
            return false;
        } else if (jtxtUnidadMedida.getText().length() > 100) {
            JOptionPane.showMessageDialog(this, "La unidad de medida, no puede ser mayor a 100 carácteres!",
                    "Verifique", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //CANTIDAD MINIMA - OBLIGATORIO
        if (jtxtCantidadMinima.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "La cantidad mínima, no puede estar vacía!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            jtxtCantidadMinima.requestFocus();
            return false;
        } else if (!HelpMethods.isDouble(jtxtCantidadMinima.getText())) {
            JOptionPane.showMessageDialog(this, "La cantidad mínima debe ser un valor numérico!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    private boolean modificarProducto() {
        productoModificar.setIdProducto(Integer.parseInt(jtxtCodigo.getText()));
        productoModificar.setNombre(jtxtNombreProducto.getText());
        productoModificar.setCategoria(jcbxCategoria.getSelectedItem().toString());
        productoModificar.setUnidadMedida(jtxtUnidadMedida.getText());
        productoModificar.setCantidadMinima(Double.parseDouble(jtxtCantidadMinima.getText()));
        productoModificar.setEstado(jcbxEstado.getSelectedItem().toString());
        return productoModificar.modificarProducto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlModificarProductos = new VistaJPanelConFondo.JPanelConFondo();
        jpnlTitulo = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jpnlDatosModificar = new javax.swing.JPanel();
        jlblTituloCodigo = new javax.swing.JLabel();
        jtxtCodigo = new javax.swing.JTextField();
        jlblTituloNombreProducto = new javax.swing.JLabel();
        jtxtNombreProducto = new javax.swing.JTextField();
        jlblTituloCategoria = new javax.swing.JLabel();
        jcbxCategoria = new javax.swing.JComboBox();
        jbtnNuevaCategoria = new javax.swing.JButton();
        jlblTituloUnidadMedida = new javax.swing.JLabel();
        jtxtUnidadMedida = new javax.swing.JTextField();
        jlblTituloCantidadMinima = new javax.swing.JLabel();
        jtxtCantidadMinima = new javax.swing.JTextField();
        lblTituloEstado = new javax.swing.JLabel();
        jcbxEstado = new javax.swing.JComboBox();
        jbtnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Producto");
        setResizable(false);

        jpnlTitulo.setLayout(new java.awt.GridLayout(1, 0));

        jlblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTitulo.setText("Modificar Producto");
        jpnlTitulo.add(jlblTitulo);

        jpnlDatosModificar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblTituloCodigo.setText("Código:");

        jtxtCodigo.setToolTipText("Código del producto");
        jtxtCodigo.setEnabled(false);

        jlblTituloNombreProducto.setText("Nombre del Producto:");

        jtxtNombreProducto.setToolTipText("Nombre del Producto");

        jlblTituloCategoria.setText("Categoría:");

        jcbxCategoria.setToolTipText("Categoría del producto");

        jbtnNuevaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNuevo16x16.png"))); // NOI18N
        jbtnNuevaCategoria.setToolTipText("Crear nueva categoría");
        jbtnNuevaCategoria.setMaximumSize(new java.awt.Dimension(32, 32));
        jbtnNuevaCategoria.setMinimumSize(new java.awt.Dimension(32, 32));
        jbtnNuevaCategoria.setPreferredSize(new java.awt.Dimension(18, 18));
        jbtnNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevaCategoriaActionPerformed(evt);
            }
        });

        jlblTituloUnidadMedida.setText("Unidad de Medida:");

        jtxtUnidadMedida.setToolTipText("Unidad de medida del producto");

        jlblTituloCantidadMinima.setText("Cantidad Mínima:");

        jtxtCantidadMinima.setToolTipText("Cantidad mínima que se debe tener en existencia");

        lblTituloEstado.setText("Estado:");

        jcbxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));
        jcbxEstado.setToolTipText("Estado del producto");

        jbtnAceptar.setText("Aceptar");
        jbtnAceptar.setToolTipText("Aplicar los cambios");
        jbtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlDatosModificarLayout = new javax.swing.GroupLayout(jpnlDatosModificar);
        jpnlDatosModificar.setLayout(jpnlDatosModificarLayout);
        jpnlDatosModificarLayout.setHorizontalGroup(
            jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatosModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDatosModificarLayout.createSequentialGroup()
                        .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblTituloNombreProducto)
                            .addComponent(jlblTituloCategoria)
                            .addComponent(jlblTituloCodigo)
                            .addComponent(jlblTituloUnidadMedida)
                            .addComponent(jlblTituloCantidadMinima)
                            .addComponent(lblTituloEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtNombreProducto)
                            .addGroup(jpnlDatosModificarLayout.createSequentialGroup()
                                .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtCantidadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnlDatosModificarLayout.createSequentialGroup()
                                        .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jtxtUnidadMedida, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcbxCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, 203, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbtnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 258, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlDatosModificarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnAceptar)))
                .addContainerGap())
        );
        jpnlDatosModificarLayout.setVerticalGroup(
            jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlDatosModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTituloCodigo)
                    .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTituloNombreProducto)
                    .addComponent(jtxtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnlDatosModificarLayout.createSequentialGroup()
                        .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblTituloCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblTituloUnidadMedida)
                            .addComponent(jtxtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblTituloCantidadMinima)
                            .addComponent(jtxtCantidadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnlDatosModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTituloEstado)
                            .addComponent(jcbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jbtnAceptar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnlModificarProductosLayout = new javax.swing.GroupLayout(jpnlModificarProductos);
        jpnlModificarProductos.setLayout(jpnlModificarProductosLayout);
        jpnlModificarProductosLayout.setHorizontalGroup(
            jpnlModificarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlModificarProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlDatosModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpnlModificarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlModificarProductosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jpnlModificarProductosLayout.setVerticalGroup(
            jpnlModificarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlModificarProductosLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jpnlDatosModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpnlModificarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnlModificarProductosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(227, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlModificarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlModificarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnNuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevaCategoriaActionPerformed
        if (comboboxEditable) {
            inicializarDatos();
            jcbxCategoria.setEditable(false);
            comboboxEditable = false;
        } else {
            jcbxCategoria.setModel(new DefaultComboBoxModel());
            jcbxCategoria.setEditable(true);
            comboboxEditable = true;
        }
    }//GEN-LAST:event_jbtnNuevaCategoriaActionPerformed

    private void jbtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAceptarActionPerformed
        if (validarCampos()) {
            if (modificarProducto()) {
                JOptionPane.showMessageDialog(this, "Producto modificado!", "Listo!", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido modificar el producto", "Uuupppsss!",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbtnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(JdlgProductosModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlgProductosModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlgProductosModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlgProductosModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JdlgProductosModificar dialog = new JdlgProductosModificar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnAceptar;
    private javax.swing.JButton jbtnNuevaCategoria;
    private javax.swing.JComboBox jcbxCategoria;
    private javax.swing.JComboBox jcbxEstado;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblTituloCantidadMinima;
    private javax.swing.JLabel jlblTituloCategoria;
    private javax.swing.JLabel jlblTituloCodigo;
    private javax.swing.JLabel jlblTituloNombreProducto;
    private javax.swing.JLabel jlblTituloUnidadMedida;
    private javax.swing.JPanel jpnlDatosModificar;
    private VistaJPanelConFondo.JPanelConFondo jpnlModificarProductos;
    private javax.swing.JPanel jpnlTitulo;
    private javax.swing.JTextField jtxtCantidadMinima;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtNombreProducto;
    private javax.swing.JTextField jtxtUnidadMedida;
    private javax.swing.JLabel lblTituloEstado;
    // End of variables declaration//GEN-END:variables
}
