/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Inventario;

import Clases.Auxiliares.BusquedasBaseDatos;
import Clases.Auxiliares.NoEditableTableModel;
import Clases.Auxiliares.RenderHeader;
import Clases.Datos.Producto;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JoBren8
 */
public class JdlgProductosConsultarModificar extends javax.swing.JDialog {

    //Variables
    NoEditableTableModel modeloProductos;

    public JdlgProductosConsultarModificar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        //Asignamos el nuevo Render del Header para que los titulos estan centrados
        jtblResultados.getTableHeader().setDefaultRenderer(new RenderHeader(jtblResultados));
        inicializarDatos();
    }

    private void inicializarDatos() {
        //Creamos un nuevo modelo
        modeloProductos = new NoEditableTableModel();

        //Asignamos el modelo a la tabla
        jtblResultados.setModel(modeloProductos);

        // Creamos las columnas.
        modeloProductos.addColumn("Código");
        modeloProductos.addColumn("Nombre del Producto");
        modeloProductos.addColumn("Categoría");
        modeloProductos.addColumn("Unidad Medida");
        modeloProductos.addColumn("Cantidad");
        modeloProductos.addColumn("Cantidad Mínima");
        modeloProductos.addColumn("Última Entrada");
        modeloProductos.addColumn("Última Salida");
        modeloProductos.addColumn("Estado");


        //PRODUCTOS
        try {
            //Se obtiene el ResultSet con los productos
            ResultSet rs = BusquedasBaseDatos.buscarProductoDetalladoCodigo(0);

            //Llenamos el modelo de la tabla
            Object[] filaTabla = new Object[9];
            while (rs.next()) {
                filaTabla[0] = rs.getObject(1);
                filaTabla[1] = rs.getObject(2);
                filaTabla[2] = rs.getObject(3);
                filaTabla[3] = rs.getObject(4);
                filaTabla[4] = rs.getObject(5);
                filaTabla[5] = rs.getObject(6);
                filaTabla[6] = rs.getObject(7);
                filaTabla[7] = rs.getObject(8);
                filaTabla[8] = rs.getObject(9);
                modeloProductos.addRow(filaTabla);
            }
            //Cerramos la conexion
            BusquedasBaseDatos.cerrar();

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

        } catch (Exception ex) {
        }
    }

    private void buscarProducto() {

        //Parametros a buscar
        String nombre = "";
        String categoria = "";
        String unidadMedida = "";
        String estado = "*";

        //Verificamos cuales estan con check
        if (jckbNombre.isSelected()) {
            nombre = jtxtNombre.getText().trim();
        }
        if (jckbCategoria.isSelected()) {
            categoria = jcbxCategoria.getSelectedItem().toString();
        }
        if (jckbUnidadMedida.isSelected()) {
            unidadMedida = jcbxUnidadMedida.getSelectedItem().toString();
        }
        if (jckbEstado.isSelected()) {
            estado = jcbxEstado.getSelectedItem().toString();
        }

        boolean vacio = true;
        try {
            ResultSet rs = BusquedasBaseDatos.buscarProductoDetallado(
                    nombre, categoria, unidadMedida, estado);

            //Creamos un modelo no editable de celdas
            modeloProductos = new NoEditableTableModel();
            jtblResultados.setModel(modeloProductos);

            // Creamos las columnas.
            modeloProductos.addColumn("Código");
            modeloProductos.addColumn("Nombre del Producto");
            modeloProductos.addColumn("Categoría");
            modeloProductos.addColumn("Unidad Medida");
            modeloProductos.addColumn("Cantidad");
            modeloProductos.addColumn("Cantidad Mínima");
            modeloProductos.addColumn("Última Entrada");
            modeloProductos.addColumn("Última Salida");
            modeloProductos.addColumn("Estado");

            // Se crea un array que será una de las filas de la tabla. 
            Object[] fila = new Object[9]; // Hay cuatro columnas en la tabla
            while (rs.next()) {
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < 9; i++) {
                    fila[i] = rs.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                }
                // Se añade al modelo la fila completa.
                modeloProductos.addRow(fila);
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

        jpnlConsultarModificarProductos = new VistaJPanelConFondo.JPanelConFondo();
        jpnlTitulo = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jpnlDatosBuscar = new javax.swing.JPanel();
        jckbNombre = new javax.swing.JCheckBox();
        jtxtNombre = new javax.swing.JTextField();
        jckbCategoria = new javax.swing.JCheckBox();
        jcbxCategoria = new javax.swing.JComboBox();
        jckbUnidadMedida = new javax.swing.JCheckBox();
        jckbEstado = new javax.swing.JCheckBox();
        jcbxEstado = new javax.swing.JComboBox();
        jcbxUnidadMedida = new javax.swing.JComboBox();
        jpnlResultados = new javax.swing.JPanel();
        jspnResultados = new javax.swing.JScrollPane();
        jtblResultados = new javax.swing.JTable();
        jbtnRestaurar = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jbtnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar y Modificar Productos");
        setResizable(false);

        jpnlTitulo.setLayout(new java.awt.GridLayout(1, 0));

        jlblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnConsultarProductos32x32.png"))); // NOI18N
        jlblTitulo.setText("Consultar y Modificar Productos");
        jpnlTitulo.add(jlblTitulo);

        jpnlDatosBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jckbEstado.setText("Estado");

        jcbxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));
        jcbxEstado.setToolTipText("Estado del producto a buscar");
        jcbxEstado.setNextFocusableComponent(jbtnRestaurar);
        jcbxEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbxEstadoFocusGained(evt);
            }
        });

        jcbxUnidadMedida.setToolTipText("Unidad de medida a buscar");
        jcbxUnidadMedida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbxUnidadMedidaFocusGained(evt);
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
                    .addComponent(jckbNombre)
                    .addComponent(jckbEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtNombre)
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbxCategoria, 0, 194, Short.MAX_VALUE)
                            .addComponent(jcbxUnidadMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnlDatosBuscarLayout.setVerticalGroup(
            jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                .addContainerGap()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jckbEstado)
                    .addComponent(jcbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpnlResultados.setLayout(new java.awt.GridLayout(1, 0));

        jspnResultados.setToolTipText("Productos encontrados");

        jtblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Categoría", "Unidad Medida", "Cantidad", "Cantidad Mínima", "Última Entrada", "Última Salida", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblResultados.setToolTipText("Productos encontrados");
        jtblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblResultadosMouseClicked(evt);
            }
        });
        jspnResultados.setViewportView(jtblResultados);

        jpnlResultados.add(jspnResultados);

        jbtnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnRestaurar32x32.png"))); // NOI18N
        jbtnRestaurar.setToolTipText("Restablecer todos los productos");
        jbtnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRestaurarActionPerformed(evt);
            }
        });

        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnBuscarProducto32x32.png"))); // NOI18N
        jbtnBuscar.setToolTipText("Buscar productos según filtro");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        jbtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnImprimir32x32.png"))); // NOI18N
        jbtnImprimir.setToolTipText("Imprimir resultado de pantalla");

        javax.swing.GroupLayout jpnlConsultarModificarProductosLayout = new javax.swing.GroupLayout(jpnlConsultarModificarProductos);
        jpnlConsultarModificarProductos.setLayout(jpnlConsultarModificarProductosLayout);
        jpnlConsultarModificarProductosLayout.setHorizontalGroup(
            jpnlConsultarModificarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlConsultarModificarProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlConsultarModificarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnlResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                    .addComponent(jpnlDatosBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlConsultarModificarProductosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnlConsultarModificarProductosLayout.setVerticalGroup(
            jpnlConsultarModificarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlConsultarModificarProductosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jpnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jpnlDatosBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnlResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jpnlConsultarModificarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlConsultarModificarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlConsultarModificarProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        buscarProducto();
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jbtnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRestaurarActionPerformed
        inicializarDatos();
    }//GEN-LAST:event_jbtnRestaurarActionPerformed

    private void jtblResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblResultadosMouseClicked
        if (evt.getClickCount() > 1) {
            int fila = jtblResultados.rowAtPoint(evt.getPoint());
            int columna = jtblResultados.columnAtPoint(evt.getPoint());
            if ((fila > -1) && (columna > -1)) {
                //Creamos un objeto producto y asignamos los valores actuales del mismo
                Producto p = new Producto();
                p.setIdProducto(Integer.parseInt(jtblResultados.getModel().getValueAt(fila, 0).toString()));
                p.setNombre(jtblResultados.getModel().getValueAt(fila, 1).toString());
                p.setCategoria(jtblResultados.getModel().getValueAt(fila, 2).toString());
                p.setUnidadMedida(jtblResultados.getModel().getValueAt(fila, 3).toString());
                p.setCantidadMinima(Double.parseDouble(jtblResultados.getModel().getValueAt(fila, 5).toString()));
                p.setEstado(jtblResultados.getModel().getValueAt(fila, 8).toString());

                //Llamamos la ventana de modificacion y le pasamos el objeto producto
                JdlgProductosModificar ventanaModificarProducto = new JdlgProductosModificar(this, true, p);
                ventanaModificarProducto.setVisible(true);

                //Refrescamos el grid
                inicializarDatos();

            }
        }
    }//GEN-LAST:event_jtblResultadosMouseClicked

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

    private void jcbxEstadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbxEstadoFocusGained
        jckbEstado.setSelected(true);
    }//GEN-LAST:event_jcbxEstadoFocusGained

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
            java.util.logging.Logger.getLogger(JdlgProductosConsultarModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlgProductosConsultarModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlgProductosConsultarModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlgProductosConsultarModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JdlgProductosConsultarModificar dialog = new JdlgProductosConsultarModificar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JButton jbtnRestaurar;
    private javax.swing.JComboBox jcbxCategoria;
    private javax.swing.JComboBox jcbxEstado;
    private javax.swing.JComboBox jcbxUnidadMedida;
    private javax.swing.JCheckBox jckbCategoria;
    private javax.swing.JCheckBox jckbEstado;
    private javax.swing.JCheckBox jckbNombre;
    private javax.swing.JCheckBox jckbUnidadMedida;
    private javax.swing.JLabel jlblTitulo;
    private VistaJPanelConFondo.JPanelConFondo jpnlConsultarModificarProductos;
    private javax.swing.JPanel jpnlDatosBuscar;
    private javax.swing.JPanel jpnlResultados;
    private javax.swing.JPanel jpnlTitulo;
    private javax.swing.JScrollPane jspnResultados;
    private javax.swing.JTable jtblResultados;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
