<%-- 
    Document   : editarMaterial
    Created on : 17/11/2024, 6:12:54 a. m.
    Author     : 123456789
--%>

<%@page import="Logica.Material"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<h5>Edición de Material</h5>
<p>Este es el apartado para modificar un Material registrado en el sistema</p>

<%Material matter = (Material)request.getSession().getAttribute("matterEditar");%>
<form class="user" action="SvEditMaterial" method="POST" onsubmit="return validarFormulario()">
    <div class="form-group col">
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="Material"
                   name="material" placeholder="Material" value="<%=matter.getMaterial()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="contraseña" name="cantidadMaterial"
                   placeholder="cantidad de Material" value="<%=matter.getCantidadMaterial()%>">
        </div>
    

   
    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar Modificación
    </button>
    <hr>
    
</form>
<script>
    function validarFormulario() {
        // Obtener valores de los campos
        const material = document.getElementById('Material').value.trim();
        const cantidadMaterial = document.getElementById('CantidadMaterial').value.trim();
        
        
        // Verificar campos vacíos
        if (!material || !cantidadMaterial ) {
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
