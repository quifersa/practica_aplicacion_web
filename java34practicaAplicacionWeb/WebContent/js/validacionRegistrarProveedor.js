function validarFormularioRegistroProveedor(){
	
	var enviarForm = true;
	
	var nombreEmpresa = document.getElementsByName("campoNombreEmpresa")[0].value;
	var direccion = document.getElementsByName("campoDireccion")[0].value;
	var telefono = document.getElementsByName("campoTelefono")[0].value;
	var email = document.getElementsByName("campoEmail")[0].value;
	var web = document.getElementsByName("campoWeb")[0].value;
	var nombreRepresentante = document.getElementsByName("campoNombreRepresentante")[0].value;
	var telefonoRepresentante =document.getElementsByName("campoTelefonoRepresentante")[0].value;
	var ambitoActividad = document.getElementsByName("campoAmbitoActividad")[0].value;
	var certificadoMinisterio = document.getElementsByName("campoCertificado")[0].value;
	var estructuraJuridica = document.getElementsByName("campoEstructuraJuridica")[0].value;
	
	var expresionCampoNombreEmpresa = /^[a-z0-9.áéíóúüñç\s]{1,70}$/i;
	if (expresionCampoNombreEmpresa.test( nombreEmpresa)){
	} else {
		alert("Nombre empresa no válido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoNombreEmpresa = /^[a-z0-9.áéíóúüñç\s]{1,70}$/i;
	if (expresionCampoNombreEmpresa.test( nombreEmpresa)){
	} else {
		alert("Nombre empresa no válido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoDireccion = /^[a-z0-9.,áéíóúüñç\s]{3,100}$/i;
	if (expresionCampoDireccion.test(direccion)){
	} else {
		alert("Dirección no válida");
		enviarForm = false;
		return;
	}
	
	var expresionCampoTelefono = /^[0-9+]{9,30}$/;
	if (expresionCampoTelefono.test(telefono)){
	} else {
		alert("Teléfono no válido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoEmail = /^[a-záéíóúüñç0-9._+-]{1,70}@[a-z0-9]{1,30}\.[a-zA-Z.]{2,20}$/i;
	if (expresionCampoEmail.test(email)){
	} else {
		alert("Correo electrónico no válido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoWeb = /^[a-z0-9.áéíóúüñç\s]{1,70}\.[a-z0-9.áéíóúüñç\s]{1,70}$/i;
	if (expresionCampoWeb.test(web)){
	} else {
		alert("Página web no válida");
		enviarForm = false;
		return;
	}
	
	var expresionCampoNombreRepresentante = /^[a-z.áéíóúüñç\s]{1,50}$/;
	if (expresionCampoNombreRepresentante.test(nombreRepresentante)){
	} else {
		alert("Nombre representante no válido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoTelefonoRepresentante = /^[0-9+]{9,30}$/;
	if (expresionCampoTelefonoRepresentante.test(telefonoRepresentante)){
	} else {
		alert("Teléfono representante no válido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoAmbitoActividad = /^(Nacional|Internacional)$/;
	if (expresionCampoAmbitoActividad.test(ambitoActividad)){
	} else {
		alert("Ámbito actividad no válida");
		enviarForm = false;
		return;
	}
	
	var expresionCampoCertificadoMinisterio = /^(Sí|null)$/;
	if (expresionCampoCertificadoMinisterio.test(certificadoMinisterio)){
	} else {
		alert("Certificado Ministerio Industria no válido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoEstructuraJuridica = 
		/^(Empresa conjunta|Sociedad Limitada|Sociedad Anónima)$/;
	if (expresionCampoEstructuraJuridica.test(estructuraJuridica)){
	} else {
		alert("Estructura jurídica no válida");
		enviarForm = false;
		return;
	}
	
	return enviarForm;
	
}