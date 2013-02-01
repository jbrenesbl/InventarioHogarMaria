package Clases.Datos;

import java.util.Calendar;

/**
 *
 * @author JoBren8
 */
public class Producto {
    //Atributos de clase

    private int idProducto;
    private String nombre;
    private String categoria;
    private String unidadMedida;
    private double cantidad;
    private Calendar ultimaEntrada;
    private Calendar ultimaSalida;

    public Producto() {
    }

    //Metodos Get y Set de la clase

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getUltimaEntrada() {
        return ultimaEntrada;
    }

    public void setUltimaEntrada(int year, int month, int date, int hourOfDay, int minute, int second) {
        this.ultimaEntrada = Calendar.getInstance();
        this.ultimaEntrada.set(year, month, date, hourOfDay, minute, second);
    }

    public Calendar getUltimaSalida() {
        return ultimaSalida;
    }

    public void setUltimaSalida(int year, int month, int date, int hourOfDay, int minute, int second) {
        this.ultimaSalida = Calendar.getInstance();
        this.ultimaSalida.set(year, month, date, hourOfDay, minute, second);
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
}
