
package Servlets;

import Logica.Almacenista;
import Logica.Controladora;
import Logica.Gerente;
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


@WebServlet(name = "SvGerente", urlPatterns = {"/SvGerente"})
public class SvGerente extends HttpServlet {

    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Gerente> listaGerente = new ArrayList<Gerente>();
        
        listaGerente = control.getGerente();
        
        
        if (listaGerente.isEmpty()) {
        // Redirigir a una página específica si la lista está vacía
        response.sendRedirect("paginaSinDatosGerente.jsp");
        } else {
        // Guardar la lista en la sesión
        HttpSession misession = request.getSession();
        misession.setAttribute("listaGerente", listaGerente);

        // Continuar con la redirección normal
        response.sendRedirect("verGerente.jsp");
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traemos los Parametros del formulrio
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String correoElectronico=request.getParameter("correoElectronica");
        String celular=request.getParameter("celular");
        
        //llama al metodo crearGerente y le da sus atributos
        control.crearGerente(cedula,nombre,apellido,correoElectronico,celular);
        
        // Continuar con la redirección normal
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
