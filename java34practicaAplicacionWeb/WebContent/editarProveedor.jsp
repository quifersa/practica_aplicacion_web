<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional/
		/EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Edición del proveedor </title>
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


<form action="ServletGuardarCambiosProveedor" method="post" enctype="multipart/form-data" 
		onsubmit="validarFormularioRegistroProveedor()">
	Nombre de la empresa: <input type="text" name="campoNombreEmpresa" 
		value="${proveedorAEditar.nombreEmpresa}"/> <br/>
	Dirección: <input type="text" name="campoDireccion" 
		value="${proveedorAEditar.direccion}"/> <br/>
	Teléfono: <input type="text" name="campoTelefono" 
		value="${proveedorAEditar.telefono}"/> <br/>
	Correo electrónico: <input type="text" name="campoEmail" 
		value="${proveedorAEditar.correoElectronico}"/> <br/>
	Página web: <input type="text" name="campoWeb" 
		value="${proveedorAEditar.paginaWeb}"/> <br/>
	Nombre del representante: <input type="text" name="campoNombreRepresentante" 
		value="${proveedorAEditar.nombreRepresentante}"/> <br/>
	Teléfono del representante: <input type="text" name="campoTelefonoRepresentante" 
		value="${proveedorAEditar.telefonoRepresentante}"/> <br/>
	Ámbito de la actividad: <input type="radio" name="campoAmbitoActividad"
			  value="Nacional" checked/> Nacional &nbsp; <input type="radio" 
			  name="campoAmbitoActividad" value="Internacional"/> Internacional <br/>
	Certificado del Ministerio de Industria <input type="checkbox" name="campoCertificado" 
			  value="Sí"/> <br/>
	Estructura jurídica: <select name="campoEstructuraJuridica">
	          <option value="Empresa conjunta">Empresa conjunta</option>
	          <option value="Sociedad Limitada">Sociedad Limitada</option>
	          <option value="Sociedad Anónima">Sociedad Anónima</option> </select> <br/>
	Imagen del logotipo: <input type="file" id="idCampoImagenLogo" name="campoImagenLogo"
				value="${proveedorAEditar.rutaImagenLogo}" hidden/>
			<input type="text" id="idTextoImagenLogo" 
				value="${proveedorAEditar.rutaImagenLogo}"/> <br/>			
	<input type="hidden" name="campoId" value="${proveedorAEditar.id}"/> <br/>
	<input type="submit" value="GUARDAR CAMBIOS"/> <br/>
</form> <br/>

<button id="botonModificar" 
			onclick="accionBotonModificar();">Modificar imagen</button> <br/>

<script type="text/javascript" src="js/validacionRegistrarProveedor.js"></script>
<script type="text/javascript" src="js/modificarImagen.js"></script>

</body>
</html>