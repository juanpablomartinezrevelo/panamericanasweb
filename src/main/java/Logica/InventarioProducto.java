
package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class InventarioProducto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idProducto;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToOne
    private Gerente registroProductoGerente;
    @OneToOne
    private Almacenista registroproductoAlmacenista;
    @OneToMany(mappedBy="product")
    private List<Producto> listaproducto;

    public InventarioProducto() {
    }

    public InventarioProducto(int idProducto, Date fecha, Gerente registroProductoGerente, Almacenista registroproductoAlmacenista, List<Producto> listaproducto) {
        this.idProducto = idProducto;
        this.fecha = fecha;
        this.registroProductoGerente = registroProductoGerente;
        this.registroproductoAlmacenista = registroproductoAlmacenista;
        this.listaproducto = listaproducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Gerente getRegistroProductoGerente() {
        return registroProductoGerente;
    }

    public void setRegistroProductoGerente(Gerente registroProductoGerente) {
        this.registroProductoGerente = registroProductoGerente;
    }

    public Almacenista getRegistroproductoAlmacenista() {
        return registroproductoAlmacenista;
    }

    public void setRegistroproductoAlmacenista(Almacenista registroproductoAlmacenista) {
        this.registroproductoAlmacenista = registroproductoAlmacenista;
    }

    public List<Producto> getListaproducto() {
        return listaproducto;
    }

    public void setListaproducto(List<Producto> listaproducto) {
        this.listaproducto = listaproducto;
    }

    
    
    
    
    
    
}
