
package Servlets;

import Logica.Controladora;
import Logica.Producto;
import Logica.Ventas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditVenta", urlPatterns = {"/SvEditVenta"})
public class SvEditVenta extends HttpServlet {

    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traemos los Parametros del formulrio
        int id = Integer.parseInt(request.getParameter("id"));
        
        //llama al metodo traerVenta y le da su parametro id
        Ventas venta = control.traerVenta(id);
        
        //llama al metodo traerProducto y le da su parametro id
        HttpSession misession = request.getSession();
        misession.setAttribute("ventaEditar", venta);
        
        // Continuar con la redirección normal
        response.sendRedirect("editarVenta.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traemos los Parametros del formulrio
        String producto=request.getParameter("producto");
        String precio = request.getParameter("precio");
        String material= request.getParameter("material");
        String descripcion= request.getParameter("descripcion");
        int cantidadVendida = Integer.parseInt(request.getParameter("cantidadVendida"));
        String encargadoVenta= request.getParameter("encargadoVenta");
        String fechaVentas= request.getParameter("fechaVenta");
        
        Ventas venta = (Ventas) request.getSession().getAttribute("ventaEditar");
        
        //le asignamos nuevos valores a los parametros
        venta.setProducto(producto);
        venta.setPrecio(precio);
        venta.setMaterialProducto(material);
        venta.setDescripcion(descripcion);
        venta.setCantidadVendida(cantidadVendida);
        venta.setEncargadoVenta(encargadoVenta);
        venta.setFechaVenta(fechaVentas);
        
        //llama al metodo editarVenta y le da su parametro venta
        control.editarVenta(venta);
        
        // Continuar con la redirección normal
        response.sendRedirect("SvVentas");

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
