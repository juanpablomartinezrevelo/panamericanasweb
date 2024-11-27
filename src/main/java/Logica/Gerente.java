
package Logica;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;



@Entity
public class Gerente extends Persona implements Serializable{
    //private int idGerente;
    @OneToOne
    private Usuario unUsuario;
    @OneToMany(mappedBy="salesGerente")
    private List<Ventas>listaventasGerente;
    
    
    public Gerente() {
    }

    public Gerente(Usuario unUsuario, List<Ventas> listaventasGerente, int id, int cedula, String nombre, String apellido, String correoElectronico, String celular) {
        super(id, cedula, nombre, apellido, correoElectronico, celular);
        this.unUsuario = unUsuario;
        this.listaventasGerente = listaventasGerente;
    }


    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public List<Ventas> getListaventasGerente() {
        return listaventasGerente;
    }

    public void setListaventasGerente(List<Ventas> listaventasGerente) {
        this.listaventasGerente = listaventasGerente;
    }

    

    
    
    
 
    
}
