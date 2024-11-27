<%-- 
    Document   : verAlmacenista
    Created on : 16/11/2024, 10:40:43 p. m.
    Author     : 123456789
--%>

<%@page import="Logica.Almacenista"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>
<h2>Ver Almacenistas</h2>

 <!-- Begin Page Content -->
 <div class="container-fluid">

     <!-- Page Heading -->
     <h2 class="h3 mb-2 text-gray-800">Tabla de Almacenista</h2>
     <p>A continuación podrá visualizar la lista completa de los Almacenistas</p>

     <!-- DataTales Example -->
     <div class="card shadow mb-4">
         
         <div class="card-body">
             <div class="table-responsive">
                 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                     <thead>
                         <tr>
                             <th>Id</th>
                             <th>Nombre</th>
                             <th>Apellido</th>
                             <th>Cedula</th>
                             <th>correoElectronico</th>
                             <th>Celular</th>
                             <th style="width: 210px">Acción</th>
                         </tr>
                     </thead>
                     <tfoot>
                         <tr>
                             <th>Id</th>
                             <th>Nombre</th>
                             <th>Apellido</th>
                             <th>Cedula</th>
                             <th>correoElectronico</th>
                             <th>Celular</th>
                             <th style="width: 210px">Acción</th>
                         </tr>
                     </tfoot>
                     
                     <%
                      List<Almacenista> listaAlmacenista = (List)request.getSession().getAttribute("listaAlmacenista");
                     %>
                     
                        <% for(Almacenista almacenista:listaAlmacenista){%> 
                         <tr>
                             <td><%=almacenista.getId()%></td>
                             <td><%=almacenista.getNombre()%></td>
                             <td><%=almacenista.getApellido()%></td>
                             <td><%=almacenista.getCedula()%></td>
                             <td><%=almacenista.getCorreoElectronico()%></td>
                             <td><%=almacenista.getCelular()%></td>
                             <td style="display:flex;width: 230px">
                                 <form name="elminiar" action="SvElimAlmacenista" method="POST"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px">
                                         <i class="fas fa-trash-alt"></i>Eliminar
                                     </button>
                                     <input type="hidden" name="id" value="<%=almacenista.getId()%>">
                                 </form>
                                 
                                 <form name="elminiar" action="SvEditAlmacenista" method="GET"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                         <i class="fas fa-pencil-alt"></i>Editar
                                     </button>
                                     <input type="hidden" name="id" value="<%=almacenista.getId()%>">
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
