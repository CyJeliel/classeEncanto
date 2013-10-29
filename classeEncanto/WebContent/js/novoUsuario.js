function check(form) {
	if ( form.login.value.length != 0 && form.senha.value.length != 0 && form.confirmacaoSenha.value.length != 0 && form.email.value.length != 0) {
		form.submit();
	} else {
		alert("Erro: Preencha todos os campos.");
	}
}