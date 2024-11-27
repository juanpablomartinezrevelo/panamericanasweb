
package Logica;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;



@Entity
public class Almacenista extends Persona implements Serializable{

    //private int idAlmacenista;
    @OneToOne
    private Usuario unUsuario;
    @OneToMany(mappedBy="salesAlmacenista")
    private List<Ventas>listaventas;

    public Almacenista() {
    }

    public Almacenista(Usuario unUsuario, List<Ventas> listaventas, int id, int cedula, String nombre, String apellido, String correoElectronico, String celular) {
        super(id, cedula, nombre, apellido, correoElectronico, celular);
        this.unUsuario = unUsuario;
        this.listaventas = listaventas;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public List<Ventas> getListaventas() {
        return listaventas;
    }

    public void setListaventas(List<Ventas> listaventas) {
        this.listaventas = listaventas;
    }

    
    
    

    
    
    
}
