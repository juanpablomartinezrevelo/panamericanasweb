package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
    
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
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        
        //definimos un boolean para nuestra validacion
        boolean validacion = (false);
        
        //llamamons al metodo comprobarIngreso
        validacion = control.ComprobarIngreso(usuario,contrasenia);
        
        //usamos la variable validacion para validar nuestro condicional if
        if(validacion == true){
            //en caso de ser verdadera se crea una sesion y se redirige hacia el index
            HttpSession misession = request.getSession(true);
            misession.setAttribute("usuario", usuario);
            response.sendRedirect("index.jsp");
        }
        else{
            //en caso contrario nos enviara a la pagina de loginError 
            response.sendRedirect("loginError.jsp");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
