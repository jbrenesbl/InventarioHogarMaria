/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Auxiliares;

import java.sql.ResultSet;

/**
 *
 * @author JoBren8
 */
public class BusquedasBaseDatos 
{
    private static ConexionBaseDatos conexion = new ConexionBaseDatos();
    
    //BUSCAR CATEGORIA
    public static ResultSet buscarCategorias()
    {
        //Ejecutar la consulta
        if (conexion.abrirConexion())
        {
            ResultSet rs =conexion.obtenerDatos("SELECT DISTINCT Categoria FROM Productos "
                    + "ORDER BY Categoria ASC");
            return rs; 
        }
        else
        {
            conexion.cerrarConexion();
            return null;
        }
    }
    
    //BUSCAR UNIDAD MEDIDA
    public static ResultSet buscarUnidadesMedida()
    {
        //Ejecutar la consulta
        if (conexion.abrirConexion())
        {
            ResultSet rs =conexion.obtenerDatos("SELECT DISTINCT UnidadMedida FROM Productos "
                    + "ORDER BY UnidadMedida ASC");
            return rs; 
        }
        else
        {
            conexion.cerrarConexion();
            return null;
        }
    }
    
    //BUSCAR PRODUCTO BASICO
    public static ResultSet buscarProducto(String nombre, 
            String categoria, String unidadMedida)
    {
        StringBuilder sentenciaSQL = new StringBuilder();
        boolean primerCriterio = true;
        
        sentenciaSQL.append("SELECT idProducto, Nombre, Categoria, UnidadMedida, Cantidad, Estado "
                + "FROM Productos "
                + "WHERE ");
        
        //Validamos si nos dan el nombre        
        if (!nombre.equals(""))
        {
            sentenciaSQL.append("Nombre LIKE '%" + nombre.replace("'", "''") + "%'");
            primerCriterio = false;
        }
        
        //Validamos si nos dan la categoria
        if (!categoria.equals(""))
        {
            if (primerCriterio)
            {
                sentenciaSQL.append("Categoria LIKE '%" + categoria.replace("'", "''") + "%'");
                primerCriterio = false;
            }
            else
            {
                sentenciaSQL.append("AND Categoria LIKE '%" + categoria.replace("'", "''") + "%'");
            }
        }
        
        //Validamos si nos dan la unidad de medida
        if (!unidadMedida.equals(""))
        {
            if (primerCriterio)
            {
                sentenciaSQL.append("UnidadMedida LIKE '%" + unidadMedida.replace("'", "''") + "%'");
                primerCriterio = false;
            }
            else
            {
                sentenciaSQL.append("AND UnidadMedida LIKE '%" + unidadMedida.replace("'", "''") + "%'");
            }
        }
        
        //Ejecutar la consulta
        if (conexion.abrirConexion())
        {
            ResultSet rs =conexion.obtenerDatos(sentenciaSQL.toString());
            return rs; 
        }
        else
        {
            conexion.cerrarConexion();
            return null;
        }
    }
    
    //BUSCAR PRODUCTO BASICO
    public static ResultSet buscarProductoDetallado(int codigo)
    {
        String sentenciaSQL = "SELECT * FROM Productos WHERE idProducto = " + codigo;
        //Ejecutar la consulta
        if (conexion.abrirConexion())
        {
            ResultSet rs =conexion.obtenerDatos(sentenciaSQL.toString());
            return rs; 
        }
        else
        {
            conexion.cerrarConexion();
            return null;
        }
    }
    
    public static void cerrar()
    {
        conexion.cerrarConexion();
    }
}
