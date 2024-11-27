<%-- 
    Document   : verProducto
    Created on : 17/11/2024, 1:20:11 a. m.
    Author     : 123456789
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>
<h2>Ver Producto</h2>

 <!-- Begin Page Content -->
 <div class="container-fluid">

     <!-- Page Heading -->
     <h2 class="h3 mb-2 text-gray-800">Tabla de Productos</h2>
     <p>A continuación podrá visualizar la lista completa de los Productos que han sido registrados</p>

     <!-- DataTales Example -->
     <div class="card shadow mb-4">
         
         <div class="card-body">
             <div class="table-responsive">
                 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                     <thead>
                         <tr>
                             <th>Id Producto</th>
                             <th>Nombre</th>
                             <th>Material del Producto</th>
                             <th>Descripcion</th>
                             <th>Cantidad del Producto</th>
                             <th style="width: 210px">Acción</th>
                         </tr>
                     </thead>
                     <tfoot>
                         <tr>
                             <th>Id Producto</th>
                             <th>Nombre</th>
                             <th>Material del Producto</th>
                             <th>Descripcion</th>
                             <th>Cantidad del Producto</th>
                             <th style="width: 210px">Acción</th>
                         </tr>
                     </tfoot>
                     
                     <%
                      List<Producto> listaProducto = (List)request.getSession().getAttribute("listaProducto");
                     %>
                     <tbody>
                        <% for(Producto producto:listaProducto){%> 
                         <tr>
                             <td><%=producto.getIdProducto()%></td>
                             <td><%=producto.getNombre()%></td>
                             <td><%=producto.getMaterialProducto()%></td>
                             <td><%=producto.getDescripcion()%></td>
                             <td><%=producto.getCantidadRegistrada()%></td>
                             <td style="display:flex;width: 230px">
                                 <form name="elminiar" action="SvElimProducto" method="POST"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px">
                                         <i class="fas fa-trash-alt"></i>Eliminar
                                     </button>
                                     <input type="hidden" name="id" value="<%=producto.getIdProducto()%>">
                                 </form>
                                 
                                 <form name="elminiar" action="SvEditProducto" method="GET"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                         <i class="fas fa-pencil-alt"></i>Editar
                                     </button>
                                     <input type="hidden" name="id" value="<%=producto.getIdProducto()%>">
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
