<%-- 
    Document   : paginaSinDatosMaterial
    Created on : 21/11/2024, 1:42:10 a. m.
    Author     : 123456789
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>
<h2>Ver Materiales</h2>

 <!-- Begin Page Content -->
 <div class="container-fluid">

     <!-- Page Heading -->
     <h2 class="h3 mb-2 text-gray-800">Tabla de Materiales</h2>
     <p>A continuación podrá visualizar la lista completa de los Materiales que han sido registrados</p>

     <!-- DataTales Example -->
     <div class="card shadow mb-4">
         
         <div class="card-body">
             <div class="table-responsive">
                 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                     <thead>
                         <tr>
                             <th>Id Material</th>
                             <th>Material</th>
                             <th>Cantidad de Material</th>
                             <th style="width: 210px">Acción</th>
                         </tr>
                     </thead>
                     <tfoot>
                         <tr>
                             <th>Id Material</th>
                             <th>Material</th>
                             <th>Cantidad de Material</th>
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