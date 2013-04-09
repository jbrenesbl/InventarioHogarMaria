/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Datos;

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
    
}
