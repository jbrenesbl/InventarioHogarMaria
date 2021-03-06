/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Inventario;

import Clases.Auxiliares.BusquedasBaseDatos;
import Clases.Datos.Usuario;
import Interfaz.Administracion.JdlgCrearUsuario;
import Interfaz.Administracion.JdlgModificarUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JoBren8
 */
public class JdlgConfirmarPermiso extends javax.swing.JDialog {

    //Variables
    String usuarioActual;
    String tipoPadre;

    public JdlgConfirmarPermiso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //Centrar la ventana
    }

    public JdlgConfirmarPermiso(JdlgMovimientosSalida parent, boolean modal, String usuarioActual) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //Centrar la ventana
        this.usuarioActual = usuarioActual;
        this.tipoPadre = "Movimiento Salida";
    }

    public JdlgConfirmarPermiso(JdlgMovimientosEntrada parent, boolean modal, String usuarioActual) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //Centrar la ventana
        this.usuarioActual = usuarioActual;
        this.tipoPadre = "Movimiento Entrada";
    }

    public JdlgConfirmarPermiso(JdlgMovimientosAsignarCheque parent, boolean modal, String usuarioActual) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //Centrar la ventana
        this.usuarioActual = usuarioActual;
        this.tipoPadre = "Asignar Cheque";
    }
    
    public JdlgConfirmarPermiso(JdlgCrearUsuario parent, boolean modal, String usuarioActual) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //Centrar la ventana
        this.usuarioActual = usuarioActual;
        this.tipoPadre = "Crear Usuario";
    }
    
    public JdlgConfirmarPermiso(JdlgModificarUsuario parent, boolean modal, String usuarioActual) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //Centrar la ventana
        this.usuarioActual = usuarioActual;
        this.tipoPadre = "Modificar Usuario";
    }

    private boolean iniciarSesion(String nombreUsuario, char[] password) {
        try {
            String clave = new String(password);
            ResultSet rs = BusquedasBaseDatos.buscarUsuario(nombreUsuario, clave);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuario(nombreUsuario);
                usuario.setRol(rs.getObject(2).toString());
                BusquedasBaseDatos.cerrar();
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
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

        jpnlPrincipal = new VistaJPanelConFondo.JPanelConFondo();
        jpnlContenedor = new javax.swing.JPanel();
        jlblTituloPassword = new javax.swing.JLabel();
        jtxtPassword = new javax.swing.JPasswordField();
        jbtnPermitir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmar Permiso");
        setModal(true);
        setResizable(false);

        jpnlPrincipal.setImagen("/Imagenes/Background.jpg");

        jpnlContenedor.setOpaque(false);

        jlblTituloPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblTituloPassword.setForeground(new java.awt.Color(255, 255, 255));
        jlblTituloPassword.setText("Contraseña:");

        jtxtPassword.setToolTipText("Contraseña del usuario que permitirá la acción");

        jbtnPermitir.setText("Permitir");
        jbtnPermitir.setToolTipText("Permitir acción");
        jbtnPermitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPermitirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlContenedorLayout = new javax.swing.GroupLayout(jpnlContenedor);
        jpnlContenedor.setLayout(jpnlContenedorLayout);
        jpnlContenedorLayout.setHorizontalGroup(
            jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnPermitir)
                    .addGroup(jpnlContenedorLayout.createSequentialGroup()
                        .addComponent(jlblTituloPassword)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlContenedorLayout.setVerticalGroup(
            jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTituloPassword)
                    .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnPermitir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnlPrincipalLayout = new javax.swing.GroupLayout(jpnlPrincipal);
        jpnlPrincipal.setLayout(jpnlPrincipalLayout);
        jpnlPrincipalLayout.setHorizontalGroup(
            jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlPrincipalLayout.setVerticalGroup(
            jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPermitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPermitirActionPerformed
        boolean permiso = iniciarSesion(this.usuarioActual, jtxtPassword.getPassword());
        if (permiso) {
            this.dispose();
            if (tipoPadre.equals("Movimiento Salida")) {
                ((JdlgMovimientosSalida) this.getOwner()).setConfirmarPermiso(true);
            } else if (tipoPadre.equals("Movimiento Entrada")) {
                ((JdlgMovimientosEntrada) this.getOwner()).setConfirmarPermiso(true);
            } else if (tipoPadre.equals("Asignar Cheque")) {
                ((JdlgMovimientosAsignarCheque) this.getOwner()).setConfirmarPermiso(true);
            } else if (tipoPadre.equals("Crear Usuario")) {
                ((JdlgCrearUsuario) this.getOwner()).setConfirmarPermiso(true);
            } else if (tipoPadre.equals("Modificar Usuario")) {
                ((JdlgModificarUsuario) this.getOwner()).setConfirmarPermiso(true);
            } 
        } else {
            if (tipoPadre.equals("Movimiento Salida")) {
                ((JdlgMovimientosSalida) this.getOwner()).setConfirmarPermiso(false);
            } else if (tipoPadre.equals("Movimiento Entrada")) {
                ((JdlgMovimientosEntrada) this.getOwner()).setConfirmarPermiso(false);
            } else if (tipoPadre.equals("Asignar Cheque")) {
                ((JdlgMovimientosAsignarCheque) this.getOwner()).setConfirmarPermiso(false);
            } else if (tipoPadre.equals("Crear Usuario")) {
                ((JdlgCrearUsuario) this.getOwner()).setConfirmarPermiso(false);
            } else if (tipoPadre.equals("Modificar Usuario")) {
                ((JdlgModificarUsuario) this.getOwner()).setConfirmarPermiso(false);
            }
            JOptionPane.showMessageDialog(this, "Contraseña Incorrecta", "Error de autentificación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnPermitirActionPerformed

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
            java.util.logging.Logger.getLogger(JdlgConfirmarPermiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlgConfirmarPermiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlgConfirmarPermiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlgConfirmarPermiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JdlgConfirmarPermiso dialog = new JdlgConfirmarPermiso(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnPermitir;
    private javax.swing.JLabel jlblTituloPassword;
    private javax.swing.JPanel jpnlContenedor;
    private VistaJPanelConFondo.JPanelConFondo jpnlPrincipal;
    private javax.swing.JPasswordField jtxtPassword;
    // End of variables declaration//GEN-END:variables
}
