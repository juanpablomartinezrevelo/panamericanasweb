<%-- 
    Document   : verProveedor
    Created on : 17/11/2024, 12:15:39 a. m.
    Author     : 123456789
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>
<h2>Ver Proveedores</h2>

 <!-- Begin Page Content -->
 <div class="container-fluid">

     <!-- Page Heading -->
     <h2 class="h3 mb-2 text-gray-800">Tabla de Proveedores</h2>
     <p>A continuación podrá visualizar la lista completa de los Proveedores</p>

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
                             <th>Empresa</th>
                             <th>Direción</th>
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
                             <th>Empresa</th>
                             <th>Direción</th>
                             <th style="width: 210px">Acción</th>
                         </tr>
                     </tfoot>
                     
                     <%
                      List<Proveedor> listaProveedor = (List)request.getSession().getAttribute("listaProveedor");
                     %>
                     <tbody>
                        <% for(Proveedor proveedor:listaProveedor){%> 
                         <tr>
                             <td><%=proveedor.getId()%></td>
                             <td><%=proveedor.getNombre()%></td>
                             <td><%=proveedor.getApellido()%></td>
                             <td><%=proveedor.getCedula()%></td>
                             <td><%=proveedor.getCorreoElectronico()%></td>
                             <td><%=proveedor.getCelular()%></td>
                             <td><%=proveedor.getEmpresa()%></td>
                             <td><%=proveedor.getDireccion()%></td>
                             <td style="display:flex;width: 230px">
                                 <form name="elminiar" action="SvElimProveedor" method="POST"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px">
                                         <i class="fas fa-trash-alt"></i>Eliminar
                                     </button>
                                     <input type="hidden" name="id" value="<%=proveedor.getId()%>">
                                 </form>
                                 
                                 <form name="elminiar" action="SvEditProveedor" method="GET"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                         <i class="fas fa-pencil-alt"></i>Editar
                                     </button>
                                     <input type="hidden" name="id" value="<%=proveedor.getId()%>">
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

