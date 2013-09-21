function check(form) {
	if ( form.login.value.length != 0 && form.senha.value.length != 0 ) {
		form.submit();
	} else {
		alert("Erro: Login e senha n\u00E3o podem ficar em branco.");
	}
}