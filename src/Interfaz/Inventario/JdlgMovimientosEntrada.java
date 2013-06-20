/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Inventario;

import Clases.Auxiliares.BusquedasBaseDatos;
import Clases.Auxiliares.HelpMethods;
import Clases.Auxiliares.NoEditableTableModel;
import Clases.Auxiliares.RenderHeader;
import Clases.Datos.Movimiento;
import Clases.Datos.Producto;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JoBren8
 */
public class JdlgMovimientosEntrada extends javax.swing.JDialog {

    //Varialbles
    Producto producto = null;
    NoEditableTableModel modeloProductos = new NoEditableTableModel();
    boolean confirmarPermiso = false; //Nos indicara si la accion a ejecutar tiene permiso

    /**
     * Creates new form jdfMovimientoEntrada
     */
    public JdlgMovimientosEntrada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        //Asignamos el nuevo Render del Header para que los titulos estan centrados
        jtblProductos.getTableHeader().setDefaultRenderer(new RenderHeader(jtblProductos));
        inicializarDatos();
        crearModeloTablaProductos();
    }

    private void inicializarDatos() {
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

        //FECHA
        Calendar fecha = Calendar.getInstance(TimeZone.getTimeZone("GMT-6:00"));
        jtxtFecha.setText(fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/"
                + fecha.get(Calendar.YEAR));

        //USUARIO
        jtxtEncargado.setText(((JfrmPrincipal) super.getParent()).getUsuarioActual().getUsuario());
    }

    private void crearModeloTablaProductos() {
        jtblProductos.setModel(modeloProductos);
        //Añadimos las columnas al modelo de la tabla
        modeloProductos.addColumn("Código");
        modeloProductos.addColumn("Nombre");
        modeloProductos.addColumn("Categoría");
        modeloProductos.addColumn("Unidad Medida");
        modeloProductos.addColumn("Cantidad");
    }

    private void limpiarCampos() {
        jtxtCodigo.setText("");
        jtxtNombre.setText("");
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("");
        jcbxCategoria.setModel(modelo);
        jtxtUnidadMedida.setText("");
        jtxtCantidad.setText("");
    }

    private void deshabilitarControles() {
        jtxtFactura.setEnabled(false);
        jcbxProveedor.setEnabled(false);
        jbtnNuevoProveedor.setEnabled(false);
        jtxtMonto.setEnabled(false);
        jtxtObservacion.setEnabled(false);
        jtxtCantidad.setEnabled(false);
        jbtnNuevoProducto.setEnabled(false);
        jbtnBuscarProducto.setEnabled(false);
        jbtnAplicar.setEnabled(false);
        jbtnDescartar.setEnabled(false);
    }

    private void añadirProductoTabla() {
        Object[] filaProducto = new Object[5];
        filaProducto[0] = jtxtCodigo.getText();
        filaProducto[1] = jtxtNombre.getText();
        filaProducto[2] = jcbxCategoria.getSelectedItem().toString();
        filaProducto[3] = jtxtUnidadMedida.getText();
        filaProducto[4] = Double.parseDouble(jtxtCantidad.getText());
        //Añadimos la fila al modelo
        modeloProductos.addRow(filaProducto);
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    private boolean validarCampos() {
        //NUMERO FACTURA - OBLIGATORIO
        if (jtxtFactura.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "El número de factura, no puede estar vacío!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            jtxtFactura.requestFocus();
            return false;
        } else if (jtxtFactura.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "El número de factura, no puede ser mayor a 30 carácteres!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //MONTO - OBLIGATORIO
        if (jtxtMonto.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "El monto, no puede estar vacío!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            jtxtMonto.requestFocus();
            return false;
        } else if (!HelpMethods.isDouble(jtxtMonto.getText())) {
            JOptionPane.showMessageDialog(this, "El monto debe ser un valor numérico!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //OBSERVACION
        if (jtxtObservacion.getText().length() > 500) {
            JOptionPane.showMessageDialog(this, "El campo observación, no puede ser mayor a 500 carácteres!", "Verifique",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void setConfirmarPermiso(boolean permiso) {
        this.confirmarPermiso = permiso;
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
        jlblTituloFactura = new javax.swing.JLabel();
        jtxtFactura = new javax.swing.JTextField();
        jlblTituloObservacion = new javax.swing.JLabel();
        jtxtObservacion = new javax.swing.JTextField();
        jlblTituloEncargado = new javax.swing.JLabel();
        jtxtEncargado = new javax.swing.JTextField();
        jlblTituloProveedor = new javax.swing.JLabel();
        jcbxProveedor = new javax.swing.JComboBox();
        jlblTituloMonto = new javax.swing.JLabel();
        jtxtMonto = new javax.swing.JTextField();
        jbtnNuevoProveedor = new javax.swing.JButton();
        jpnlDatosProducto = new javax.swing.JPanel();
        jbtnBuscarProducto = new javax.swing.JButton();
        jbtnNuevoProducto = new javax.swing.JButton();
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
        setTitle("Entrada de Productos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnlTituloVentana.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnlTituloVentana.setLayout(new java.awt.GridLayout(1, 0));

        jlblTituloVentana.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jlblTituloVentana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTituloVentana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEntrada32x32.png"))); // NOI18N
        jlblTituloVentana.setText("Entrada de Productos");
        jpnlTituloVentana.add(jlblTituloVentana);

        jpnPrincipal.add(jpnlTituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 750, 70));

        jpnDatosEntrada.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblTituloConsecutivo.setText("Consecutivo:");

        jtxtConsecutivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtConsecutivo.setToolTipText("Consecutivo del movimiento");
        jtxtConsecutivo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxtConsecutivo.setEnabled(false);

        jlblTituloFecha.setText("Fecha:");

        jtxtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtFecha.setToolTipText("Fecha del movimiento");
        jtxtFecha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtxtFecha.setEnabled(false);

        jlblTituloFactura.setText("Factura:");

        jtxtFactura.setToolTipText("Factura correspondiente");

        jlblTituloObservacion.setText("Observación:");

        jtxtObservacion.setToolTipText("Descripción de la entrada de producto");

        jlblTituloEncargado.setText("Encargado:");

        jtxtEncargado.setToolTipText("Encargado del ingreso");
        jtxtEncargado.setEnabled(false);

        jlblTituloProveedor.setText("Proveedor:");

        jcbxProveedor.setToolTipText("Proveedor del que se obtienen los productos");

        jlblTituloMonto.setText("Monto:");

        jtxtMonto.setToolTipText("Monto de la factura");

        jbtnNuevoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNuevo16x16.png"))); // NOI18N
        jbtnNuevoProveedor.setToolTipText("Crear nuevo proveedor");
        jbtnNuevoProveedor.setMaximumSize(new java.awt.Dimension(32, 32));
        jbtnNuevoProveedor.setMinimumSize(new java.awt.Dimension(32, 32));
        jbtnNuevoProveedor.setPreferredSize(new java.awt.Dimension(18, 18));
        jbtnNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnDatosEntradaLayout = new javax.swing.GroupLayout(jpnDatosEntrada);
        jpnDatosEntrada.setLayout(jpnDatosEntradaLayout);
        jpnDatosEntradaLayout.setHorizontalGroup(
            jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDatosEntradaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnDatosEntradaLayout.createSequentialGroup()
                        .addComponent(jlblTituloEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jtxtEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jpnDatosEntradaLayout.createSequentialGroup()
                            .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlblTituloConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlblTituloFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(15, 15, 15)
                            .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpnDatosEntradaLayout.createSequentialGroup()
                                    .addComponent(jtxtConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jlblTituloFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpnDatosEntradaLayout.createSequentialGroup()
                                    .addComponent(jtxtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jlblTituloProveedor)))
                            .addGap(18, 18, 18)
                            .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDatosEntradaLayout.createSequentialGroup()
                                    .addComponent(jcbxProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jbtnNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jlblTituloMonto)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jpnDatosEntradaLayout.createSequentialGroup()
                            .addComponent(jlblTituloObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)
                            .addComponent(jtxtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );
        jpnDatosEntradaLayout.setVerticalGroup(
            jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDatosEntradaLayout.createSequentialGroup()
                .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnDatosEntradaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtxtConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDatosEntradaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDatosEntradaLayout.createSequentialGroup()
                                .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblTituloConsecutivo)
                                    .addComponent(jlblTituloFecha))
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDatosEntradaLayout.createSequentialGroup()
                                .addComponent(jtxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))))
                .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblTituloMonto)
                            .addComponent(jtxtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jbtnNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblTituloFactura)
                        .addComponent(jtxtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlblTituloProveedor)
                        .addComponent(jcbxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblTituloObservacion)
                    .addComponent(jtxtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnDatosEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblTituloEncargado)
                    .addComponent(jtxtEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jpnPrincipal.add(jpnDatosEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 750, 170));

        jpnlDatosProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnBuscarProducto32x32.png"))); // NOI18N
        jbtnBuscarProducto.setToolTipText("Buscar un producto existente");
        jbtnBuscarProducto.setMaximumSize(new java.awt.Dimension(32, 32));
        jbtnBuscarProducto.setMinimumSize(new java.awt.Dimension(32, 32));
        jbtnBuscarProducto.setPreferredSize(new java.awt.Dimension(36, 36));
        jbtnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarProductoActionPerformed(evt);
            }
        });

        jbtnNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNuevo32x32.png"))); // NOI18N
        jbtnNuevoProducto.setToolTipText("Crear nuevo producto");
        jbtnNuevoProducto.setMaximumSize(new java.awt.Dimension(32, 32));
        jbtnNuevoProducto.setMinimumSize(new java.awt.Dimension(32, 32));
        jbtnNuevoProducto.setPreferredSize(new java.awt.Dimension(36, 36));
        jbtnNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoProductoActionPerformed(evt);
            }
        });

        jlblTituloCodigo.setText("Código:");
        jlblTituloCodigo.setPreferredSize(new java.awt.Dimension(47, 14));

        jtxtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtCodigo.setToolTipText("Código del producto seleccionado");
        jtxtCodigo.setEnabled(false);

        jlblTituloNombre.setText("Nombre:");
        jlblTituloNombre.setPreferredSize(new java.awt.Dimension(51, 14));

        jtxtNombre.setToolTipText("Nombre del producto seleccionado");
        jtxtNombre.setEnabled(false);

        jlblTituloUnidadMedida.setText("Unidad Medida:");
        jlblTituloUnidadMedida.setPreferredSize(new java.awt.Dimension(84, 14));

        jtxtUnidadMedida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtUnidadMedida.setToolTipText("Unidad de medida del producto seleccionado");
        jtxtUnidadMedida.setEnabled(false);

        jlblTituloCategoria.setText("Categoría:");
        jlblTituloCategoria.setPreferredSize(new java.awt.Dimension(61, 14));

        jcbxCategoria.setToolTipText("Categoría del producto seleccionado");
        jcbxCategoria.setEnabled(false);
        jcbxCategoria.setPreferredSize(new java.awt.Dimension(190, 20));

        jlblTituloCantidad.setText("Cantidad:");
        jlblTituloCantidad.setPreferredSize(new java.awt.Dimension(57, 14));

        jtxtCantidad.setToolTipText("Cantidad a ingresar");
        jtxtCantidad.setNextFocusableComponent(jbtnAplicar);
        jtxtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtCantidadKeyPressed(evt);
            }
        });

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
                                .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlblTituloUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlblTituloCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(jpnlDatosProductoLayout.createSequentialGroup()
                        .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlDatosProductoLayout.createSequentialGroup()
                                .addComponent(jbtnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jpnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTituloCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblTituloUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblTituloCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jpnPrincipal.add(jpnlDatosProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 750, 160));

        jlblDatosPorAplicar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlblDatosPorAplicar.setLayout(new java.awt.GridLayout(1, 0));

        jspnProductos.setToolTipText("Productos listos para ingresar");

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
        jtblProductos.setToolTipText("Productos listos para ingresar");
        jtblProductos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jtblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblProductosMouseClicked(evt);
            }
        });
        jspnProductos.setViewportView(jtblProductos);

        jlblDatosPorAplicar.add(jspnProductos);

        jpnPrincipal.add(jlblDatosPorAplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 750, 191));

        jbtnAplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAplicar44x44.png"))); // NOI18N
        jbtnAplicar.setToolTipText("Aplicar el movimiento");
        jbtnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAplicarActionPerformed(evt);
            }
        });
        jpnPrincipal.add(jbtnAplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 620, 48, 48));

        jbtnDescartar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnDescartar44x44.png"))); // NOI18N
        jbtnDescartar.setToolTipText("Descartar el movimiento");
        jbtnDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDescartarActionPerformed(evt);
            }
        });
        jpnPrincipal.add(jbtnDescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 620, 48, 48));

        getContentPane().add(jpnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jbtnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarProductoActionPerformed
        JdlgProductosBuscar ventanaBuscarProducto = new JdlgProductosBuscar(this, true, 0);
        ventanaBuscarProducto.setVisible(true);
        if (this.producto != null) {
            jtxtCodigo.setText("" + producto.getIdProducto());
            jtxtNombre.setText(producto.getNombre());
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            modelo.addElement(producto.getCategoria());
            jcbxCategoria.setModel(modelo);
            jtxtUnidadMedida.setText(producto.getUnidadMedida());
            jtxtCantidad.requestFocus();
        }
    }//GEN-LAST:event_jbtnBuscarProductoActionPerformed

    private void jbtnNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoProveedorActionPerformed
        JdlgProveedorNuevo ventanaNuevoProveedor = new JdlgProveedorNuevo(this, true);
        ventanaNuevoProveedor.setVisible(true);
        inicializarDatos();
    }//GEN-LAST:event_jbtnNuevoProveedorActionPerformed

    private void jtxtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCantidadKeyPressed
        boolean estaProducto = false;
        if (evt.getKeyCode() == 10) {
            //Validacion de Producto seleccionado
            if (!jtxtCodigo.getText().equals("")) {
                //Validacion - Cantidad de tipo Doble
                if (HelpMethods.isDouble(jtxtCantidad.getText())) {
                    //Validacion - Cantidad > 0
                    if (Double.parseDouble(jtxtCantidad.getText()) > 0) {
                        //Validacion - Producto no esta en el grid.
                        for (int x = 0; x < modeloProductos.getRowCount(); x++) {
                            if (jtxtCodigo.getText().equals(modeloProductos.getValueAt(x, 0).toString())) {
                                estaProducto = true;
                                limpiarCampos();
                                break;
                            }
                        }
                        if (!estaProducto) {
                            añadirProductoTabla();
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(this, "El producto ya se encuentra en la lista!",
                                    "Verifique", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "La cantidad no puede ser cero!",
                                "Verifique", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "La cantidad debe ser un numero!",
                            "Verifique", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun producto!",
                        "Verifique", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jtxtCantidadKeyPressed

    private void jbtnNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoProductoActionPerformed
        JdlgProductosNuevo ventanaNuevoProducto = new JdlgProductosNuevo(this, true);
        ventanaNuevoProducto.setVisible(true);
    }//GEN-LAST:event_jbtnNuevoProductoActionPerformed

    private void jbtnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAplicarActionPerformed
        if (validarCampos()) {
            JdlgConfirmarPermiso ventanaConfirmar = new JdlgConfirmarPermiso(this, true,
                    jtxtEncargado.getText());
            ventanaConfirmar.setVisible(true);

            if (confirmarPermiso) {
                //Asignamos los valores del movimiento
                Movimiento movimientoSalida = new Movimiento();
                movimientoSalida.setObservacion(jtxtObservacion.getText());
                movimientoSalida.setTipo("Entrada");
                //Obtener el proveedor
                String[] datosProveedor = jcbxProveedor.getSelectedItem().toString().split(" - ");
                movimientoSalida.setIdProveedor(Integer.parseInt(datosProveedor[0]));
                movimientoSalida.setNumeroFactura(jtxtFactura.getText());
                movimientoSalida.setMonto(Double.parseDouble(jtxtMonto.getText()));
                movimientoSalida.setNumeroCheque("");
                movimientoSalida.setUsuario(jtxtEncargado.getText());

                //Llamamos al metodo de aplicacion
                if (movimientoSalida.aplicarMovimientoEntrada(modeloProductos, jtxtFecha.getText())) {
                    jtxtConsecutivo.setText("" + BusquedasBaseDatos.buscarUltimoConsecutivoMovimiento());
                    BusquedasBaseDatos.cerrar();
                    deshabilitarControles();
                    JOptionPane.showMessageDialog(this, "Movimiento aplicado con éxito",
                            "Movimiento aplicado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error. \nNo se ha podido aplicar el movimiento.",
                            "Uppsss!", JOptionPane.ERROR_MESSAGE);
                }
            }
            confirmarPermiso = false;
        }
    }//GEN-LAST:event_jbtnAplicarActionPerformed

    private void jtblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblProductosMouseClicked
        if (evt.getClickCount() > 1) {
            int fila = jtblProductos.rowAtPoint(evt.getPoint());
            int columna = jtblProductos.columnAtPoint(evt.getPoint());
            if ((fila > -1) && (columna > -1)) {
                modeloProductos.removeRow(fila);
            }
        }
    }//GEN-LAST:event_jtblProductosMouseClicked
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
            java.util.logging.Logger.getLogger(JdlgMovimientosEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlgMovimientosEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlgMovimientosEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlgMovimientosEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JdlgMovimientosEntrada dialog = new JdlgMovimientosEntrada(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnNuevoProducto;
    private javax.swing.JButton jbtnNuevoProveedor;
    private javax.swing.JComboBox jcbxCategoria;
    private javax.swing.JComboBox jcbxProveedor;
    private javax.swing.JPanel jlblDatosPorAplicar;
    private javax.swing.JLabel jlblTituloCantidad;
    private javax.swing.JLabel jlblTituloCategoria;
    private javax.swing.JLabel jlblTituloCodigo;
    private javax.swing.JLabel jlblTituloConsecutivo;
    private javax.swing.JLabel jlblTituloEncargado;
    private javax.swing.JLabel jlblTituloFactura;
    private javax.swing.JLabel jlblTituloFecha;
    private javax.swing.JLabel jlblTituloMonto;
    private javax.swing.JLabel jlblTituloNombre;
    private javax.swing.JLabel jlblTituloObservacion;
    private javax.swing.JLabel jlblTituloProveedor;
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
    private javax.swing.JTextField jtxtFactura;
    private javax.swing.JTextField jtxtFecha;
    private javax.swing.JTextField jtxtMonto;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtObservacion;
    private javax.swing.JTextField jtxtUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
