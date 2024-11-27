
package Servlets;

import Logica.Controladora;
import Logica.Gerente;
import Logica.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditProducto", urlPatterns = {"/SvEditProducto"})
public class SvEditProducto extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traemos los Parametros del formulrio
        int id = Integer.parseInt(request.getParameter("id"));
        
        //llama al metodo traerProducto y le da su parametro id
        Producto producto = control.traerProducto(id);
        
        // Guardar el producto en la sesión
        HttpSession misession = request.getSession();
        misession.setAttribute("productoEditar", producto);
        
        // Continuar con la redirección normal
        response.sendRedirect("editarProducto.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traemos los Parametros del formulrio
        String nombreProduc=request.getParameter("nombreProduc");
        String materialProducto = request.getParameter("materialProducto");
        String descripcion= request.getParameter("descripcion");
        int cantidadRegistrada = Integer.parseInt(request.getParameter("cantidadRegistrada"));
        Producto producto = (Producto) request.getSession().getAttribute("productoEditar");
        
        
        //le asignamos nuevos valores a los parametros
        producto.setNombre(nombreProduc);
        producto.setMaterialProducto(materialProducto);
        producto.setDescripcion(descripcion);
        producto.setCantidadRegistrada(cantidadRegistrada);
        
        //llama al metodo editarMaterial y le da su parametro Material
        control.editarProducto(producto);
        
        // Continuar con la redirección normal
        response.sendRedirect("SvProducto");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
