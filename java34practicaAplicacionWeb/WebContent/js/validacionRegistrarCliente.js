function validarFormularioRegistroCliente(){
	
	var enviarForm = true;
	
	var nombre = document.getElementsByName("campoNombre")[0].value;
	var calle = document.getElementsByName("campoCalle")[0].value;
	var numero = document.getElementsByName("campoNumero")[0].value;
	var codigoPostal = document.getElementsByName("campoCodigoPostal")[0].value;
	var poblacion = document.getElementsByName("campoPoblacion")[0].value;
	var telefono = document.getElementsByName("campoTelefono")[0].value;
	var email = document.getElementsByName("campoEmail")[0].value;
	var particularEmpresa = document.getElementsByName("campoParticularEmpresa")[0].value;
	
	var expresionCampoNombre = /^[a-záéíóúüñç\s]{2,50}$/i;
	if (expresionCampoNombre.test(nombre)){
	} else {
		alert("Nombre no válido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoCalle = /^[a-z0-9áéíóúüñç\s]{3,70}$/i;
	if (expresionCampoCalle.test(calle)){
	} else {
		alert("Calle no válida");
		enviarForm = false;
		return;
	}
	
	var expresionCampoNumero = /^[0-9-]{1,6}$/;
	if (expresionCampoNumero.test(numero)){
	} else {
		alert("Número no válido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoCodigoPostal = /^[0-9]{5,9}$/;
	if (expresionCampoCodigoPostal.test(codigoPostal)){
	} else {
		alert("Código postal no válido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoPoblacion = /^[a-záéíóúüñç\s]{3,30}$/i;
	if (expresionCampoPoblacion.test(poblacion)){
	} else {
		alert("Población no válida");
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
	
	var expresionCampoParticularEmpresa = 
		/^(particular|empresa|Empresa|Particular|PARTICULAR|EMPRESA)$/;
	if (expresionCampoParticularEmpresa.test(particularEmpresa)){
	} else {
		alert("Particular o empresa no válido");
		enviarForm = false;
		return;
	}
	
	return enviarForm;
	
}