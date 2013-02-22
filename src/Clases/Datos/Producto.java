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
    private double cantidadMinima;
    private Calendar ultimaEntrada;
    private Calendar ultimaSalida;
    private String estado;

    public Producto() {
    }

    //Metodos Get y Set de la clase
    
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(double cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
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

    public void setUltimaEntrada(Calendar ultimaEntrada) {
        this.ultimaEntrada = ultimaEntrada;
    }

    public Calendar getUltimaSalida() {
        return ultimaSalida;
    }

    public void setUltimaSalida(Calendar ultimaSalida) {
        this.ultimaSalida = ultimaSalida;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
