
package Servlets;

import Logica.Controladora;
import Logica.Gerente;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditGerente", urlPatterns = {"/SvEditGerente"})
public class SvEditGerente extends HttpServlet {
    //llamamos a la controladora
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traemos los Parametros del formulrio
        int id = Integer.parseInt(request.getParameter("id"));
        //llama al metodo traerGerente y le da su parametro id
        Gerente gerente = control.traerGerente(id);
        // Guardar el gerente en la sesión
        HttpSession misession = request.getSession();
        misession.setAttribute("gerenteEditar", gerente);
        
        
        // Continuar con la redirección normal
        response.sendRedirect("editarGerente.jsp");
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
        
        //le asignamos nuevos valores a los parametros
        Gerente gerente = (Gerente)request.getSession().getAttribute("gerenteEditar");
        gerente.setCedula(cedula);
        gerente.setNombre(nombre);
        gerente.setApellido(apellido);
        gerente.setCorreoElectronico(correoElectronico);
        gerente.setCelular(celular);
        
        //llama al metodo editarGerente y le da su parametro gerente
        control.editarGerente(gerente);
        
        // Continuar con la redirección normal
        response.sendRedirect("SvGerente");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
