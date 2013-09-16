function check(form) {
	if ( form.email.value.length != 0 && form.telefone.value.length != 0 )
		window.location.href = "/WEB-INF/senviaFaleConosco.jsp";
	else
		alert("Erro: Email e telefone n\u00E3o podem ficar em branco.");
}