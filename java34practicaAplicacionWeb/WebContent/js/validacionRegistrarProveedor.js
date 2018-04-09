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
	
	var expresionCampoNombreEmpresa = /^[a-z0-9.��������\s]{1,70}$/i;
	if (expresionCampoNombreEmpresa.test( nombreEmpresa)){
	} else {
		alert("Nombre empresa no v�lido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoNombreEmpresa = /^[a-z0-9.��������\s]{1,70}$/i;
	if (expresionCampoNombreEmpresa.test( nombreEmpresa)){
	} else {
		alert("Nombre empresa no v�lido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoDireccion = /^[a-z0-9.,��������\s]{3,100}$/i;
	if (expresionCampoDireccion.test(direccion)){
	} else {
		alert("Direcci�n no v�lida");
		enviarForm = false;
		return;
	}
	
	var expresionCampoTelefono = /^[0-9+]{9,30}$/;
	if (expresionCampoTelefono.test(telefono)){
	} else {
		alert("Tel�fono no v�lido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoEmail = /^[a-z��������0-9._+-]{1,70}@[a-z0-9]{1,30}\.[a-zA-Z.]{2,20}$/i;
	if (expresionCampoEmail.test(email)){
	} else {
		alert("Correo electr�nico no v�lido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoWeb = /^[a-z0-9.��������\s]{1,70}\.[a-z0-9.��������\s]{1,70}$/i;
	if (expresionCampoWeb.test(web)){
	} else {
		alert("P�gina web no v�lida");
		enviarForm = false;
		return;
	}
	
	var expresionCampoNombreRepresentante = /^[a-z.��������\s]{1,50}$/;
	if (expresionCampoNombreRepresentante.test(nombreRepresentante)){
	} else {
		alert("Nombre representante no v�lido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoTelefonoRepresentante = /^[0-9+]{9,30}$/;
	if (expresionCampoTelefonoRepresentante.test(telefonoRepresentante)){
	} else {
		alert("Tel�fono representante no v�lido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoAmbitoActividad = /^(Nacional|Internacional)$/;
	if (expresionCampoAmbitoActividad.test(ambitoActividad)){
	} else {
		alert("�mbito actividad no v�lida");
		enviarForm = false;
		return;
	}
	
	var expresionCampoCertificadoMinisterio = /^(S�|null)$/;
	if (expresionCampoCertificadoMinisterio.test(certificadoMinisterio)){
	} else {
		alert("Certificado Ministerio Industria no v�lido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoEstructuraJuridica = 
		/^(Empresa conjunta|Sociedad Limitada|Sociedad An�nima)$/;
	if (expresionCampoEstructuraJuridica.test(estructuraJuridica)){
	} else {
		alert("Estructura jur�dica no v�lida");
		enviarForm = false;
		return;
	}
	
	return enviarForm;
	
}