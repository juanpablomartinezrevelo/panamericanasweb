<%-- 
    Document   : verGerente
    Created on : 16/11/2024, 11:24:43 p. m.
    Author     : 123456789
--%>
<%@page import="Logica.Gerente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>
<h2>Ver Gerentes</h2>

 <!-- Begin Page Content -->
 <div class="container-fluid">

     <!-- Page Heading -->
     <h2 class="h3 mb-2 text-gray-800">Tabla de Gerentes</h2>
     <p>A continuación podrá visualizar la lista completa de los Gerentes</p>

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
                      List<Gerente> listaGerente = (List)request.getSession().getAttribute("listaGerente");
                     %>
                     <tbody>
                        <% for(Gerente gerente:listaGerente){%> 
                         <tr>
                             <td><%=gerente.getId()%></td>
                             <td><%=gerente.getNombre()%></td>
                             <td><%=gerente.getApellido()%></td>
                             <td><%=gerente.getCedula()%></td>
                             <td><%=gerente.getCorreoElectronico()%></td>
                             <td><%=gerente.getCelular()%></td>
                             <td style="display:flex;width: 230px">
                                 <form name="elminiar" action="SvElimGerente" method="POST"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px">
                                         <i class="fas fa-trash-alt"></i>Eliminar
                                     </button>
                                     <input type="hidden" name="id" value="<%=gerente.getId()%>">
                                 </form>
                                 
                                 <form name="elminiar" action="SvEditGerente" method="GET"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                         <i class="fas fa-pencil-alt"></i>Editar
                                     </button>
                                     <input type="hidden" name="id" value="<%=gerente.getId()%>">
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
