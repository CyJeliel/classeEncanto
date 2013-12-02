function check(form) {
	if (form.descricao.value.length != 0) {
		form.submit();
	} else {
		alert("Erro: Preencha todos os campos.");
	}
}