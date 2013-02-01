package Clases.Auxiliares;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

/**
 *
 * @author JoBren8
 */
public class ConexionBaseDatos {

    Connection conexion;
    String connectionSource = "";
    String connectionUser = "";
    String connectionPassword = "";

    public ConexionBaseDatos() {
        inicializarConexion();
    }

    private void inicializarConexion() {
        //Abrimos un InputStream para leer el archivo
        FileInputStream file = null;
        /*
         * Intentamos abrir el fichero properties para leer de el
         */
        try {
            file = new FileInputStream("c:\\hmcp.properties");
        } catch (Exception ex) {
        }

        /*
         * Instanciamos el objeto Properties
         */
        Properties propers = new Properties();
        try {
            propers.load(file);
        } catch (Exception ex) {
        }

        //Asignamos los datos al Source de Conexion
        connectionSource = "jdbc:mysql://" + propers.getProperty("dataBaseServer") + ":"
                + propers.getProperty("dataBasePort") + "/"
                + propers.getProperty("dataBaseCatalog");
        connectionUser = propers.getProperty("dataBaseUser");
        connectionPassword = propers.getProperty("dataBasePassword");
    }

    public boolean abrirConexion() {
        //Intentamos abrir la conexion
        try {
            conexion = (Connection) DriverManager.getConnection(connectionSource, connectionUser,
                    connectionPassword);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean executeUpdate(String sentenciaSQL) {
        try {
            //Creamos el Statement con la conexion
            Statement s = (Statement) conexion.createStatement();
            //Ejecutamos la sentencia SQL
            s.executeUpdate(sentenciaSQL);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public ResultSet obtenerDatos(String sentenciaSQL) {
        try {
            //Creamos el Statement con la conexion
            Statement s = (Statement) conexion.createStatement();
            //Ejecutamos la sentencia SQL
            ResultSet resultado = s.executeQuery(sentenciaSQL);
            return resultado;
        } catch (Exception ex) {
            return null;
        }
    }

    public void cerrarConexion() {
        //Intentamos abrir la conexion
        try {
            conexion.close();
        } catch (Exception ex) {
        }
    }
}
