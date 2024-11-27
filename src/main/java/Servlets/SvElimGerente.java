
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvElimGerente", urlPatterns = {"/SvElimGerente"})
public class SvElimGerente extends HttpServlet {
    
    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traemos los Parametros del formulrio
        int id = Integer.parseInt(request.getParameter("id"));
        
        //llama al metodo borrarGerente y le da su parametro id
        control.borrarGerente(id);
        
        // Continuar con la redirección normal
        response.sendRedirect("SvGerente");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
