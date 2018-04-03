<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Gestión de clientes </title>
</head>
<body>

<c:if test="${sessionScope.admin == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<a href="registrarCliente.jsp"> Registrar cliente nuevo </a> &nbsp;
<a href="ServletListadoProveedores"> Gestionar proveedores </a> &nbsp;
<a href="ServletLogOut"> Cerrar sesión </a> <br/>

<c:forEach items="${clientes}" var="cliente">
	<div style="margin: 8px">
		Nombre: ${cliente.nombre} <br/>
		Calle: ${cliente.calle} <br/>
		Número: ${cliente.numero} <br/>
		Código Postal: ${cliente.codigoPostal} <br/>
		Población: ${cliente.poblacion} <br/>
		Teléfono: ${cliente.telefono} <br/>
		Correo electrónico: ${cliente.email} <br/>
		Particular o empresa: ${cliente.particularEmpresa} <br/>
		<a href="ServletBorrarCliente?id=${cliente.id}"> BORRAR </a> &nbsp;
		<a href="ServletEditarCliente?id=${cliente.id}"> EDITAR </a>
	</div>
</c:forEach>


</body>
</html>