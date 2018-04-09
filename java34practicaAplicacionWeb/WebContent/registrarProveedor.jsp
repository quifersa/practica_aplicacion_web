<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional/
	/EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Registrar Proveedor </title>
</head>
<body>

<c:if test="${sessionScope.admin == null}">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<a href="ServletListadoProveedores"> Volver al listado de proveedores </a> <br/>

Introduce los datos del proveedor: <br/>


<div style="color: red"> ${mensajeErrorNombreEmpresa} </div>
<div style="color: red"> ${mensajeErrorDireccion} </div>
<div style="color: red"> ${mensajeErrorTelefono} </div>
<div style="color: red"> ${mensajeErrorEmail} </div>
<div style="color: red"> ${mensajeErrorWeb} </div>
<div style="color: red"> ${mensajeErrorNombreRepresentante} </div>
<div style="color: red"> ${mensajeErrorTelefonoRepresentante} </div>
<div style="color: red"> ${mensajeErrorAmbitoActividad} </div>
<div style="color: red"> ${mensajeErrorCertificadoMinisterioIndustria} </div>
<div style="color: red"> ${mensajeErrorEstructuraJuridica} </div>


<form action="ServletRegistroProveedor" method="post" enctype="multipart/form-data" 
		onsubmit="validarFormularioRegistroProveedor()">
	Nombre de la empresa: <input type="text" name="campoNombreEmpresa"/> <br/>
	Dirección: <input type="text" name="campoDireccion"/> <br/>
	Teléfono: <input type="text" name="campoTelefono"/> <br/>
	Correo electrónico: <input type="text" name="campoEmail"/> <br/>
	Página web: <input type="text" name="campoWeb"/> <br/>
	Nombre del representante: <input type="text" name="campoNombreRepresentante"/> <br/>
	Teléfono del representante: <input type="text" name="campoTelefonoRepresentante"/> <br/>
	Ámbito de la actividad: <input type="radio" name="campoAmbitoActividad"
			  value="Nacional" checked/> Nacional &nbsp; <input type="radio" 
			  name="campoAmbitoActividad" value="Internacional"/> Internacional <br/>
	Certificado del Ministerio de Industria <input type="checkbox" name="campoCertificado"
			  value="Sí"/> <br/>
	Estructura jurídica: <select name="campoEstructuraJuridica">
	          <option value="Empresa conjunta">Empresa conjunta</option>
	          <option value="Sociedad Limitada">Sociedad Limitada</option>
	          <option value="Sociedad Anónima">Sociedad Anónima</option> </select> <br/>
	Imagen del logotipo: <input type="file" name="campoImagenLogo"/> <br/>
	<input type="submit" value="REGISTRAR"/>
</form>

<script type="text/javascript" src="js/validacionRegistrarProveedor.js"></script>

</body>
</html>