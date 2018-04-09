<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional/
		/EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Edición del cliente </title>
</head>
<body>

<c:if test="${sessionScope.admin == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>


<a href="ServletListadoClientes"> Volver al listado de clientes </a> <br/>

Introduce los datos del cliente: <br/>

<div style="color: red"> ${mensajeErrorNombre} </div>
<div style="color: red"> ${mensajeErrorCalle} </div>
<div style="color: red"> ${mensajeErrorNumero} </div>
<div style="color: red"> ${mensajeErrorCodigoPostal} </div>
<div style="color: red"> ${mensajeErrorPoblacion} </div>
<div style="color: red"> ${mensajeErrorTelefono} </div>
<div style="color: red"> ${mensajeErrorEmail} </div>
<div style="color: red"> ${mensajeErrorParticularEmpresa} </div>

<form action="ServletGuardarCambiosCliente" method="post" 
		onsubmit="validarFormularioRegistroCliente()">

	Nombre: <input type="text" name="campoNombre" value="${clienteAEditar.nombre}"/> <br/>
	Calle: <input type="text" name="campoCalle" value="${clienteAEditar.calle}"/> <br/>
	Número: <input type="text" name="campoNumero" value="${clienteAEditar.numero}"/> <br/>
	Código Postal: <input type="text" name="campoCodigoPostal" 
			value="${clienteAEditar.codigoPostal}"/> <br/>
	Población: <input type="text" name="campoPoblacion" 
			value="${clienteAEditar.poblacion}"/> <br/>
	Teléfono: <input type="text" name="campoTelefono" 
			value="${clienteAEditar.telefono}"/> <br/>
	Correo electrónico: <input type="text" name="campoEmail" 
			value="${clienteAEditar.email}"/> <br/>
	Particular o empresa: <input type="text" name="campoParticularEmpresa" 
			value="${clienteAEditar.particularEmpresa}"/> <br/>
	<input type="hidden" name="campoId" value="${clienteAEditar.id}"/> <br/>
	<input type="submit" value="GUARDAR CAMBIOS"/>

</form>

<script type="text/javascript" src="js/validacionRegistrarCliente.js"></script>

</body>
</html>