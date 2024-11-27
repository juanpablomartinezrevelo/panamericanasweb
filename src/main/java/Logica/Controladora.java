
package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;


public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    //CRUD del Usuario
    public void crearUsuario( String nombreUsuario, String contraseña,String rol){
    
        Usuario usu = new Usuario();
        usu.setNombreUsuario(nombreUsuario);
        usu.setContraseña(contraseña);
        usu.setRol(rol);
        controlPersis.crearUsuario(usu);
    }
    
    public List<Usuario> getUsuarios() {
       return controlPersis.getUsuarios();
    }

    public void borrarUsuario(int id) {
        controlPersis.borrarUsuario(id);
    }

    public Usuario traerUsuario(int id) {
        return controlPersis.traerUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }

    
    //CRUD del producto
    /* El metodo crearProducto asigna los datos del formulario a los atributos del objeto
    producto, para así poder crear el un objeto producto y enviarlo a la base de datos como un
    registro*/
    public void crearProducto(String nombreProduc, String materialProducto, String descripcion, int cantidadRegistrada) {
        Producto produc = new Producto();
        produc.setNombre(nombreProduc);
        produc.setMaterialProducto(materialProducto);
        produc.setDescripcion(descripcion);
        produc.setCantidadRegistrada(cantidadRegistrada);
        controlPersis.crearProducto(produc);
        
    }
    /*El metodo getProducto, este metodo trae un listado de los registros de la tabla productos*/
    public List<Producto> getProducto() {
        return controlPersis.getProducto();
    }
    /*El metodo borrarProducto, toma como parametro el id de un producto, busca dicho id y borra 
    todo el registro de este producto*/
    public void borrarProducto(int id) {
        controlPersis.borrarProducto(id);
    }
    /*El metodo traerProducto, toma como parametro el id de un producto, busca dicho id y traer el 
    registro al que pertecene dicho id con los valores de sus columnas*/
    public Producto traerProducto(int id) {
        return controlPersis.traerProducto(id);
    }
    /*El metodo editarProducto, toma el objeto producto y le sobreescribe nuevos valores encima de los
    valores anteriores*/
    public void editarProducto(Producto producto) {
        controlPersis.editarproducto(producto);
    }
    
    //CRUD del Material
    /* El metodo crearMaterial asigna los datos del formulario a los atributos del objeto
    Material, para así poder crear el un objeto Material y enviarlo a la base de datos como un
    registro*/
    public void crearMaterial(String material, int cantidadMaterial) {
        Material matter = new Material();
        matter.setMaterial(material);
        matter.setCantidadMaterial(cantidadMaterial);
        controlPersis.crearMaterial(matter);
        
    }
    /*El metodo getMateriales, este metodo trae un listado de los registros de la tabla Materiales*/
    public List<Material> getMateriales() {
        return controlPersis.getMateriales();
    }
    /*El metodo borrarMaterial, toma como parametro el id de un Material, busca dicho id y borra 
    todo el registro de este Material*/
    public void borrarMaterial(int id) {
        controlPersis.borrarMaterial(id);
    }
    /*El metodo traerMaterial, toma como parametro el id de un Material, busca dicho id y traer el 
    registro al que pertecene dicho id con los valores de sus columnas*/
    public Material traerMaterial(int id) {
        return controlPersis.traerMaterial(id);
    }
    /*El metodo editarMaterial, toma el objeto Material y le sobreescribe nuevos valores encima de los
    valores anteriores*/
    public void editarMaterial(Material matter) {
        controlPersis.editarMaterial(matter);
    }
    
    //CRUD del Almacenista
    /* El metodo crearAlmacenista asigna los datos del formulario a los atributos del objeto
    Almacenista, para así poder crear el un objeto Almacenista y enviarlo a la base de datos como un
    registro*/
    public void crearAlmacenista(int cedula, String nombre, String apellido, String correoElectronico, String celular) {
        Almacenista almacenista= new Almacenista();
        almacenista.setCedula(cedula);
        almacenista.setNombre(nombre);
        almacenista.setApellido(apellido);
        almacenista.setCorreoElectronico(correoElectronico);
        almacenista.setCelular(celular);
        controlPersis.crearAlmacenista(almacenista);
    }
    /*El metodo getAlmacenista, este metodo trae un listado de los registros de la tabla Almacenista*/
    public List<Almacenista> getAlmacenista() {
        return controlPersis.getAlmacenista();
    }
    
    /*El metodo borrarAlmacenista, toma como parametro el id de un Almacenista, busca dicho id y borra 
    todo el registro de este Almacenista*/
    public void borrarAlmacenista(int id) {
        controlPersis.borrarAlmacenista(id);
    }
    /*El metodo traerAlmacenista, toma como parametro el id de un Almacenista, busca dicho id y traer el 
    registro al que pertecene dicho id con los valores de sus columnas*/
    public Almacenista traerAlmacenista(int id) {
        return controlPersis.traerAlmacenista(id);
    }
    /*El metodo editarAlmacenista, toma el objeto Almacenista y le sobreescribe nuevos valores encima de los
    valores anteriores*/
    public void editarAlmacenista(Almacenista almacenista) {
     controlPersis.editarAlmacenista(almacenista);   
    }
    
    //CRUD del gerente
    /* El metodo crearGerente asigna los datos del formulario a los atributos del objeto
    Gerente, para así poder crear el un objeto Gerente y enviarlo a la base de datos como un
    registro*/
    public void crearGerente(int cedula, String nombre, String apellido, String correoElectronico, String celular) {
        Gerente gerente = new Gerente();
        gerente.setCedula(cedula);
        gerente.setNombre(nombre);
        gerente.setApellido(apellido);
        gerente.setCorreoElectronico(correoElectronico);
        gerente.setCelular(celular);
        controlPersis.crearGerente(gerente);
    }
    /*El metodo getGerente, este metodo trae un listado de los registros de la tabla Gerente*/
    public List<Gerente> getGerente() {
        return controlPersis.getGerente();
    }
    /*El metodo borrarGerente, toma como parametro el id de un Gerente, busca dicho id y borra 
    todo el registro de este Gerente*/
    public void borrarGerente(int id) {
        controlPersis.borrarGerente(id);
    }
    /*El metodo traerGerente, toma como parametro el id de un Gerente, busca dicho id y traer el 
    registro al que pertecene dicho id con los valores de sus columnas*/
    public Gerente traerGerente(int id) {
        return controlPersis.traerGerente(id);
    }
    /*El metodo editarGerente, toma el objeto Gerente y le sobreescribe nuevos valores encima de los
    valores anteriores*/
    public void editarGerente(Gerente gerente) {
     controlPersis.editarGerente(gerente);   
    }    
    //CRUD del Proveedor
    /* El metodo crearProveedor asigna los datos del formulario a los atributos del objeto
    Proveedor, para así poder crear el un objeto Proveedor y enviarlo a la base de datos como un
    registro*/
    public void crearProveedor(int cedula, String nombre, String apellido, String correoElectronico, String celular, String empresa, String direccion) {
        Proveedor proveedor = new Proveedor();
        proveedor.setCedula(cedula);
        proveedor.setNombre(nombre);
        proveedor.setApellido(apellido);
        proveedor.setCorreoElectronico(correoElectronico);
        proveedor.setCelular(celular);
        proveedor.setEmpresa(empresa);
        proveedor.setDireccion(direccion);
        controlPersis.crearProveedor(proveedor);
    }
    /*El metodo getProveedor, este metodo trae un listado de los registros de la tabla Proveedor*/
    public List<Proveedor> getProveedor() {
        return controlPersis.getProveedor();
    }
    /*El metodo borrarProveedor, toma como parametro el id de un Proveedor, busca dicho id y borra 
    todo el registro de este Proveedor*/
    public void borrarProveedor(int id) {
        controlPersis.borrarProveedor(id);
    }
    /*El metodo traerProveedor, toma como parametro el id de un Proveedor, busca dicho id y traer el 
    registro al que pertecene dicho id con los valores de sus columnas*/
    public Proveedor traerProveedor(int id) {
        return controlPersis.traerProveedor(id);
    }
    /*El metodo editarProveedor, toma el objeto Proveedor y le sobreescribe nuevos valores encima de los
    valores anteriores*/
    public void editarProveedor(Proveedor proveedor) {
        controlPersis.editarProveedor(proveedor);
    }
    //metodo para comprobar el inicio de sesión 
    public boolean ComprobarIngreso(String usuario, String contrasenia) {
        boolean ingreso = false;
        
        List<Usuario> listausuarios = new ArrayList<Usuario>();
        listausuarios = controlPersis.getUsuarios();
        
        for(Usuario usu : listausuarios){
            if(usu.getNombreUsuario().equals(usuario)){
               if(usu.getContraseña().equals(contrasenia)){
                   ingreso=true;
               } 
               else{
                   ingreso=false;
               }
            }
                    
        }
        return ingreso;
    }   
    
    //CRUD de las ventas
    /* El metodo crearVenta asigna los datos del formulario a los atributos del objeto
    Ventas, para así poder crear el un objeto Ventas y enviarlo a la base de datos como un
    registro*/
    public void crearVenta(String producto, String precio, String material,String descripcion, int cantidadVendida, String encargadoVenta, String fechaVentas) {
        Ventas venta = new Ventas();
        venta.setProducto(producto);
        venta.setPrecio(precio);
        venta.setMaterialProducto(material);
        venta.setDescripcion(descripcion);
        venta.setCantidadVendida(cantidadVendida);
        venta.setEncargadoVenta(encargadoVenta);
        venta.setFechaVenta(fechaVentas);
        controlPersis.crearVenta(venta);
    }
    
    /*El metodo getVentas, este metodo trae un listado de los registros de la tabla Ventas*/
    public List<Ventas> getVentas() {
        return controlPersis.getVentas();
    }
    /*El metodo borrarVenta, toma como parametro el id de un Venta, busca dicho id y borra 
    todo el registro de este Venta*/
    public void borrarVenta(int id) {
        controlPersis.borrarVenta(id);
    }
    /*El metodo traerVenta, toma como parametro el id de un Venta, busca dicho id y traer el 
    registro al que pertecene dicho id con los valores de sus columnas*/
    public Ventas traerVenta(int id) {
        return controlPersis.traerVenta(id);
    }
    /*El metodo editarVenta, toma el objeto Ventas y le sobreescribe nuevos valores encima de los
    valores anteriores*/
    public void editarVenta(Ventas venta) {
        controlPersis.editarVenta(venta);
    }
    
}
