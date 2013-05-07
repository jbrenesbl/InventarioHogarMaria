/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.Auxiliares.BusquedasBaseDatos;
import Clases.Datos.Producto;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JoBren8
 */
public class JdlgNuevoProducto extends javax.swing.JDialog {

    //Variables
    Producto producto = new Producto();
    boolean comboboxEditable = false;

    public JdlgNuevoProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null); //Centrar Ventana
        inicializarDatos();
    }

    //Constructor para ser llamado desde un JDialog
    public JdlgNuevoProducto(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
    }

    private boolean añadirProducto() {
        producto.setNombre(jtxtNombreProducto.getText());
        producto.setCategoria(jcbxCategoria.getSelectedItem().toString());
        producto.setUnidadMedida(jtxtUnidadMedida.getText());
        producto.setCantidadMinima(Double.parseDouble(jtxtCantidadMinima.getText()));
        return producto.insertarProducto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlPincipal = new javax.swing.JPanel();
        jpnlTitulo = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jpnlContenedor = new javax.swing.JPanel();
        jlblTituloNombreProducto = new javax.swing.JLabel();
        jtxtNombreProducto = new javax.swing.JTextField();
        jlblTituloCategoria = new javax.swing.JLabel();
        jcbxCategoria = new javax.swing.JComboBox();
        jbtnNuevaCategoria = new javax.swing.JButton();
        jlblTituloUnidadMedida = new javax.swing.JLabel();
        jtxtUnidadMedida = new javax.swing.JTextField();
        jlblTituloCantidadMinima = new javax.swing.JLabel();
        jtxtCantidadMinima = new javax.swing.JTextField();
        jbtnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Producto");
        setResizable(false);

        jpnlTitulo.setLayout(new java.awt.GridLayout(1, 0));

        jlblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTitulo.setText("Nuevo Producto");
        jpnlTitulo.add(jlblTitulo);

        jpnlContenedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblTituloNombreProducto.setText("Nombre del Producto:");

        jlblTituloCategoria.setText("Categoría:");

        jbtnNuevaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNuevo16x16.png"))); // NOI18N
        jbtnNuevaCategoria.setToolTipText("Crear Nuevo Producto");
        jbtnNuevaCategoria.setMaximumSize(new java.awt.Dimension(32, 32));
        jbtnNuevaCategoria.setMinimumSize(new java.awt.Dimension(32, 32));
        jbtnNuevaCategoria.setPreferredSize(new java.awt.Dimension(18, 18));
        jbtnNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevaCategoriaActionPerformed(evt);
            }
        });

        jlblTituloUnidadMedida.setText("Unidad de Medida:");

        jlblTituloCantidadMinima.setText("Cantidad Mínima:");

        jbtnAceptar.setText("Aceptar");
        jbtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlContenedorLayout = new javax.swing.GroupLayout(jpnlContenedor);
        jpnlContenedor.setLayout(jpnlContenedorLayout);
        jpnlContenedorLayout.setHorizontalGroup(
            jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlContenedorLayout.createSequentialGroup()
                        .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblTituloNombreProducto)
                            .addComponent(jlblTituloCategoria)
                            .addComponent(jlblTituloUnidadMedida)
                            .addComponent(jlblTituloCantidadMinima))
                        .addGap(18, 18, 18)
                        .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtCantidadMinima)
                            .addComponent(jtxtUnidadMedida)
                            .addComponent(jtxtNombreProducto)
                            .addGroup(jpnlContenedorLayout.createSequentialGroup()
                                .addComponent(jcbxCategoria, 0, 293, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlContenedorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnAceptar)))
                .addContainerGap())
        );
        jpnlContenedorLayout.setVerticalGroup(
            jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTituloNombreProducto)
                    .addComponent(jtxtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlblTituloCategoria))
                    .addComponent(jbtnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTituloUnidadMedida)
                    .addComponent(jtxtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTituloCantidadMinima)
                    .addComponent(jtxtCantidadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnlPincipalLayout = new javax.swing.GroupLayout(jpnlPincipal);
        jpnlPincipal.setLayout(jpnlPincipalLayout);
        jpnlPincipalLayout.setHorizontalGroup(
            jpnlPincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlPincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlPincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnlPincipalLayout.createSequentialGroup()
                        .addComponent(jpnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnlPincipalLayout.setVerticalGroup(
            jpnlPincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlPincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAceptarActionPerformed
        if (añadirProducto()) {
            JOptionPane.showMessageDialog(this, "Producto agregado!", "Listo!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se ha podido agregar el producto", "Uuupppsss!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(JdlgNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlgNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlgNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlgNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JdlgNuevoProducto dialog = new JdlgNuevoProducto(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblTituloCantidadMinima;
    private javax.swing.JLabel jlblTituloCategoria;
    private javax.swing.JLabel jlblTituloNombreProducto;
    private javax.swing.JLabel jlblTituloUnidadMedida;
    private javax.swing.JPanel jpnlContenedor;
    private javax.swing.JPanel jpnlPincipal;
    private javax.swing.JPanel jpnlTitulo;
    private javax.swing.JTextField jtxtCantidadMinima;
    private javax.swing.JTextField jtxtNombreProducto;
    private javax.swing.JTextField jtxtUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
