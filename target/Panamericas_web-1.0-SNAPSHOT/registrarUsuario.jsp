
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<h5>Registrar Usuario</h5>
<p>Este es el apartado para registrar a los diferentes usuarios del sistema</p>
<form class="user" action="SvUsuario" method="POST" onsubmit="return validarFormulario()">
    <div class="form-group col">
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="nombreUsu"
                   name="nombreUsu" placeholder="Nombre Usuario">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contraseña" name="contrasenia"
                   placeholder="Contraseña">
        </div>
    
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" name="rol"
                   id="rol" placeholder="Rol">
   
    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Registra Usuario
    </button>
    <hr>
    
</form>
<script>
    function validarFormulario() {
        // Obtener valores de los campos
        const nombreUsu = document.getElementById('nombreUsu').value.trim();
        const contraseña = document.getElementById('contraseña').value.trim();
        const rol = document.getElementById('rol').value.trim();
        
        
        // Verificar campos vacíos
        if (!nombreUsu || !contraseña||!rol) {
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