package Clases.Datos;

import Clases.Auxiliares.BusquedasBaseDatos;
import Clases.Auxiliares.ConexionBaseDatos;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoBren8
 */
public class Movimiento {
    //Variables de clase

    private int idMovimiento;
    private String tipo;
    private String observacion;
    private int idProveedor;
    private String numeroFactura;
    private Double monto;
    private String numeroCheque;
    private Calendar fechaMovimiento;
    private String usuario;

    public Movimiento() {
    }

    //Metodos Get y Set de la clase
    public Calendar getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(int year, int month, int date) {
        this.fechaMovimiento = Calendar.getInstance();
        this.fechaMovimiento.set(year, month, date);
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean aplicarMovimientoSalida(DefaultTableModel datosMovimiento, String fecha) {
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        String sentenciaSQL;
        //Separamos la fecha para darle formato yyy-mm-dd
        String[] fechaActualizacion = fecha.split("/");
        String fechaFormateada = fechaActualizacion[2] + "-"
                + fechaActualizacion[1] + "-"
                + fechaActualizacion[0];

        //Buscamos el numero de consecutivo a utilizar
        int consecutivo = BusquedasBaseDatos.buscarProximoConsecutivoMovimiento();
        BusquedasBaseDatos.cerrar();

        //Iniciamos con la actualizacion de los datos
        if (conexion.abrirConexion()) {
            //Iniciar la transacción
            if (conexion.executeUpdate("BEGIN")) {
                //Recorremos los datos en el modelo
                for (int x = 0; x < datosMovimiento.getRowCount(); x++) {
                    //Obtener la cantidad actual del producto en la fila "x"
                    double cantidadActual = BusquedasBaseDatos.buscarCantidadProducto(
                            Integer.parseInt(datosMovimiento.getValueAt(x, 0).toString()));
                    BusquedasBaseDatos.cerrar();
                    //Restamos cantidad actual - cantidad a extraer para actualizar la tabla Productos
                    cantidadActual -= Double.parseDouble(datosMovimiento.getValueAt(x, 4).toString());
                    //Obtenemos la sentencia SQL de actualizacion de la cantidad
                    sentenciaSQL = Producto.sentenciaActualizarExistencia(
                            Integer.parseInt(datosMovimiento.getValueAt(x, 0).toString()),
                            cantidadActual, tipo, fechaFormateada);
                    //Ejecutamos la actualizacion del producto
                    if (!conexion.executeUpdate(sentenciaSQL)) {
                        conexion.executeUpdate("ROLLBACK");
                        conexion.cerrarConexion();
                        return false;
                    }
                    //Creamos la sentencia del movimiento
                    sentenciaSQL = "INSERT INTO hm_produccion.movimientos("
                            + "idMovimiento, "
                            + "Tipo, "
                            + "idProducto, "
                            + "Cantidad, "
                            + "Observacion, "
                            + "idProveedor, "
                            + "NumeroFactura, "
                            + "Monto, "
                            + "NumeroCheque, "
                            + "FechaMovimiento, "
                            + "Usuario) VALUES ("
                            + consecutivo + ", '"
                            + tipo + "', "
                            + datosMovimiento.getValueAt(x, 0).toString() + ", "
                            + datosMovimiento.getValueAt(x, 4).toString() + ", '"
                            + this.observacion.replace("'", "''") + "', "
                            + this.idProveedor + ", '"
                            + this.numeroFactura.replace("'", "''") + "', "
                            + this.monto + ", '"
                            + this.numeroCheque.replace("'", "''") + "', '"
                            + fechaFormateada + "', '"
                            + this.usuario + "')";
                    //Ejecutamos la actualizacion del movimiento
                    if (!conexion.executeUpdate(sentenciaSQL)) {
                        conexion.executeUpdate("ROLLBACK");
                        conexion.cerrarConexion();
                        return false;
                    }
                }
                conexion.executeUpdate("COMMIT");
                conexion.cerrarConexion();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }        
    }
}
