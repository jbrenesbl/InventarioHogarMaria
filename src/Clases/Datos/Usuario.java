/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Datos;

import Clases.Auxiliares.ConexionBaseDatos;

/**
 *
 * @author JoBren8
 */
public class Usuario {

    //Atributos de Clase
    private String usuario;
    private String rol;

    public Usuario() {
        usuario = "";
        rol = "";
    }

    //Metodos Get y Set de la clase
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    //INSERTAR USUARIO
    public boolean insertarUsuario(char[] pass) {
        String password = new String(pass);

        ConexionBaseDatos conexion = new ConexionBaseDatos();
        if (conexion.abrirConexion()) {
            try {
                String sentenciaSQL = "INSERT INTO Usuarios ("
                        + "Usuario, "
                        + "Password, "
                        + "Rol) "
                        + "VALUES ('"
                        + usuario.replace("'", "''") + "', '"
                        + password.replace("'", "''") + "', '"
                        + rol.replace("'", "''") + "')";
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
