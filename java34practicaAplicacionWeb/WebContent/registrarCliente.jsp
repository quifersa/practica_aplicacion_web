<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional/
	/EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Registrar cliente </title>
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


<form action="ServletRegistroCliente" method="post">
Nombre: <input type="text" name="campoNombre"/> <br/>
Calle: <input type="text" name="campoCalle"/> <br/>
Número: <input type="text" name="campoNumero"/> <br/>
Código Postal: <input type="text" name="campoCodigoPostal"/> <br/>
Población: <input type="text" name="campoPoblacion"/> <br/>
Teléfono: <input type="text" name="campoTelefono"/> <br/>
Correo electrónico: <input type="text" name="campoEmail"/> <br/>
Particular o empresa: <input type="text" name="campoParticularEmpresa"/> <br/>
<input type="submit" value="REGISTRAR"/>
</form>

</body>
</html>