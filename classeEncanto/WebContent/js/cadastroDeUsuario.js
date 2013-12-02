function check(form) {
	var senha = form.senha.value;
	var confirmacaoSenha = form.confirmacaoSenha.value;
	if (form.login.value.length != 0 && senha.length != 0
			&& confirmacaoSenha.length != 0 && form.email.value.length != 0) {
		if (senha == confirmacaoSenha) {
			form.submit();
		} else {
			alert("Erro: Senha e confirmação não são iguais.");
		}
	} else {
		alert("Erro: Preencha todos os campos.");
	}
}