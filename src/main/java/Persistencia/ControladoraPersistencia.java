
package Persistencia;





import Logica.Almacenista;
import Logica.Gerente;
import Logica.Material;
import Logica.Producto;
import Logica.Proveedor;
import Logica.Usuario;
import Logica.Ventas;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {                                                                                                 
   AlmacenistaJpaController almacenistaJPA = new AlmacenistaJpaController();
   GerenteJpaController gerenteJPA = new GerenteJpaController();
   InventarioProductoJpaController invProdJPA = new InventarioProductoJpaController();
   MaterialJpaController materialJPA = new MaterialJpaController();
   ProductoJpaController productoJPA = new ProductoJpaController();
   PersonaJpaController personaJPA = new PersonaJpaController();
   ProveedorJpaController proveedorJPA = new ProveedorJpaController();
   UsuarioJpaController usuarioJPA = new UsuarioJpaController();
   VentasJpaController ventasJPA = new VentasJpaController();
    

    

   
   
   
    public void crearUsuario(Usuario usu) {
        usuarioJPA.create(usu);
    }

    public List<Usuario> getUsuarios() {
        return usuarioJPA.findUsuarioEntities();
    }

    public void borrarUsuario(int id) {
       try {
           usuarioJPA.destroy(id);
       } catch (NonexistentEntityException ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Usuario traerUsuario(int id) {
        return usuarioJPA.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
       try {
           usuarioJPA.edit(usu);
       } catch (Exception ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public void crearProducto(Producto produc) {
        productoJPA.create(produc);
    }

    public List<Producto> getProducto() {
        return productoJPA.findProductoEntities();
    }

    public void crearMaterial(Material matter) {
        materialJPA.create(matter);
    }

    public void crearAlmacenista(Almacenista almacenista) {
        almacenistaJPA.create(almacenista);
    }

    public void crearGerente(Gerente gerente) {
        gerenteJPA.create(gerente);
    }

    public void crearProveedor(Proveedor proveedor) {
        proveedorJPA.create(proveedor);
    }

    public List<Material> getMateriales() {
        return materialJPA.findMaterialEntities();
    }

    public List<Almacenista> getAlmacenista() {
        return almacenistaJPA.findAlmacenistaEntities();
    }

    public List<Gerente> getGerente() {
        return gerenteJPA.findGerenteEntities();
    }

    public List<Proveedor> getProveedor() {
        return proveedorJPA.findProveedorEntities();
    }

    public void borrarMaterial(int id) {
       try {
           materialJPA.destroy(id);
       } catch (NonexistentEntityException ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public void borrarAlmacenista(int id) {
       try {
           almacenistaJPA.destroy(id);
       } catch (NonexistentEntityException ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public void borrarGerente(int id) {
       try {
           gerenteJPA.destroy(id);
       } catch (NonexistentEntityException ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public void borrarProveedor(int id) {
       try {
           proveedorJPA.destroy(id);
       } catch (NonexistentEntityException ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public void borrarProducto(int id) {
       try {
           productoJPA.destroy(id);
       } catch (NonexistentEntityException ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Material traerMaterial(int id) {
       return materialJPA.findMaterial(id);
    }

    public void editarMaterial(Material matter) {
       try {
           materialJPA.edit(matter);
       } catch (Exception ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Gerente traerGerente(int id) {
        return gerenteJPA.findGerente(id);
    }

    public void editarGerente(Gerente gerente) {
       try {
           gerenteJPA.edit(gerente);
       } catch (Exception ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Almacenista traerAlmacenista(int id) {
        return almacenistaJPA.findAlmacenista(id);
    }

    public void editarAlmacenista(Almacenista almacenista) {
       try {
           almacenistaJPA.edit(almacenista);
       } catch (Exception ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Proveedor traerProveedor(int id) {
        return proveedorJPA.findProveedor(id);
    }

    public void editarProveedor(Proveedor proveedor) {
       try {
           proveedorJPA.edit(proveedor);
       } catch (Exception ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Producto traerProducto(int id) {
        return productoJPA.findProducto(id);
    }

    public void editarproducto(Producto producto) {
       try {
           productoJPA.edit(producto);
       } catch (Exception ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    } 

    public void crearVenta(Ventas venta) {
        ventasJPA.create(venta);
    }

    public List<Ventas> getVentas() {
        return ventasJPA.findVentasEntities();
    }

    public void borrarVenta(int id) {
       try {
           ventasJPA.destroy(id);
       } catch (NonexistentEntityException ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Ventas traerVenta(int id) {
        return ventasJPA.findVentas(id);
    }

    public void editarVenta(Ventas venta) {
       try {
           ventasJPA.edit(venta);
       } catch (Exception ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
