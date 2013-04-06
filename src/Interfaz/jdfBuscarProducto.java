/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.Auxiliares.BusquedasBaseDatos;
import Clases.Auxiliares.NoEditableTableModel;
import Clases.Datos.Producto;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author JoBren8
 */
public class jdfBuscarProducto extends javax.swing.JDialog {

    //Variables
    Producto producto = new Producto();
    jdfMovimientoEntrada padreEntrada;
    jdfMovimientoSalida padreSalida;
    int tipoMovimiento = 0;

    public jdfBuscarProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public jdfBuscarProducto(javax.swing.JDialog parent, boolean modal, int movimiento) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        inicializarDatos();
        this.tipoMovimiento = movimiento;
        switch (tipoMovimiento) {
            case 0:
                this.padreEntrada = (jdfMovimientoEntrada) parent;
                break;
            case 1:
                this.padreSalida = (jdfMovimientoSalida) parent;
                break;
        }
    }

    private void inicializarDatos() {
        try {
            //CATEGORIAS
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

            //UNIDADES MEDIDA
            rs = BusquedasBaseDatos.buscarUnidadesMedida();
            modeloCombo = new DefaultComboBoxModel();

            //Llenamos el modelo del combobox
            while (rs.next()) {
                modeloCombo.addElement(rs.getObject(1));
            }
            jcbxUnidadMedida.setModel(modeloCombo);
            //Cerramos la conexion
            BusquedasBaseDatos.cerrar();

        } catch (Exception ex) {
        }

//        //Añadimos el evento de Doble Click al JTable
//        jtblResultados.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {                
//            }
//        });
    }

    private void buscarProducto() {

        //Parametros a buscar
        String nombre = "";
        String categoria = "";
        String unidadMedida = "";

        //Verificamos cuales estan con check
        if (jckbNombre.isSelected()) {
            nombre = jtxtNombre.getText();
        }
        if (jckbCategoria.isSelected()) {
            categoria = jcbxCategoria.getSelectedItem().toString();
        }
        if (jckbUnidadMedida.isSelected()) {
            unidadMedida = jcbxUnidadMedida.getSelectedItem().toString();
        }

        boolean vacio = true;
        try {
            ResultSet rs = BusquedasBaseDatos.buscarProducto(nombre, categoria, unidadMedida);

            //Creamos un modelo no editable de celdas
            NoEditableTableModel modelo = new NoEditableTableModel();
            jtblResultados.setModel(modelo);

            // Creamos las columnas.
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Categoría");
            modelo.addColumn("Unidad Medida");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Estado");

            // Se crea un array que será una de las filas de la tabla. 
            Object[] fila = new Object[6]; // Hay cuatro columnas en la tabla
            while (rs.next()) {
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                }
                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
                //Se indica que el ResultSet no esta vacio
                vacio = false;
            }
            BusquedasBaseDatos.cerrar();

            if (vacio) {
                JOptionPane.showMessageDialog(this, "No se encontro el producto.", "Uppsss!",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "No se encontro el producto.", "Uppsss!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error.", "Uppsss!", JOptionPane.ERROR_MESSAGE);
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

        jpnlBuscarProductos = new VistaJPanelConFondo.JPanelConFondo();
        jpnlTitulo = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jpnlDatosBuscar = new javax.swing.JPanel();
        jckbNombre = new javax.swing.JCheckBox();
        jtxtNombre = new javax.swing.JTextField();
        jckbCategoria = new javax.swing.JCheckBox();
        jcbxCategoria = new javax.swing.JComboBox();
        jckbUnidadMedida = new javax.swing.JCheckBox();
        jcbxUnidadMedida = new javax.swing.JComboBox();
        jbtnBuscar = new javax.swing.JButton();
        jpnlResultados = new javax.swing.JPanel();
        jspnResultados = new javax.swing.JScrollPane();
        jtblResultados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Producto");
        setResizable(false);

        jpnlTitulo.setLayout(new java.awt.GridLayout(1, 0));

        jlblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTitulo.setText("Buscar Producto");
        jpnlTitulo.add(jlblTitulo);

        jpnlDatosBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jckbNombre.setText("Nombre");

        jckbCategoria.setText("Categoria");

        jckbUnidadMedida.setText("Unidad Medida");

        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnBuscarProducto32x32.png"))); // NOI18N
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlDatosBuscarLayout = new javax.swing.GroupLayout(jpnlDatosBuscar);
        jpnlDatosBuscar.setLayout(jpnlDatosBuscarLayout);
        jpnlDatosBuscarLayout.setHorizontalGroup(
            jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jckbUnidadMedida)
                    .addComponent(jckbCategoria)
                    .addComponent(jckbNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addComponent(jcbxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 138, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnlDatosBuscarLayout.setVerticalGroup(
            jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jckbNombre)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jckbCategoria)
                            .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jckbUnidadMedida)
                            .addComponent(jcbxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jpnlResultados.setLayout(new java.awt.GridLayout(1, 0));

        jtblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Categoría", "Unidad Medida", "Cantidad", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblResultados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtblResultados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblResultadosMouseClicked(evt);
            }
        });
        jspnResultados.setViewportView(jtblResultados);

        jpnlResultados.add(jspnResultados);

        javax.swing.GroupLayout jpnlBuscarProductosLayout = new javax.swing.GroupLayout(jpnlBuscarProductos);
        jpnlBuscarProductos.setLayout(jpnlBuscarProductosLayout);
        jpnlBuscarProductosLayout.setHorizontalGroup(
            jpnlBuscarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlBuscarProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlBuscarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnlDatosBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlResultados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnlBuscarProductosLayout.setVerticalGroup(
            jpnlBuscarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlBuscarProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnlDatosBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnlResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnlBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        buscarProducto();
        jtblResultados.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jtblResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblResultadosMouseClicked
        if (evt.getClickCount() > 1) {
            int fila = jtblResultados.rowAtPoint(evt.getPoint());
            int columna = jtblResultados.columnAtPoint(evt.getPoint());
            if ((fila > -1) && (columna > -1)) {
                producto.llenarDatos(BusquedasBaseDatos.buscarProductoDetallado(
                        Integer.parseInt(jtblResultados.getModel().getValueAt(fila, 0).toString())));
                BusquedasBaseDatos.cerrar();
                switch (tipoMovimiento) {
                    case 0:
                        padreEntrada.setProducto(producto);
                        break;
                    case 1:
                        padreSalida.setProducto(producto);
                }
                dispose();
            }
        }
    }//GEN-LAST:event_jtblResultadosMouseClicked

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
            java.util.logging.Logger.getLogger(jdfBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdfBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdfBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdfBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                jdfBuscarProducto dialog = new jdfBuscarProducto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JComboBox jcbxCategoria;
    private javax.swing.JComboBox jcbxUnidadMedida;
    private javax.swing.JCheckBox jckbCategoria;
    private javax.swing.JCheckBox jckbNombre;
    private javax.swing.JCheckBox jckbUnidadMedida;
    private javax.swing.JLabel jlblTitulo;
    private VistaJPanelConFondo.JPanelConFondo jpnlBuscarProductos;
    private javax.swing.JPanel jpnlDatosBuscar;
    private javax.swing.JPanel jpnlResultados;
    private javax.swing.JPanel jpnlTitulo;
    private javax.swing.JScrollPane jspnResultados;
    private javax.swing.JTable jtblResultados;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
