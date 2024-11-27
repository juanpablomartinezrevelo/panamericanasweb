<%-- 
    Document   : verVentas
    Created on : 18/11/2024, 2:08:56 p. m.
    Author     : 123456789
--%>

<%@page import="Logica.Ventas"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>
<h2>Ver Ventas</h2>

 <!-- Begin Page Content -->
 <div class="container-fluid">

     <!-- Page Heading -->
     <h2 class="h3 mb-2 text-gray-800">Tabla de Ventas</h2>
     <p>A continuación podrá visualizar la lista completa de las Ventas que han sido registrados</p>

     <!-- DataTales Example -->
     <div class="card shadow mb-4">
         
         <div class="card-body">
             <div class="table-responsive">
                 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                     <thead>
                         <tr>
                             <th>Id</th>
                             <th>Producto</th>
                             <th>Precio</th>
                             <th>Material</th>
                             <th>Descripcion</th>
                             <th>Cantidad del Producto</th>
                             <th>Encargado</th>
                             <th>Fecha</th>
                             <th style="width: 210px">Acción</th>
                         </tr>
                     </thead>
                     <tfoot>
                         <tr>
                             <th>Id</th>
                             <th>Producto</th>
                             <th>Precio</th>
                             <th>Material</th>
                             <th>Descripcion</th>
                             <th>Cantidad del Producto</th>
                             <th>Encargado</th>
                             <th>Fecha</th>
                             <th style="width: 210px">Acción</th>
                         </tr>
                     </tfoot>
                     
                     <%
                      List<Ventas> listaVentas = (List)request.getSession().getAttribute("listaVentas");
                     %>
                     <tbody>
                        <% for(Ventas venta:listaVentas){%> 
                         <tr>
                             <td><%=venta.getIdVenta()%></td>
                             <td><%=venta.getProducto()%></td>
                             <td><%=venta.getPrecio()%></td>
                             <td><%=venta.getMaterialProducto()%></td>
                             <td><%=venta.getDescripcion()%></td>
                             <td><%=venta.getCantidadVendida()%></td>
                             <td><%=venta.getEncargadoVenta()%></td>
                             <td><%=venta.getFechaVenta()%></td>
                             <td style="display:flex;width: 230px">
                                 <form name="elminiar" action="SvElimVenta" method="POST"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px">
                                         <i class="fas fa-trash-alt"></i>Eliminar
                                     </button>
                                     <input type="hidden" name="id" value="<%=venta.getIdVenta()%>">
                                 </form>
                                 
                                 <form name="elminiar" action="SvEditVenta" method="GET"><!-- esto es para mandar el codigo al servlet -->
                                     <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                         <i class="fas fa-pencil-alt"></i>Editar
                                     </button>
                                     <input type="hidden" name="id" value="<%=venta.getIdVenta()%>">
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

