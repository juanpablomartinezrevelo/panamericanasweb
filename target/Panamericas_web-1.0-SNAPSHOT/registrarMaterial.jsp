<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<h5>Registrar Material</h5>
<p>Este es el apartado para registrar a los diferentes Materiales en el sistema</p>
<form class="user" action="SvMaterial" method="POST" onsubmit="return validarFormulario()">
    <div class="form-group col">
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="Material"
                   placeholder="Material" name="material">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="CantidadMaterial"
                   placeholder="cantidad de Material a registrar" name="cantidadMaterial">
        </div>
    
        
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Registra Material
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
