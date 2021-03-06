package Interfaz.Reportes;

import Clases.Auxiliares.BusquedasBaseDatos;
import Clases.Auxiliares.HelpMethods;
import Clases.Auxiliares.Reportes;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jobren8
 */
public class JdlgReporteMovimientoHistorico extends javax.swing.JDialog {

    //Variables
    String condicionSQL = "WHERE ";

    public JdlgReporteMovimientoHistorico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null); //Centrar la ventana
        inicializarDatos();
    }

    private void inicializarDatos() {

        //Descarmar el checkbox de la fecha
        jckbFechaMovimiento.setSelected(false);
        //PROVEEDORES
        try {
            //Se obtiene el ResultSet con las categorias
            ResultSet rs = BusquedasBaseDatos.buscarProveedores();
            //Llenamos el modelo del combobox
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            while (rs.next()) {
                modeloCombo.addElement(rs.getObject(1).toString() + " - " + rs.getObject(2).toString());
            }
            jcbxProveedor.setModel(modeloCombo);
            //Cerramos la conexion
            BusquedasBaseDatos.cerrar();
        } catch (Exception ex) {
        }
    }

    private boolean validarCampos() {
        //Validar que al menos una condicion se marque
        if (jckbTipoMovimiento.isSelected() | jckbNumeroFactura.isSelected() | jckbProveedor.isSelected()
                | jckbNumeroCheque.isSelected() | jckbFechaMovimiento.isSelected() | jckbMonto.isSelected()
                | jckbUsuario.isSelected()) {

            //NUMERO FACTURA
            //No vacío
            if (jckbNumeroFactura.isSelected() & jtxtNumeroFactura.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Especifique el numero de factura!", "Verifique",
                        JOptionPane.INFORMATION_MESSAGE);
                jtxtNumeroFactura.requestFocus();
                return false;
            }

            //NUMERO CHEQUE
            //No vacío
            if (jckbNumeroCheque.isSelected() & jtxtNumeroCheque.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Especifique el numero de cheque!", "Verifique",
                        JOptionPane.INFORMATION_MESSAGE);
                jtxtNumeroCheque.requestFocus();
                return false;
            }

            //RANGO DE FECHAS            
            //No Vacías
            if (jckbFechaMovimiento.isSelected()) {
                if (jdchFechaMovimientoInicial.getDate() != null & jdchFechaMovimientoFinal.getDate() != null) {
                    //Fecha Inicio menor que Fecha Final
                    if (jdchFechaMovimientoInicial.getDate().after(jdchFechaMovimientoFinal.getDate())) {
                        JOptionPane.showMessageDialog(this, "La fecha inicio no puede ser mayor a la fecha final!",
                                "Verifique", JOptionPane.INFORMATION_MESSAGE);
                        jtxtNumeroCheque.requestFocus();
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha seleccionado ambas fechas!", "Verifique",
                            JOptionPane.INFORMATION_MESSAGE);
                    jdchFechaMovimientoInicial.requestFocus();
                    return false;
                }
            }

            //RANGO MONTOS
            if (jckbMonto.isSelected()) {
                //No Vacíos
                if ((!jtxtMontoInicial.getText().trim().isEmpty())
                        & (!jtxtMontoFinal.getText().trim().isEmpty())) {
                    //Datos de tipo double
                    if (!HelpMethods.isDouble(jtxtMontoInicial.getText())) {
                        JOptionPane.showMessageDialog(this, "El monto inicial no es un valor numerico!", "Verifique",
                                JOptionPane.INFORMATION_MESSAGE);
                        jtxtMontoInicial.requestFocus();
                        return false;
                    }

                    if (!HelpMethods.isDouble(jtxtMontoFinal.getText())) {
                        JOptionPane.showMessageDialog(this, "El monto final no es un valor numerico!", "Verifique",
                                JOptionPane.INFORMATION_MESSAGE);
                        jtxtMontoInicial.requestFocus();
                        return false;
                    }

                    if (Double.parseDouble(jtxtMontoInicial.getText()) > Double.parseDouble(jtxtMontoFinal.getText())) {
                        JOptionPane.showMessageDialog(this, "El monto inicial no puede ser mayor al monto final!",
                                "Verifique", JOptionPane.INFORMATION_MESSAGE);
                        jtxtMontoInicial.requestFocus();
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha indicado el rango de montos!", "Verifique",
                            JOptionPane.INFORMATION_MESSAGE);
                    jtxtMontoInicial.requestFocus();
                    return false;
                }
            }

            //USUARIO
            if (jckbUsuario.isSelected() & jtxtUsuario.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Especifique el usuario!", "Verifique",
                        JOptionPane.INFORMATION_MESSAGE);
                jtxtUsuario.requestFocus();
                return false;
            }

        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún criterio de filtrado!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void creaCondicion() {
        //Borramos los datos anteriores
        condicionSQL = "WHERE ";
        
        //TIPO MOVIMIENTO
        if (jckbTipoMovimiento.isSelected()) {
            if (jrbtEntrada.isSelected()) {
                condicionSQL += "movimientos.Tipo = 'Entrada' AND ";
            } else {
                condicionSQL += "movimientos.Tipo = 'Salida' AND ";
            }
        }

        //NUMERO FACTURA
        if (jckbNumeroFactura.isSelected()) {
            condicionSQL += "movimientos.NumeroFactura = '" + jtxtNumeroFactura.getText() + "' AND ";
        }

        //PROVEEDOR
        if (jckbProveedor.isSelected()) {
            String[] proveedor = jcbxProveedor.getSelectedItem().toString().split(" - ");
            condicionSQL += "movimientos.idProveedor = " + Integer.parseInt(proveedor[0]) + " AND ";
        }

        //NUMERO CHEQUE
        if (jckbNumeroCheque.isSelected()) {
            condicionSQL += "movimientos.NumeroCheque = '" + jtxtNumeroCheque.getText() + "' AND ";
        }

        //RANGO FECHAS
        if (jckbFechaMovimiento.isSelected()) {
            String fechaInicio = jdchFechaMovimientoInicial.getCalendar().get(Calendar.YEAR) + "-"
                    + (jdchFechaMovimientoInicial.getCalendar().get(Calendar.MONTH) + 1) + "-"
                    + jdchFechaMovimientoInicial.getCalendar().get(Calendar.DATE);
            String fechaFin = jdchFechaMovimientoFinal.getCalendar().get(Calendar.YEAR) + "-"
                    + (jdchFechaMovimientoFinal.getCalendar().get(Calendar.MONTH) + 1) + "-"
                    + jdchFechaMovimientoFinal.getCalendar().get(Calendar.DATE);
            condicionSQL += "(movimientos.FechaMovimiento >= '" + fechaInicio + "' AND "
                    + "movimientos.FechaMovimiento <= '" + fechaFin + "') AND ";
        }

        //MONTO
        if (jckbMonto.isSelected()) {
            condicionSQL += "(m.Monto >= " + jtxtMontoInicial.getText() + " AND "
                    + "m.Monto <= " + jtxtMontoFinal.getText() + ") AND ";
        }

        //USUARIO
        if (jckbUsuario.isSelected()) {
            condicionSQL += "movimientos.Usuario = '" + jtxtUsuario.getText() + "' AND ";
        }
        
        //Quitamos el "AND " del final de la sentencia
        condicionSQL = condicionSQL.substring(0, condicionSQL.length() - 4);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtgTipoMovimiento = new javax.swing.ButtonGroup();
        jpnlContenedorTotal = new VistaJPanelConFondo.JPanelConFondo();
        jpnlDatosBuscar = new javax.swing.JPanel();
        jckbTipoMovimiento = new javax.swing.JCheckBox();
        jrbtEntrada = new javax.swing.JRadioButton();
        jrbtSalida = new javax.swing.JRadioButton();
        jckbNumeroFactura = new javax.swing.JCheckBox();
        jtxtNumeroFactura = new javax.swing.JTextField();
        jckbProveedor = new javax.swing.JCheckBox();
        jcbxProveedor = new javax.swing.JComboBox();
        jckbNumeroCheque = new javax.swing.JCheckBox();
        jtxtNumeroCheque = new javax.swing.JTextField();
        jckbFechaMovimiento = new javax.swing.JCheckBox();
        jdchFechaMovimientoInicial = new com.toedter.calendar.JDateChooser();
        jlblHastaFecha = new javax.swing.JLabel();
        jdchFechaMovimientoFinal = new com.toedter.calendar.JDateChooser();
        jckbMonto = new javax.swing.JCheckBox();
        jtxtMontoInicial = new javax.swing.JTextField();
        jlblHastaMonto = new javax.swing.JLabel();
        jtxtMontoFinal = new javax.swing.JTextField();
        jckbUsuario = new javax.swing.JCheckBox();
        jtxtUsuario = new javax.swing.JTextField();
        jbtnBuscarMovimientos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte Histórico de Movimientos");
        setResizable(false);

        jpnlDatosBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros"));

        jckbTipoMovimiento.setText("Tipo de Movimiento:");

        jbtgTipoMovimiento.add(jrbtEntrada);
        jrbtEntrada.setSelected(true);
        jrbtEntrada.setText("Entrada");
        jrbtEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbtEntradaActionPerformed(evt);
            }
        });

        jbtgTipoMovimiento.add(jrbtSalida);
        jrbtSalida.setText("Salida");
        jrbtSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbtSalidaActionPerformed(evt);
            }
        });

        jckbNumeroFactura.setText("Numero de Factura:");

        jtxtNumeroFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtNumeroFacturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtNumeroFacturaFocusLost(evt);
            }
        });

        jckbProveedor.setText("Proveedor:");

        jcbxProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbxProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbxProveedorFocusGained(evt);
            }
        });

        jckbNumeroCheque.setText("Numero de Cheque:");

        jtxtNumeroCheque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtNumeroChequeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtNumeroChequeFocusLost(evt);
            }
        });

        jckbFechaMovimiento.setText("Fecha Movimiento:");

        jdchFechaMovimientoInicial.setNextFocusableComponent(jckbMonto);
        jdchFechaMovimientoInicial.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdchFechaMovimientoInicialPropertyChange(evt);
            }
        });

        jlblHastaFecha.setText("hasta");

        jdchFechaMovimientoFinal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdchFechaMovimientoFinalPropertyChange(evt);
            }
        });

        jckbMonto.setText("Monto:");

        jtxtMontoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtMontoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtMontoInicialFocusLost(evt);
            }
        });

        jlblHastaMonto.setText("hasta");

        jtxtMontoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtMontoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtMontoFinalFocusLost(evt);
            }
        });

        jckbUsuario.setText("Usuario:");

        jtxtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtUsuarioFocusLost(evt);
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
            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jckbTipoMovimiento)
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jckbNumeroFactura)
                            .addComponent(jckbProveedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                                .addComponent(jrbtEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbtSalida))
                            .addComponent(jtxtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jckbNumeroCheque)
                    .addComponent(jckbFechaMovimiento)
                    .addComponent(jckbMonto)
                    .addComponent(jckbUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtNumeroCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                                .addComponent(jdchFechaMovimientoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblHastaFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdchFechaMovimientoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                        .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                                .addComponent(jtxtMontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblHastaMonto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnBuscarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jpnlDatosBuscarLayout.setVerticalGroup(
            jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbtEntrada)
                    .addComponent(jrbtSalida)
                    .addComponent(jckbTipoMovimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jckbNumeroFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jckbProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jckbNumeroCheque)
                    .addComponent(jtxtNumeroCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jckbFechaMovimiento)
                    .addComponent(jdchFechaMovimientoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jlblHastaFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdchFechaMovimientoFinal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtMontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblHastaMonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jckbMonto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlDatosBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jckbUsuario)))
            .addGroup(jpnlDatosBuscarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtnBuscarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpnlContenedorTotalLayout = new javax.swing.GroupLayout(jpnlContenedorTotal);
        jpnlContenedorTotal.setLayout(jpnlContenedorTotalLayout);
        jpnlContenedorTotalLayout.setHorizontalGroup(
            jpnlContenedorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlContenedorTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlDatosBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnlContenedorTotalLayout.setVerticalGroup(
            jpnlContenedorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlContenedorTotalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnlDatosBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlContenedorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlContenedorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbtEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbtEntradaActionPerformed
        jckbTipoMovimiento.setSelected(true);
    }//GEN-LAST:event_jrbtEntradaActionPerformed

    private void jrbtSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbtSalidaActionPerformed
        jckbTipoMovimiento.setSelected(true);
    }//GEN-LAST:event_jrbtSalidaActionPerformed

    private void jtxtNumeroFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNumeroFacturaFocusGained
        jckbNumeroFactura.setSelected(true);
    }//GEN-LAST:event_jtxtNumeroFacturaFocusGained

    private void jtxtNumeroFacturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNumeroFacturaFocusLost
        if ((jtxtNumeroFactura.getText().trim()).equals("")) {
            jtxtNumeroFactura.setText("");
            jckbNumeroFactura.setSelected(false);
        }
    }//GEN-LAST:event_jtxtNumeroFacturaFocusLost

    private void jtxtNumeroChequeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNumeroChequeFocusGained
        jckbNumeroCheque.setSelected(true);
    }//GEN-LAST:event_jtxtNumeroChequeFocusGained

    private void jtxtNumeroChequeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNumeroChequeFocusLost
        if ((jtxtNumeroCheque.getText().trim()).equals("")) {
            jtxtNumeroCheque.setText("");
            jckbNumeroCheque.setSelected(false);
        }
    }//GEN-LAST:event_jtxtNumeroChequeFocusLost

    private void jdchFechaMovimientoInicialPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdchFechaMovimientoInicialPropertyChange
        jckbFechaMovimiento.setSelected(true);
        jdchFechaMovimientoFinal.requestFocus();
    }//GEN-LAST:event_jdchFechaMovimientoInicialPropertyChange

    private void jdchFechaMovimientoFinalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdchFechaMovimientoFinalPropertyChange
        jckbFechaMovimiento.setSelected(true);
        jckbMonto.requestFocus();
    }//GEN-LAST:event_jdchFechaMovimientoFinalPropertyChange

    private void jtxtMontoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtMontoInicialFocusGained
        jckbMonto.setSelected(true);
    }//GEN-LAST:event_jtxtMontoInicialFocusGained

    private void jtxtMontoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtMontoFinalFocusGained
        jckbMonto.setSelected(true);
    }//GEN-LAST:event_jtxtMontoFinalFocusGained

    private void jtxtMontoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtMontoInicialFocusLost
        if ((jtxtMontoInicial.getText().trim()).equals("") & (jtxtMontoFinal.getText().trim()).equals("")) {
            jtxtMontoInicial.setText("");
            jtxtMontoFinal.setText("");
            jckbMonto.setSelected(false);
        }
    }//GEN-LAST:event_jtxtMontoInicialFocusLost

    private void jtxtMontoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtMontoFinalFocusLost
        if ((jtxtMontoInicial.getText().trim()).equals("") & (jtxtMontoFinal.getText().trim()).equals("")) {
            jtxtMontoInicial.setText("");
            jtxtMontoFinal.setText("");
            jckbMonto.setSelected(false);
        }
    }//GEN-LAST:event_jtxtMontoFinalFocusLost

    private void jtxtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtUsuarioFocusGained
        jckbUsuario.setSelected(true);
    }//GEN-LAST:event_jtxtUsuarioFocusGained

    private void jtxtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtUsuarioFocusLost
        if ((jtxtUsuario.getText().trim()).equals("")) {
            jtxtUsuario.setText("");
            jckbUsuario.setSelected(false);
        }
    }//GEN-LAST:event_jtxtUsuarioFocusLost

    private void jcbxProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbxProveedorFocusGained
        jckbProveedor.setSelected(true);
    }//GEN-LAST:event_jcbxProveedorFocusGained

    private void jbtnBuscarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarMovimientosActionPerformed
        if (validarCampos()) {
            creaCondicion();
            Reportes reporte = new Reportes();
            if (!reporte.reporteMovimientoHistorico(condicionSQL)) {
                JOptionPane.showMessageDialog(this, "No seha podido mostrar el reporte!", 
                        "Uuupppsss!", JOptionPane.ERROR_MESSAGE);
            }
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
            java.util.logging.Logger.getLogger(JdlgReporteMovimientoHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlgReporteMovimientoHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlgReporteMovimientoHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlgReporteMovimientoHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JdlgReporteMovimientoHistorico dialog = new JdlgReporteMovimientoHistorico(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup jbtgTipoMovimiento;
    private javax.swing.JButton jbtnBuscarMovimientos;
    private javax.swing.JComboBox jcbxProveedor;
    private javax.swing.JCheckBox jckbFechaMovimiento;
    private javax.swing.JCheckBox jckbMonto;
    private javax.swing.JCheckBox jckbNumeroCheque;
    private javax.swing.JCheckBox jckbNumeroFactura;
    private javax.swing.JCheckBox jckbProveedor;
    private javax.swing.JCheckBox jckbTipoMovimiento;
    private javax.swing.JCheckBox jckbUsuario;
    private com.toedter.calendar.JDateChooser jdchFechaMovimientoFinal;
    private com.toedter.calendar.JDateChooser jdchFechaMovimientoInicial;
    private javax.swing.JLabel jlblHastaFecha;
    private javax.swing.JLabel jlblHastaMonto;
    private VistaJPanelConFondo.JPanelConFondo jpnlContenedorTotal;
    private javax.swing.JPanel jpnlDatosBuscar;
    private javax.swing.JRadioButton jrbtEntrada;
    private javax.swing.JRadioButton jrbtSalida;
    private javax.swing.JTextField jtxtMontoFinal;
    private javax.swing.JTextField jtxtMontoInicial;
    private javax.swing.JTextField jtxtNumeroCheque;
    private javax.swing.JTextField jtxtNumeroFactura;
    private javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}
