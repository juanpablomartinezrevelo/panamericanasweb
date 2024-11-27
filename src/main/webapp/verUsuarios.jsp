<%-- 
    Document   : verUsuario
    Created on : 13/11/2024, 10:35:08 p. m.
    Author     : 123456789
--%>

<%@page import="Logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>
<h1>Ver Usuarios</h1>

 <!-- Begin Page Content -->
 <div class="container-fluid">

     <!-- Page Heading -->
     <h2 class="h3 mb-2 text-gray-800">Tabla de Usuarios</h2>
     <p>A continuación podrá visualizar la lista completa de ususarios</p>

     <!-- DataTales Example -->
     <div class="card shadow mb-4">
         
         <div class="card-body">
             <div class="table-responsive">
                 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                     <thead>
                         <tr>
                             <th>Id</th>
                             <th>Nombre de Usuario</th>
                             <th>Rol</th>
                             <th style="width: 210px">Acción</th>
                         </tr>
                     </thead>
                     <tfoot>
                         <tr>
                             <th>Id</th>
                             <th>Nombre de Usuario</th>
                             <th>Rol</th>
                             <th style="width: 210px">Acción</th>
                         </tr>
                     </tfoot>
                     
                     <%
                      List<Usuario> listaUsuarios = (List)request.getSession().getAttribute("listaUsuarios");
                     %>
                     <tbody>
                        <% for(Usuario usu:listaUsuarios){%> 
                         <tr>
                             <td><%=usu.getIdUsuario()%></td>
                             <td><%=usu.getNombreUsuario()%></td>
                             <td><%=usu.getRol()%></td>
                             
                             <td style="display:flex;width: 230px">
                                 <form name="elminiar" action="SvElimUsuarios" method="POST"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px">
                                         <i class="fas fa-trash-alt"></i>Eliminar
                                     </button>
                                     <input type="hidden" name="id" value="<%=usu.getIdUsuario()%>">
                                 </form>
                                 
                                 <form name="elminiar" action="SvEditUsuarios" method="GET"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                         <i class="fas fa-pencil-alt"></i>Editar
                                     </button>
                                     <input type="hidden" name="id" value="<%=usu.getIdUsuario()%>">
                                 </form> 
                             </td>
                         </tr>
                        <%}%> 
                     </tbody>
                 </table>
             </div>
         </div>
     </div>

 </div>
 <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="components/bodyFinal.jsp" %>