<%-- 
    Document   : paginaSinDatos
    Created on : 21/11/2024, 1:09:11 a. m.
    Author     : 123456789
--%>

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
                     
                     
                    
                 </table>
             </div>
         </div>
     </div>

 </div>
 <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="components/bodyFinal.jsp" %>
