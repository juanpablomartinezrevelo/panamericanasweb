
package Logica;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    private int idProducto;
    private String nombre;
    private String materialProducto;
    private String descripcion;
    private int cantidadRegistrada;
    @ManyToOne
    @JoinColumn(name="idInventarioProducto")
    private InventarioProducto product;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, String materialProducto, String descripcion, int cantidadRegistrada, InventarioProducto product) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.materialProducto = materialProducto;
        this.descripcion = descripcion;
        this.cantidadRegistrada = cantidadRegistrada;
        this.product = product;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterialProducto() {
        return materialProducto;
    }

    public void setMaterialProducto(String materialProducto) {
        this.materialProducto = materialProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadRegistrada() {
        return cantidadRegistrada;
    }

    public void setCantidadRegistrada(int cantidadRegistrada) {
        this.cantidadRegistrada = cantidadRegistrada;
    }

    public InventarioProducto getProduct() {
        return product;
    }

    public void setProduct(InventarioProducto product) {
        this.product = product;
    }
   
    
    
}
