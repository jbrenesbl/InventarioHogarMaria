/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.Datos.Proveedor;
import javax.swing.JOptionPane;

/**
 *
 * @author JoBren8
 */
public class JdlgNuevoProveedor extends javax.swing.JDialog {

    //Variables
    Proveedor proveedor = new Proveedor();

    public JdlgNuevoProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null); //Centrar Ventana
    }

    //Constructor para ser llamado desde un JDialog
    public JdlgNuevoProveedor(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null); //Centrar Ventana
    }

    private boolean validarCampos() {
        //NOMBRE PROVEEDOR - OBLIGATORIO
        if (jtxtNombreProveedor.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "El nombre del proveedor, no puede estar vacío!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            jtxtNombreProveedor.requestFocus();
            return false;
        } else if (jtxtNombreProveedor.getText().length() > 500) {
            JOptionPane.showMessageDialog(this, "El nombre del proveedor, no puede ser mayor a 500 carácteres!",
                    "Verifique", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //TELEFONO
        if (jtxtTelefono.getText().length() > 15) {
            JOptionPane.showMessageDialog(this, "El teléfono, no puede ser mayor a 15 carácteres!",
                    "Verifique", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean añadirProveedor() {
        proveedor.setNombreProveedor(jtxtNombreProveedor.getText());
        proveedor.setTelefono(jtxtTelefono.getText());
        return proveedor.insertarProveedor();
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
        jlblTituloNombreProveedor = new javax.swing.JLabel();
        jtxtNombreProveedor = new javax.swing.JTextField();
        jlblTituloTelefono = new javax.swing.JLabel();
        jtxtTelefono = new javax.swing.JTextField();
        jbtnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Proveedor");
        setResizable(false);

        jpnlTitulo.setLayout(new java.awt.GridLayout(1, 0));

        jlblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NuevoProveedor32x32.png"))); // NOI18N
        jlblTitulo.setText("Nuevo Proveedor");
        jpnlTitulo.add(jlblTitulo);

        jpnlContenedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblTituloNombreProveedor.setText("Nombre del Proveedor:");

        jtxtNombreProveedor.setToolTipText("Nombre del proveedor");

        jlblTituloTelefono.setText("Teléfono:");

        jtxtTelefono.setToolTipText("Teléfono de referencia del proveedor");

        jbtnAceptar.setText("Aceptar");
        jbtnAceptar.setToolTipText("Crear el nuevo proveedor");
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
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnAceptar)
                    .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpnlContenedorLayout.createSequentialGroup()
                            .addComponent(jlblTituloNombreProveedor)
                            .addGap(18, 18, 18)
                            .addComponent(jtxtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpnlContenedorLayout.createSequentialGroup()
                            .addComponent(jlblTituloTelefono)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpnlContenedorLayout.setVerticalGroup(
            jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTituloNombreProveedor)
                    .addComponent(jtxtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTituloTelefono)
                    .addComponent(jtxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if (validarCampos()) {
            if (añadirProveedor()) {
                JOptionPane.showMessageDialog(this, "Proveedor agregado!", "Listo!",
                        JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido agregar el proveedor", "Uuupppsss!",
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
            java.util.logging.Logger.getLogger(JdlgNuevoProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlgNuevoProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlgNuevoProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlgNuevoProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JdlgNuevoProveedor dialog = new JdlgNuevoProveedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblTituloNombreProveedor;
    private javax.swing.JLabel jlblTituloTelefono;
    private javax.swing.JPanel jpnlContenedor;
    private javax.swing.JPanel jpnlPincipal;
    private javax.swing.JPanel jpnlTitulo;
    private javax.swing.JTextField jtxtNombreProveedor;
    private javax.swing.JTextField jtxtTelefono;
    // End of variables declaration//GEN-END:variables
}
