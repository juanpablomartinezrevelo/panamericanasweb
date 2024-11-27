
package Logica;

import jakarta.persistence.Entity;

@Entity
public class Proveedor extends Persona {
    //private int idProveedor;
    private String empresa;
    private String direccion;
    
    public Proveedor() {
    }

    public Proveedor(String empresa, String direccion, int id, int cedula, String nombre, String apellido, String correoElectronico, String celular) {
        super(id, cedula, nombre, apellido, correoElectronico, celular);
        this.empresa = empresa;
        this.direccion = direccion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
    
}
