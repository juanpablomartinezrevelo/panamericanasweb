
package Servlets;

import Logica.Controladora;
import Logica.Ventas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvVentas", urlPatterns = {"/SvVentas"})
public class SvVentas extends HttpServlet {

    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Ventas> listaVentas = new ArrayList<Ventas>();
        
        listaVentas = control.getVentas();
        
        if (listaVentas.isEmpty()) {
        // Redirigir a una página específica si la lista está vacía
        response.sendRedirect("paginaSinDatosVentas.jsp");
        } else {
        // Guardar la lista en la sesión
        HttpSession misession = request.getSession();
        misession.setAttribute("listaVentas", listaVentas);

        // Continuar con la redirección normal
        response.sendRedirect("verVentas.jsp");
        }
        
        
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
        
        //llama al metodo crearUsuario y le da sus atributos
        control.crearVenta(producto,precio,material,descripcion,cantidadVendida,encargadoVenta,fechaVentas);
        
        // Continuar con la redirección normal
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    
}
