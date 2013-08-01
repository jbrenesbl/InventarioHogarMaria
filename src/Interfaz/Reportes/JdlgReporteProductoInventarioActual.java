/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Reportes;

import Clases.Auxiliares.BusquedasBaseDatos;
import Clases.Auxiliares.Reportes;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jobren8
 */
public class JdlgReporteProductoInventarioActual extends javax.swing.JDialog {

    //Variables
    String condicionSQL;

    public JdlgReporteProductoInventarioActual(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializarDatos();
        setLocationRelativeTo(null);
    }

    private void inicializarDatos() {
        //Descarmar el checkbox de la fecha
        jckbUltimaEntrada.setSelected(false);
        jckbUltimaSalida.setSelected(false);

        ResultSet rs;
        try {
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

    private boolean validarCampos() {
        //RANGO DE FECHAS ULTIMA ENTRADA           
        //No Vacías
        if (jckbUltimaEntrada.isSelected()) {
            if (jdchUltimaEntradaInicial.getDate() != null & jdchUltimaEntradaFinal.getDate() != null) {
                //Fecha Inicio menor que Fecha Final
                if (jdchUltimaEntradaInicial.getDate().after(jdchUltimaEntradaFinal.getDate())) {
                    JOptionPane.showMessageDialog(this, "La fecha inicio no puede ser mayor a la fecha final!",
                            "Verifique", JOptionPane.INFORMATION_MESSAGE);
                    jdchUltimaSalidaInicial.requestFocus();
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ambas fechas!", "Verifique",
                        JOptionPane.INFORMATION_MESSAGE);
                jdchUltimaEntradaInicial.requestFocus();
                return false;
            }
        }

        //RANGO DE FECHAS ULTIMA SALIDA           
        //No Vacías
        if (jckbUltimaSalida.isSelected()) {
            if (jdchUltimaSalidaInicial.getDate() != null & jdchUltimaSalidaFinal.getDate() != null) {
                //Fecha Inicio menor que Fecha Final
                if (jdchUltimaSalidaInicial.getDate().after(jdchUltimaSalidaFinal.getDate())) {
                    JOptionPane.showMessageDialog(this, "La fecha inicio no puede ser mayor a la fecha final!",
                            "Verifique", JOptionPane.INFORMATION_MESSAGE);
                    jdchUltimaSalidaInicial.requestFocus();
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ambas fechas!", "Verifique",
                        JOptionPane.INFORMATION_MESSAGE);
                jdchUltimaSalidaInicial.requestFocus();
                return false;
            }
        }
        return true;
    }

    private void creaCondicion() {
        //Verificamos si existe alguna condicion marcada
        if (jckbNombre.isSelected() | jckbCategoria.isSelected() | jckbUnidadMedida.isSelected()
                | jckbEstado.isSelected() | jckbUltimaEntrada.isSelected() | jckbUltimaSalida.isSelected()) {
            //Iniciamos la condicion
            condicionSQL = " WHERE ";

            //NOMBRE
            if (jckbNombre.isSelected()) {
                condicionSQL += "productos.Nombre LIKE '%" + jtxtNombre.getText().replace("'", "''") + "%' AND ";
            }

            //CATEGORIA
            if (jckbCategoria.isSelected()) {
                condicionSQL += "productos.Categoria = '"
                        + jcbxCategoria.getSelectedItem().toString().replace("'", "''") + "' AND ";
            }

            //UNIDAD MEDIDA
            if (jckbUnidadMedida.isSelected()) {
                condicionSQL += "productos.UnidadMedida = '"
                        + jcbxUnidadMedida.getSelectedItem().toString().replace("'", "''") + "' AND ";
            }

            //ESTADO
            if (jckbEstado.isSelected()) {
                condicionSQL += "productos.Estado = '"
                        + jcbxEstado.getSelectedItem().toString().replace("'", "''") + "' AND ";
            }

            //ULTIMA ENTRADA
            if (jckbUltimaEntrada.isSelected()) {
                String ultimaEntradaInicio = jdchUltimaEntradaInicial.getCalendar().get(Calendar.YEAR) + "-"
                        + (jdchUltimaEntradaInicial.getCalendar().get(Calendar.MONTH) + 1) + "-"
                        + jdchUltimaEntradaInicial.getCalendar().get(Calendar.DATE);
                String ultimaEntradaFin = jdchUltimaEntradaFinal.getCalendar().get(Calendar.YEAR) + "-"
                        + (jdchUltimaEntradaFinal.getCalendar().get(Calendar.MONTH) + 1) + "-"
                        + jdchUltimaEntradaFinal.getCalendar().get(Calendar.DATE);
                condicionSQL += "(productos.UltimaEntrada >= '" + ultimaEntradaInicio + "' AND "
                        + "productos.UltimaEntrada <= '" + ultimaEntradaFin + "') AND ";
            }

            //ULTIMA SALIDA
            if (jckbUltimaSalida.isSelected()) {
                String ultimaSalidaInicio = jdchUltimaSalidaInicial.getCalendar().get(Calendar.YEAR) + "-"
                        + (jdchUltimaSalidaInicial.getCalendar().get(Calendar.MONTH) + 1) + "-"
                        + jdchUltimaSalidaInicial.getCalendar().get(Calendar.DATE);
                String ultimaSalidaFin = jdchUltimaSalidaFinal.getCalendar().get(Calendar.YEAR) + "-"
                        + (jdchUltimaSalidaFinal.getCalendar().get(Calendar.MONTH) + 1) + "-"
                        + jdchUltimaSalidaFinal.getCalendar().get(Calendar.DATE);
                condicionSQL += "(productos.UltimaSalida >= '" + ultimaSalidaInicio + "' AND "
                        + "productos.UltimaSalida <= '" + ultimaSalidaFin + "') AND ";
            }
            
            condicionSQL = condicionSQL.substring(0, condicionSQL.length() - 4);
        } else {
            condicionSQL = "";
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
        jckbEstado = new javax.swing.JCheckBox();
        jcbxEstado = new javax.swing.JComboBox();
        jcbxUnidadMedida = new javax.swing.JComboBox();
        jbtnBuscarMovimientos = new javax.swing.JButton();
        jckbUltimaEntrada = new javax.swing.JCheckBox();
        jdchUltimaEntradaInicial = new com.toedter.calendar.JDateChooser();
        jlblUltimaEntradaHasta = new javax.swing.JLabel();
        jdchUltimaEntradaFinal = new com.toedter.calendar.JDateChooser();
        jckbUltimaSalida = new javax.swing.JCheckBox();
        jdchUltimaSalidaInicial = new com.toedter.calendar.JDateChooser();
        jlblUltimaSalidaHasta = new javax.swing.JLabel();
        jdchUltimaSalidaFinal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte Inventario Actual de Productos");

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

        jckbEstado.setText("Estado");

        jcbxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));
        jcbxEstado.setToolTipText("Estado del producto a buscar");
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

        jbtnBuscarMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnBuscarProducto32x32.png"))); // NOI18N
        jbtnBuscarMovimientos.setToolTipText("Buscar productos según filtro");
        jbtnBuscarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarMovimientosActionPerformed(evt);
            }
        });

        jckbUltimaEntrada.setText("Última Entrada:");

        jdchUltimaEntradaInicial.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdchUltimaEntradaInicialPropertyChange(evt);
            }
        });

        jlblUltimaEntradaHasta.setText("hasta");

        jdchUltimaEntradaFinal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdchUltimaEntradaFinalPropertyChange(evt);
            }
        });

        jckbUltimaSalida.setText("Última Salida:");

        jdchUltimaSalidaInicial.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdchUltimaSalidaInicialPropertyChange(evt);
            }
        });

        jlblUltimaSalidaHasta.setText("hasta");

        jdchUltimaSalidaFinal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdchUltimaSalidaFinalPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jpnlDatosBuscarLayout = new javax.swing.GroupLayout(jpnlDatosBuscar);
        jpnlDatosBuscar.setLayout(jpnlDatosBuscarLayout);
        jpnlDatosBuscarLayout.setHorizontalGroup(
            jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jckbUltimaEntrada)
                                    .addComponent(jckbEstado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                                        .addComponent(jdchUltimaEntradaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlblUltimaEntradaHasta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jdchUltimaEntradaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlDatosBuscarLayout.createSequentialGroup()
                                    .addComponent(jckbCategoria)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlDatosBuscarLayout.createSequentialGroup()
                                    .addComponent(jckbUnidadMedida)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jcbxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlDatosBuscarLayout.createSequentialGroup()
                                .addComponent(jdchUltimaSalidaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblUltimaSalidaHasta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdchUltimaSalidaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnBuscarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jckbUltimaSalida)
                            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                                .addComponent(jckbNombre)
                                .addGap(38, 38, 38)
                                .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 135, Short.MAX_VALUE))))
        );
        jpnlDatosBuscarLayout.setVerticalGroup(
            jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jckbNombre)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jckbCategoria)
                    .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jckbUnidadMedida)
                    .addComponent(jcbxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jckbEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jckbUltimaEntrada)
                    .addComponent(jdchUltimaEntradaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblUltimaEntradaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addComponent(jdchUltimaEntradaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jckbUltimaSalida)
                    .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdchUltimaSalidaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblUltimaSalidaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                            .addComponent(jdchUltimaSalidaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnBuscarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlDatosBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlDatosBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jcbxEstadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbxEstadoFocusGained
        jckbEstado.setSelected(true);
    }//GEN-LAST:event_jcbxEstadoFocusGained

    private void jcbxUnidadMedidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbxUnidadMedidaFocusGained
        jckbUnidadMedida.setSelected(true);
    }//GEN-LAST:event_jcbxUnidadMedidaFocusGained

    private void jbtnBuscarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarMovimientosActionPerformed
        if (validarCampos()) {
            creaCondicion();
            Reportes reporte = new Reportes();
            if (!reporte.reporteProductoInventarioActual(condicionSQL)) {
                JOptionPane.showMessageDialog(this, "No seha podido mostrar el reporte!",
                        "Uuupppsss!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbtnBuscarMovimientosActionPerformed

    private void jdchUltimaEntradaInicialPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdchUltimaEntradaInicialPropertyChange
        jckbUltimaEntrada.setSelected(true);
        jdchUltimaEntradaFinal.requestFocus();
    }//GEN-LAST:event_jdchUltimaEntradaInicialPropertyChange

    private void jdchUltimaEntradaFinalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdchUltimaEntradaFinalPropertyChange
        jckbUltimaEntrada.setSelected(true);
        jdchUltimaSalidaInicial.requestFocus();
    }//GEN-LAST:event_jdchUltimaEntradaFinalPropertyChange

    private void jdchUltimaSalidaInicialPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdchUltimaSalidaInicialPropertyChange
        jckbUltimaSalida.setSelected(true);
        jdchUltimaSalidaFinal.requestFocus();
    }//GEN-LAST:event_jdchUltimaSalidaInicialPropertyChange

    private void jdchUltimaSalidaFinalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdchUltimaSalidaFinalPropertyChange
        jckbUltimaSalida.setSelected(true);
        jbtnBuscarMovimientos.requestFocus();
    }//GEN-LAST:event_jdchUltimaSalidaFinalPropertyChange

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
            java.util.logging.Logger.getLogger(JdlgReporteProductoInventarioActual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlgReporteProductoInventarioActual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlgReporteProductoInventarioActual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlgReporteProductoInventarioActual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JdlgReporteProductoInventarioActual dialog = new JdlgReporteProductoInventarioActual(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox jcbxEstado;
    private javax.swing.JComboBox jcbxUnidadMedida;
    private javax.swing.JCheckBox jckbCategoria;
    private javax.swing.JCheckBox jckbEstado;
    private javax.swing.JCheckBox jckbNombre;
    private javax.swing.JCheckBox jckbUltimaEntrada;
    private javax.swing.JCheckBox jckbUltimaSalida;
    private javax.swing.JCheckBox jckbUnidadMedida;
    private com.toedter.calendar.JDateChooser jdchUltimaEntradaFinal;
    private com.toedter.calendar.JDateChooser jdchUltimaEntradaInicial;
    private com.toedter.calendar.JDateChooser jdchUltimaSalidaFinal;
    private com.toedter.calendar.JDateChooser jdchUltimaSalidaInicial;
    private javax.swing.JLabel jlblUltimaEntradaHasta;
    private javax.swing.JLabel jlblUltimaSalidaHasta;
    private javax.swing.JPanel jpnlDatosBuscar;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
