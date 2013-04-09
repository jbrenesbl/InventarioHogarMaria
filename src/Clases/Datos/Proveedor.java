package Clases.Datos;

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
}
