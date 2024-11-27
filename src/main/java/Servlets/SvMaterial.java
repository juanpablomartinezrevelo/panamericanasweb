package Servlets;

import Logica.Controladora;
import Logica.Material;
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


@WebServlet(name = "SvMaterial", urlPatterns = {"/SvMaterial"})
public class SvMaterial extends HttpServlet {

    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Material> listaMateriales = new ArrayList<Material>();
        
        listaMateriales = control.getMateriales();
        
        if (listaMateriales.isEmpty()) {
        // Redirigir a una página específica si la lista está vacía
        response.sendRedirect("paginaSinDatosMaterial.jsp");
        } else {
        // Guardar la lista en la sesión
        HttpSession misession = request.getSession();
        misession.setAttribute("listaMateriales", listaMateriales);

        // Continuar con la redirección normal
        response.sendRedirect("verMaterial.jsp");
        }
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traemos los Parametros del formulrio
        String material=request.getParameter("material");
        int cantidadMaterial = Integer.parseInt(request.getParameter("cantidadMaterial"));
        
        //llama al metodo crearMaterial y le da sus atributos
        control.crearMaterial(material,cantidadMaterial);
        
        // Continuar con la redirección normal
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
