package Clases.Datos;

import Clases.Auxiliares.ConexionBaseDatos;

/**
 *
 * @author JoBren8
 */
public class Proveedor {

    //Variables del clase
    private int idProveedor;
    private String nombreProveedor;
    private String telefono;

    public Proveedor() {
    }

    //Metodos Get y Set de la clase
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean insertarProveedor() {
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        if (conexion.abrirConexion()) {
            try {
                String sentenciaSQL = "INSERT INTO Proveedores ("
                        + "NombreProveedor, "
                        + "Telefono) "
                        + "VALUES ('"
                        + nombreProveedor.replace("'", "''") + "', '"
                        + telefono.replace("'", "''") + "')";
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
