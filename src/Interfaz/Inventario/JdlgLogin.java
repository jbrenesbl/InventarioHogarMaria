/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Inventario;

import Clases.Auxiliares.BusquedasBaseDatos;
import Clases.Datos.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author JoBren8
 */
public class JdlgLogin extends javax.swing.JFrame {

    /**
     * Creates new form JdlgLogin
     */
    public JdlgLogin(java.awt.Frame parent, boolean modal) {
        aplicaAspecto();
        initComponents();
        this.setLocationRelativeTo(null); //Centrar la ventana
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/icohm.png"));

        return retValue.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    }

    private void aplicaAspecto() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
    }

    private Usuario iniciarSesion(String nombreUsuario, char[] password) {
        try {
            String clave = new String(password);
            Usuario usuario = new Usuario();
            ResultSet rs = BusquedasBaseDatos.buscarUsuario(nombreUsuario, clave);
            while (rs.next()) {
                usuario.setUsuario(nombreUsuario);
                usuario.setRol(rs.getObject(2).toString());
                BusquedasBaseDatos.cerrar();
                return usuario;
            }
            return usuario;
        } catch (Exception ex) {
            return null;
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
        jlblTituloUsuario = new javax.swing.JLabel();
        jtxtUsuario = new javax.swing.JTextField();
        jlblTituloPassword = new javax.swing.JLabel();
        jtxtPassword = new javax.swing.JPasswordField();
        jbtnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Inventario - Entrar");
        setIconImage(getIconImage());
        setResizable(false);

        jpnlPrincipal.setImagen("/Imagenes/Background.jpg");

        jpnlContenedor.setOpaque(false);

        jlblTituloUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblTituloUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlblTituloUsuario.setText("Usuario:");

        jtxtUsuario.setText("jbrenesbl");
        jtxtUsuario.setToolTipText("Nombre de usuario a ingresar al sistema");
        jtxtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtUsuarioKeyPressed(evt);
            }
        });

        jlblTituloPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblTituloPassword.setForeground(new java.awt.Color(255, 255, 255));
        jlblTituloPassword.setText("Contraseña:");

        jtxtPassword.setText("jbrenesbl");
        jtxtPassword.setToolTipText("Contraseña del usuario");
        jtxtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtPasswordKeyPressed(evt);
            }
        });

        jbtnEntrar.setText("Entrar");
        jbtnEntrar.setToolTipText("Entrar al sistema");
        jbtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlContenedorLayout = new javax.swing.GroupLayout(jpnlContenedor);
        jpnlContenedor.setLayout(jpnlContenedorLayout);
        jpnlContenedorLayout.setHorizontalGroup(
            jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnEntrar)
                    .addGroup(jpnlContenedorLayout.createSequentialGroup()
                        .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblTituloPassword)
                            .addComponent(jlblTituloUsuario))
                        .addGap(18, 18, 18)
                        .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtUsuario)
                            .addComponent(jtxtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlContenedorLayout.setVerticalGroup(
            jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTituloUsuario)
                    .addComponent(jtxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTituloPassword)
                    .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnEntrar)
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

    private void jbtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEntrarActionPerformed
        Usuario usuario = iniciarSesion(jtxtUsuario.getText(), jtxtPassword.getPassword());
        if (usuario != null) {
            if (!usuario.getUsuario().equals("")) {
                JfrmPrincipal ventanaPrincipal = new JfrmPrincipal(usuario);
                this.dispose();
                ventanaPrincipal.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al intentar conectar al motor de base de datos. \nPóngase en contacto con su administrador de sistema.", "Error al conectar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnEntrarActionPerformed

    private void jtxtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtPasswordKeyPressed
        if (evt.getKeyCode() == 10) {
            Usuario usuario = iniciarSesion(jtxtUsuario.getText(), jtxtPassword.getPassword());
            if (usuario != null) {
                JfrmPrincipal ventanaPrincipal = new JfrmPrincipal(usuario);
                this.dispose();
                ventanaPrincipal.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jtxtPasswordKeyPressed

    private void jtxtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtUsuarioKeyPressed
        if (evt.getKeyCode() == 10) {
            Usuario usuario = iniciarSesion(jtxtUsuario.getText(), jtxtPassword.getPassword());
            if (usuario != null) {
                if (!usuario.getUsuario().equals("")) {
                    JfrmPrincipal ventanaPrincipal = new JfrmPrincipal(usuario);
                    this.dispose();
                    ventanaPrincipal.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al intentar conectar al motor de base de datos. \nPongase en contacto con su administrador de sistema.", "Error al conectar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jtxtUsuarioKeyPressed

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
            java.util.logging.Logger.getLogger(JdlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JdlgLogin dialog = new JdlgLogin(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnEntrar;
    private javax.swing.JLabel jlblTituloPassword;
    private javax.swing.JLabel jlblTituloUsuario;
    private javax.swing.JPanel jpnlContenedor;
    private VistaJPanelConFondo.JPanelConFondo jpnlPrincipal;
    private javax.swing.JPasswordField jtxtPassword;
    private javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}
