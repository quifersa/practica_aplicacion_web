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
	
	var expresionCampoNombre = /^[a-z��������\s]{2,50}$/i;
	if (expresionCampoNombre.test(nombre)){
	} else {
		alert("Nombre no v�lido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoCalle = /^[a-z0-9��������\s]{3,70}$/i;
	if (expresionCampoCalle.test(calle)){
	} else {
		alert("Calle no v�lida");
		enviarForm = false;
		return;
	}
	
	var expresionCampoNumero = /^[0-9-]{1,6}$/;
	if (expresionCampoNumero.test(numero)){
	} else {
		alert("N�mero no v�lido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoCodigoPostal = /^[0-9]{5,9}$/;
	if (expresionCampoCodigoPostal.test(codigoPostal)){
	} else {
		alert("C�digo postal no v�lido");
		enviarForm = false;
		return;
	}
	
	var expresionCampoPoblacion = /^[a-z��������\s]{3,30}$/i;
	if (expresionCampoPoblacion.test(poblacion)){
	} else {
		alert("Poblaci�n no v�lida");
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
	
	var expresionCampoParticularEmpresa = 
		/^(particular|empresa|Empresa|Particular|PARTICULAR|EMPRESA)$/;
	if (expresionCampoParticularEmpresa.test(particularEmpresa)){
	} else {
		alert("Particular o empresa no v�lido");
		enviarForm = false;
		return;
	}
	
	return enviarForm;
	
}