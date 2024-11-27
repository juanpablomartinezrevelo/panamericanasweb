package Logica;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Ventas implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idVenta;
    private String producto;
    private String precio;
    private String materialProducto;
    private String descripcion;
    private int cantidadRegistrada;
    private int cantidadVendida;
    private String encargadoVenta;
    private String fechaVenta;
    @ManyToOne
    @JoinColumn(name="gerenteVentas")
    private Gerente salesGerente;
    @ManyToOne
    @JoinColumn(name="almacenistaVentas")
    private Almacenista salesAlmacenista;
    
    public Ventas() {
    }

    public Ventas(int idVenta, String producto, String precio, String materialProducto, String descripcion, int cantidadRegistrada, int cantidadVendida, String encargadoVenta, String fechaVenta, Gerente salesGerente, Almacenista salesAlmacenista) {
        this.idVenta = idVenta;
        this.producto = producto;
        this.precio = precio;
        this.materialProducto = materialProducto;
        this.descripcion = descripcion;
        this.cantidadRegistrada = cantidadRegistrada;
        this.cantidadVendida = cantidadVendida;
        this.encargadoVenta = encargadoVenta;
        this.fechaVenta = fechaVenta;
        this.salesGerente = salesGerente;
        this.salesAlmacenista = salesAlmacenista;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
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

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public String getEncargadoVenta() {
        return encargadoVenta;
    }

    public void setEncargadoVenta(String encargadoVenta) {
        this.encargadoVenta = encargadoVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Gerente getSalesGerente() {
        return salesGerente;
    }

    public void setSalesGerente(Gerente salesGerente) {
        this.salesGerente = salesGerente;
    }

    public Almacenista getSalesAlmacenista() {
        return salesAlmacenista;
    }

    public void setSalesAlmacenista(Almacenista salesAlmacenista) {
        this.salesAlmacenista = salesAlmacenista;
    }

    

}


