package Servlets;

import Logica.Almacenista;
import Logica.Controladora;
import Logica.Gerente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditAlmacenista", urlPatterns = {"/SvEditAlmacenista"})
public class SvEditAlmacenista extends HttpServlet {
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
        //llama al metodo traerAlmacenista y le da su parametro id
        Almacenista almacenista = control.traerAlmacenista(id);
        
        // Guardar el almacenista en la sesión
        HttpSession misession = request.getSession();
        misession.setAttribute("almacenistaEditar", almacenista);
        
        // Continuar con la redirección normal
        response.sendRedirect("editarAlmacenista.jsp");
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
        Almacenista almacenista = (Almacenista)request.getSession().getAttribute("almacenistaEditar");
        almacenista.setCedula(cedula);
        almacenista.setNombre(nombre);
        almacenista.setApellido(apellido);
        almacenista.setCorreoElectronico(correoElectronico);
        almacenista.setCelular(celular);
        
        //llama al metodo editarAlmacenista y le da su parametro almacenista 
        control.editarAlmacenista(almacenista);
        
        // Continuar con la redirección normal
        response.sendRedirect("SvAlmacenista");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
