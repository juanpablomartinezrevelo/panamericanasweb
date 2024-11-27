<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<h5>Registrar Productos</h5>
<p>Este es el apartado para registrar a los diferentes podructos en el sistema</p>
<form class="user" action="SvProducto" method="POST" onsubmit="return validarFormulario()">
    <div class="form-group col">
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="nombreProduc" name="nombreProduc"
                   placeholder="Nombre del producto">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="materialProducto" name="materialProducto"
                   placeholder="Material del producto">
        </div>
    
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user"
                   id="descripcion" name="descripcion" placeholder="Descripción">
        </div>
        
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user"
                   id="cantidadRegistrada" name="cantidadRegistrada" placeholder="Cantidad de productos a registrar">
        </div>
        
        
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Registra Producto
    </button>
    <hr>
    
</form>
<script>
    function validarFormulario() {
        // Obtener valores de los campos
        const nombreProduc = document.getElementById('nombreProduc').value.trim();
        const materialProducto = document.getElementById('materialProducto').value.trim();
        const descripcion = document.getElementById('descripcion').value.trim();
        const cantidadRegistrada = document.getElementById('cantidadRegistrada').value.trim();
        
        // Verificar campos vacíos
        if (!nombreProduc || !materialProducto|| !descripcion|| !cantidadRegistrada ) {
            alert('Por favor, complete todos los campos.');
            return false; // Evita el envío del formulario
        }
        // Validar formato del correo electrónico
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(correoElectronico)) {
            alert('Por favor, ingrese un correo electrónico válido.');
            return false; 
        }
        // Validar que el número de celular tenga solo dígitos
        if (!/^\d+$/.test(celular)) {
            alert('Por favor, ingrese un número de celular válido.');
            return false;
        }
        // Si todo está correcto, permitir envío
        return true;
    }
</script>
<%@include file="components/bodyFinal.jsp" %>