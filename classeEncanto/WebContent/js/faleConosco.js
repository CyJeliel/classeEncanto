function check(form) {
	if ( form.email.value.length != 0 && form.telefone.value.length != 0 )
		window.location.href = "enviaFaleConosco.jsp";
	else
		alert("Erro: Login e senha n\u00E3o podem ficar em branco.");
}