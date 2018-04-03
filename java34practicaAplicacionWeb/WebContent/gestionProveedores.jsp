<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional/
		/EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Gestión de proveedores </title>
</head>
<body>

<c:if test="${sessionScope.admin == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<a href="ServletListadoClientes"> Gestionar clientes </a> &nbsp;
<a href="registrarProveedor.jsp"> Registrar proveedor nuevo </a> &nbsp;
<a href="ServletLogOut"> Cerrar sesión </a> <br/>

<c:forEach items="${proveedores}" var="proveedor">
	<div style="margin: 8px">
		Nombre de la empresa: ${proveedor.nombreEmpresa} <br/>
		Dirección: ${proveedor.direccion} <br/>
		Teléfono: ${proveedor.telefono} <br/>
		Correo electrónico: ${proveedor.correoElectronico} <br/>
		Página web: ${proveedor.paginaWeb} <br/>
		Nombre del representante: ${proveedor.nombreRepresentante} <br/>
		Teléfono del representante: ${proveedor.telefonoRepresentante} <br/>
		Ámbito de la actividad: ${proveedor.ambitoActividad} <br/>
		Certificado del Ministerio de Industria: ${proveedor.certificadoMinisterioIndustria} <br/>
		Estructura jurídica: ${proveedor.estructuraJuridica} <br/>
		<a href="ServletBorrarProveedor?id=${proveedor.id}"> BORRAR </a> &nbsp;
		<a href="ServletEditarProveedor?id=${proveedor.id}"> EDITAR </a>
	</div>
</c:forEach>

</body>
</html>