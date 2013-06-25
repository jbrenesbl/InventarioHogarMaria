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
    public static ResultSet buscarUsuario(String usuario, String password) {
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
            ResultSet rs = conexion.obtenerDatos("SELECT idProveedor, NombreProveedor, Telefono FROM Proveedores "
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

    //BUSCAR PRODUCTO DETALLADO
    public static ResultSet buscarProductoDetallado(String nombre,
            String categoria, String unidadMedida, String estado) {
        StringBuilder sentenciaSQL = new StringBuilder();
        boolean primerCriterio = true;

        sentenciaSQL.append("SELECT * "
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

        //Validamos si nos dan el estado
        if (!estado.equals("*")) {
            if (primerCriterio) {
                sentenciaSQL.append("Estado = '" + estado + "'");
                primerCriterio = false;
            } else {
                sentenciaSQL.append("AND Estado = '" + estado + "'");
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

    //BUSCAR PRODUCTO DETALLADO POR CODIGO
    public static ResultSet buscarProductoDetalladoCodigo(int codigo) {
        String sentenciaSQL;
        //Codigo 0 = Todos los productos
        if (codigo == 0) {
            sentenciaSQL = "SELECT * FROM Productos";
        } else {
            sentenciaSQL = "SELECT * FROM Productos WHERE idProducto = " + codigo;
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

    //BUSCAR PROXIMO CONSECUTIVO MOVIMIENTO
    public static int buscarProximoConsecutivoMovimiento() {
        String sentenciaSQL = "SELECT MAX(idMovimiento) FROM Movimientos";
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            try {
                ResultSet rs = conexion.obtenerDatos(sentenciaSQL.toString());
                rs.next();
                /*
                 * Verificamos el valor maximo en la tabla de movimientos Si no
                 * hay, se devuelve 1 Si hay, se le suma 1
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

    //BUSCAR BAJO STOCK
    public static ResultSet buscarBajoStock(String nombre,
            String categoria, String unidadMedida) {
        StringBuilder sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT * "
                + "FROM Productos "
                + "WHERE Cantidad < CantidadMinima ");

        //Validamos si nos dan el nombre        
        if (!nombre.equals("")) {
            sentenciaSQL.append("AND Nombre LIKE '%" + nombre.replace("'", "''") + "%'");
        }

        //Validamos si nos dan la categoria
        if (!categoria.equals("")) {
            sentenciaSQL.append("AND Categoria LIKE '%" + categoria.replace("'", "''") + "%'");
        }

        //Validamos si nos dan la unidad de medida
        if (!unidadMedida.equals("")) {
            sentenciaSQL.append("AND UnidadMedida LIKE '%" + unidadMedida.replace("'", "''") + "%'");
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

    //BUSCAR ULTIMO CONSECUTIVO MOVIMIENTO
    public static int buscarUltimoConsecutivoMovimiento() {
        String sentenciaSQL = "SELECT MAX(idMovimiento) FROM Movimientos";
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            try {
                ResultSet rs = conexion.obtenerDatos(sentenciaSQL.toString());
                rs.next();
                /*
                 * Verificamos el valor maximo en la tabla de movimientos Si no
                 * hay, se devuelve 1 Si hay, se le suma 1
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
    public static double buscarCantidadProducto(int codigo) {
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

    //BUSCAR ESTADO PRODUCTO
    public static String buscarEstadoProducto(int codigo) {
        String sentenciaSQL = "SELECT Estado FROM Productos WHERE idProducto = " + codigo;
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            try {
                ResultSet rs = conexion.obtenerDatos(sentenciaSQL.toString());
                rs.next();
                if (rs.getObject(1) != null) {
                    return rs.getObject(1).toString();
                } else {
                    return null;
                }
            } catch (SQLException ex) {
                return null;
            }
        } else {
            conexion.cerrarConexion();
            return null;
        }
    }

    //BUSCAR MOVIMIENTOS SIN CHEQUE
    public static ResultSet buscarMovimientosSinCheque() {
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            ResultSet rs = conexion.obtenerDatos("SELECT DISTINCT movimientos.idMovimiento, "
                    + "movimientos.NumeroFactura, "
                    + "proveedores.NombreProveedor, "
                    + "movimientos.Monto "
                    + "FROM movimientos "
                    + "INNER JOIN proveedores "
                    + "ON movimientos.idProveedor = proveedores.idProveedor "
                    + "WHERE (movimientos.idProveedor <> 1) AND NumeroCheque = ''");
            return rs;
        } else {
            conexion.cerrarConexion();
            return null;
        }
    }

    //BUSCAR MOVIMIENTOS - REPORTE DETALLADO
    public static ResultSet buscarMovimientos(String tipoMovimiento, String numeroFactura, int idProveedor,
            String numeroCheque, String fechaInicio, String fechaFin, double montoInicio, double montoFin,
            String usuario) {
        String sentenciaSQL = "SELECT "
                + "DISTINCT m.idMovimiento AS Consecutivo, "
                + "m.Tipo AS TipoMovimiento, "
                + "m.NumeroFactura AS NumeroFactura, "
                + "pv.NombreProveedor AS NombreProveedor, "
                + "m.NumeroCheque AS NumeroCheque, "
                + "DATE_FORMAT (m.FechaMovimiento, '%d/%m/%Y') AS FechaMovimiento, "
                + "m.Monto AS Monto, "
                + "m.Usuario AS Usuario "
                + "FROM movimientos m "
                + "INNER JOIN proveedores pv "
                + "ON m.idProveedor = pv.idProveedor "
                + "WHERE ";

        //CONDICION TIPO MOVIMIENTO
        if (!tipoMovimiento.equals("")) {
            sentenciaSQL += "m.Tipo = '" + tipoMovimiento + "' AND ";
        }

        //CONDICION NUMERO FACTURA
        if (!numeroFactura.equals("")) {
            sentenciaSQL += "m.NumeroFactura = '" + numeroFactura + "' AND ";
        }

        //CONDICION PROVEEDOR
        if (idProveedor > 0) {
            sentenciaSQL += "m.idProveedor = " + idProveedor + " AND ";
        }

        //CONDICION NUMERO CHEQUE
        if (!numeroCheque.equals("")) {
            sentenciaSQL += "m.NumeroCheque = '" + numeroCheque + "' AND ";
        }
        
        //CONDICION RANGO FECHAS
        if (!fechaInicio.equals("")) {
            sentenciaSQL += "(m.FechaMovimiento >= '" + fechaInicio + "' AND "
                    + "m.FechaMovimiento <= '" + fechaFin + "') AND ";
        }
        
        //CONDICION RANGO MONTO
        if (montoFin > 0) {
            sentenciaSQL += "(m.Monto >= " + montoInicio + " AND "
                    + "m.Monto <= " + montoFin + ") AND ";
        }
        
        //CONDICION USUARIO
        if (!usuario.equals("")) {
            sentenciaSQL += "m.Usuario = '" + usuario + "' AND ";
        }
        
        //Quitamos el "AND " del final de la sentencia
        sentenciaSQL = sentenciaSQL.substring(0, sentenciaSQL.length() - 4);
        
        //Ejecutar la consulta
        if (conexion.abrirConexion()) {
            ResultSet rs = conexion.obtenerDatos(sentenciaSQL);
            return rs;
        } else {
            conexion.cerrarConexion();
            return null;
        }
    }

    //CERRAR CONEXION BD
    public static void cerrar() {
        conexion.cerrarConexion();
    }
}
