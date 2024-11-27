
package Servlets;

import Logica.Controladora;
import Logica.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "SvEditProveedor", urlPatterns = {"/SvEditProveedor"})
public class SvEditProveedor extends HttpServlet {

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
        Proveedor proveedor = control.traerProveedor(id);
        
        // Guardar el proveedor en la sesión
        HttpSession misession = request.getSession();
        misession.setAttribute("proveedorEditar", proveedor);
        
        // Continuar con la redirección normal
        response.sendRedirect("editarProveedor.jsp");
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
        String empresa=request.getParameter("empresa");
        String direccion=request.getParameter("direccion");
        Proveedor proveedor = (Proveedor)request.getSession().getAttribute("proveedorEditar");
        
        //le asignamos nuevos valores a los parametros
        proveedor.setCedula(cedula);
        proveedor.setNombre(nombre);
        proveedor.setApellido(apellido);
        proveedor.setCorreoElectronico(correoElectronico);
        proveedor.setCelular(celular);
        proveedor.setEmpresa(empresa);
        proveedor.setDireccion(direccion);
        
        //llama al metodo editarProveedor y le da su parametro proveedor
        control.editarProveedor(proveedor);
        
        // Continuar con la redirección normal
        response.sendRedirect("SvProveedor");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
