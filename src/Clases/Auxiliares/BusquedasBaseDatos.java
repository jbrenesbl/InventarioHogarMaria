/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Auxiliares;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JoBren8
 */
public class BusquedasBaseDatos {

    private static ConexionBaseDatos conexion = new ConexionBaseDatos();
    
    //BUSCAR USUARIO
    public static ResultSet buscarUsuario(String usuario, String password)
    {
        //Ejecutamos la consulta
        if (conexion.abrirConexion()) {
            ResultSet rs = conexion.obtenerDatos("SELECT Usuario, Rol FROM Usuarios "
                    + "WHERE Usuario = '" + usuario + "' AND Password = '" + password + "'");
            return rs;
        } else {
            conexion.cerrarConexion();
            return null;
        }
    }

    //BUSCAR CATEGORIAS
    public static ResultSet buscarCategorias() {
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            ResultSet rs = conexion.obtenerDatos("SELECT DISTINCT Categoria FROM Productos "
                    + "ORDER BY Categoria ASC");
            return rs;
        } else {
            conexion.cerrarConexion();
            return null;
        }
    }
    
    //BUSCAR PROVEEDORES
    public static ResultSet buscarProveedores() {
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            ResultSet rs = conexion.obtenerDatos("SELECT NombreProveedor FROM Proveedores "
                    + "WHERE Idproveedor > 1 "
                    + "ORDER BY NombreProveedor ASC");
            return rs;
        } else {
            conexion.cerrarConexion();
            return null;
        }
    }

    //BUSCAR UNIDAD MEDIDA
    public static ResultSet buscarUnidadesMedida() {
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            ResultSet rs = conexion.obtenerDatos("SELECT DISTINCT UnidadMedida FROM Productos "
                    + "ORDER BY UnidadMedida ASC");
            return rs;
        } else {
            conexion.cerrarConexion();
            return null;
        }
    }

    //BUSCAR PRODUCTO BASICO
    public static ResultSet buscarProducto(String nombre,
            String categoria, String unidadMedida) {
        StringBuilder sentenciaSQL = new StringBuilder();
        boolean primerCriterio = true;

        sentenciaSQL.append("SELECT idProducto, Nombre, Categoria, UnidadMedida, Cantidad, Estado "
                + "FROM Productos "
                + "WHERE ");

        //Validamos si nos dan el nombre        
        if (!nombre.equals("")) {
            sentenciaSQL.append("Nombre LIKE '%" + nombre.replace("'", "''") + "%'");
            primerCriterio = false;
        }

        //Validamos si nos dan la categoria
        if (!categoria.equals("")) {
            if (primerCriterio) {
                sentenciaSQL.append("Categoria LIKE '%" + categoria.replace("'", "''") + "%'");
                primerCriterio = false;
            } else {
                sentenciaSQL.append("AND Categoria LIKE '%" + categoria.replace("'", "''") + "%'");
            }
        }

        //Validamos si nos dan la unidad de medida
        if (!unidadMedida.equals("")) {
            if (primerCriterio) {
                sentenciaSQL.append("UnidadMedida LIKE '%" + unidadMedida.replace("'", "''") + "%'");
                primerCriterio = false;
            } else {
                sentenciaSQL.append("AND UnidadMedida LIKE '%" + unidadMedida.replace("'", "''") + "%'");
            }
        }

        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            ResultSet rs = conexion.obtenerDatos(sentenciaSQL.toString());
            return rs;
        } else {
            conexion.cerrarConexion();
            return null;
        }
    }

    //BUSCAR PRODUCTO BASICO
    public static ResultSet buscarProductoDetallado(int codigo) {
        String sentenciaSQL = "SELECT * FROM Productos WHERE idProducto = " + codigo;
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            ResultSet rs = conexion.obtenerDatos(sentenciaSQL.toString());
            return rs;
        } else {
            conexion.cerrarConexion();
            return null;
        }
    }

    //BUSCAR PROXIMO CONSECUTIVO MOVIMIENTO
    public static int buscarProximoConsecutivoMovimiento() {
        String sentenciaSQL = "SELECT MAX(idMovimiento) FROM Movimientos";
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            try {
                ResultSet rs = conexion.obtenerDatos(sentenciaSQL.toString());
                rs.next();
                /*
                 * Verificamos el valor maximo en la tabla de movimientos Si no hay,
                 * se devuelve 1 Si hay, se le suma 1
                 */
                if (rs.getObject(1) != null) {
                    return (Integer.parseInt(rs.getObject(1).toString()) + 1);
                } else {
                    return 1;
                }
            } catch (SQLException ex) {
                return 0;
            }
        } else {
            conexion.cerrarConexion();
            return 0;
        }
    }
    
    //BUSCAR ULTIMO CONSECUTIVO MOVIMIENTO
    public static int buscarUltimoConsecutivoMovimiento() {
        String sentenciaSQL = "SELECT MAX(idMovimiento) FROM Movimientos";
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            try {
                ResultSet rs = conexion.obtenerDatos(sentenciaSQL.toString());
                rs.next();
                /*
                 * Verificamos el valor maximo en la tabla de movimientos Si no hay,
                 * se devuelve 1 Si hay, se le suma 1
                 */
                if (rs.getObject(1) != null) {
                    return (Integer.parseInt(rs.getObject(1).toString()));
                } else {
                    return 1;
                }
            } catch (SQLException ex) {
                return 0;
            }
        } else {
            conexion.cerrarConexion();
            return 0;
        }
    }
    
    //BUSCAR CANTIDAD PRODUCTO
    public static double buscarCantidadProducto(int codigo)
    {
        String sentenciaSQL = "SELECT Cantidad FROM Productos WHERE idProducto = " + codigo;
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            try {
                ResultSet rs = conexion.obtenerDatos(sentenciaSQL.toString());
                rs.next();                
                if (rs.getObject(1) != null) {
                    return (Double.parseDouble(rs.getObject(1).toString()));
                } else {
                    return 0;
                }
            } catch (SQLException ex) {
                return 0;
            }
        } else {
            conexion.cerrarConexion();
            return 0;
        }
    }

    //CERRAR CONEXION BD
    public static void cerrar() {
        conexion.cerrarConexion();
    }
}
