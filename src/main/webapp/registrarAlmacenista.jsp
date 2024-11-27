<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<h5>Registrar Almacenista</h5>
<p>Este es el apartado para registrar a los diferentes Almacenista en el sistema</p>
<form class="user" action="SvAlmacenista" method="POST" onsubmit="return validarFormulario()">
    <div class="form-group col">
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="cedula"
                   placeholder="Cedula" name="cedula">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre"
                   placeholder="Nombre" name="nombre">
        </div>
    
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user"
                   id="apellido" placeholder="Apellido" name="apellido">
        </div>
        
        <div class="col-sm-6 mb-3 ">
            <input type="email" class="form-control form-control-user"
                   id="correoElectronico" placeholder="CorreoElectronico" name="correoElectronica">
        </div>
        
         <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user"
                   id="celular" placeholder="Celular" name="celular">
        </div>
        
        
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Registra Almacenista
    </button>
    <hr>
    
</form>

<script>
    function validarFormulario() {
        // Obtener valores de los campos
        const cedula = document.getElementById('cedula').value.trim();
        const nombre = document.getElementById('nombre').value.trim();
        const apellido = document.getElementById('apellido').value.trim();
        const correoElectronico = document.getElementById('correoElectronico').value.trim();
        const celular = document.getElementById('celular').value.trim();
        
        // Verificar campos vacíos
        if (!cedula || !nombre || !apellido || !correoElectronico || !celular) {
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
