package Clases.Datos;

import Clases.Auxiliares.ConexionBaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    //Llenar Datos del Producto en base a un ResultSet
    public void llenarDatos(ResultSet rs) {
        try {
            rs.next();
            setIdProducto(Integer.parseInt(rs.getObject(1).toString()));
            setNombre(rs.getObject(2).toString());
            setCategoria(rs.getObject(3).toString());
            setUnidadMedida(rs.getObject(4).toString());
            setCantidad(Double.parseDouble(rs.getObject(5).toString()));
            setCantidadMinima(Double.parseDouble(rs.getObject(6).toString()));
            Calendar fechaFormateada = Calendar.getInstance();
            if (rs.getObject(7) != null) {
                //Formato de la Fecha Ultima Entrada            
                fechaFormateada.set(Integer.parseInt(rs.getObject(7).toString().substring(0, 4)),
                        Integer.parseInt(rs.getObject(7).toString().substring(5, 7)) - 1,
                        Integer.parseInt(rs.getObject(7).toString().substring(8, 10)));
                setUltimaEntrada(fechaFormateada);
            } else {
                setUltimaEntrada(null);
            }
            if (rs.getObject(8) != null) {
                //Formato de la Fecha Ultima Salida
                fechaFormateada.set(Integer.parseInt(rs.getObject(8).toString().substring(0, 4)),
                        Integer.parseInt(rs.getObject(8).toString().substring(5, 7)) - 1,
                        Integer.parseInt(rs.getObject(8).toString().substring(8, 10)));
                setUltimaSalida(fechaFormateada);
            } else
            {
                setUltimaSalida(null);
            }
            setEstado(rs.getObject(9).toString());

        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String sentenciaActualizarExistencia(int codigo, Double cantidad, String tipo, String fecha) {
        if (tipo.equals("Entrada")) {
            return "UPDATE Productos SET Cantidad = " + cantidad + ", "
                    + "UltimaEntrada = '" + fecha + "' WHERE idProducto = " + codigo;
        } else {
            return "UPDATE Productos SET Cantidad = " + cantidad + ", "
                    + "UltimaSalida = '" + fecha + "' WHERE idProducto = " + codigo;
        }
    }

    public boolean insertarProducto() {
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        if (conexion.abrirConexion()) {
            try {
                String sentenciaSQL = "INSERT INTO productos ("
                        + "Nombre, "
                        + "Categoria, "
                        + "UnidadMedida, "
                        + "Cantidad, "
                        + "CantidadMinima, "
                        + "Estado) "
                        + "VALUES ('"
                        + nombre.replace("'", "''") + "', '"
                        + categoria.replace("'", "''") + "', '"
                        + unidadMedida.replace("'", "''") + "', "
                        + "0, "
                        + cantidadMinima + ", '"
                        + "Activo')";
                if (conexion.executeUpdate(sentenciaSQL)) {
                    conexion.cerrarConexion();
                    return true;
                } else {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        } else {
            return false;
        }
    }
}
