<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<h5>Registrar Ventas</h5>
<p>Este es el apartado para registrar a los diferentes Ventas del sistema</p>
<form class="user" action="SvVentas" method="POST" onsubmit="return validarFormulario()">
    <div class="form-group col">
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="producto"
                   placeholder="Producto" name="producto">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="precio"
                   placeholder="Precio $" name="precio">
        </div>
        
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="Material"
                   placeholder="Material"  name="material">
        </div>
    
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user"
                   id="descripcion" placeholder="Descripción" name="descripcion">
        </div>
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user"
                   id="cantidadVendida" placeholder="Cantidad Vendida" name="cantidadVendida">
        </div>
        
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user"
                   id="encargadoVenta" placeholder="Encargado de la Venta" name="encargadoVenta">
        </div>
        <div class="col-sm-6 mb-3 ">
            <input type="date" class="form-control form-control-user"
                   id="fechaVenta" placeholder="Fecha de la Venta" name="fechaVenta">
        </div>
        
        
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Registra Ventas
    </button>
    <hr>
    
</form>
<script>
    function validarFormulario() {
        // Obtener valores de los campos
        const producto = document.getElementById('producto').value.trim();
        const precio = document.getElementById('precio').value.trim();
        const Material = document.getElementById('Material').value.trim();
        const descripcion = document.getElementById('descripcion').value.trim();
        const cantidadVendida = document.getElementById('cantidadVendida').value.trim();
        const encargadoVenta = document.getElementById('encargadoVenta').value.trim();
        const fechaVenta = document.getElementById('fechaVenta').value.trim();
        // Verificar campos vacíos
        if (!producto || !precio||!Material||!descripcion||!cantidadVendida||!encargadoVenta||!fechaVenta) {
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