package Clases.Datos;

import java.util.Calendar;

/**
 *
 * @author JoBren8
 */
public class Movimiento {
    //Variables de clase
    private int idMovimiento;
    private String tipo;
    private int idProducto;
    private double cantidad;
    private String observacion;
    private String numeroFactura;
    private String solicitante;
    private Calendar fechaMovimiento;
    private int idUsuario;

    public Movimiento() {
    }
    
    //Metodos Get y Set de la clase

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Calendar getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(int year, int month, int date, int hourOfDay, int minute, int second) {
        this.fechaMovimiento = Calendar.getInstance();
        this.fechaMovimiento.set(year, month, date, hourOfDay, minute, second);
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
