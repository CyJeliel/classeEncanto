function check(form) {
	if ( form.login.value.length != 0 && form.senha.value.length != 0 )
		// TODO Cindy vai fazer um exemplo de chamada de p‡gina no javascript. 
		window.location.href = "/admin";
	else
		alert("Erro: Login e senha n\u00E3o podem ficar em branco.");
}