function check(form) {
	email = form.email.value;
	telefone = form.telefone.value;
	mensagem = form.mensagem.value;
	continuar = 1;

	if ( ! validateEmail(email) ) {
		continuar = continuar * 0;
	}

	if ( ! validateTelefone(telefone) ) {
		continuar = continuar * 0;
	}

	if ( ! validateMensagem(mensagem) ) {
		continuar = continuar * 0;
	}

	if ( continuar ) {
		form.submit();
	}
}

function validateTelefone(telefone) {
	answer = 0;
	if (isNotEmpty(telefone)) {
		msg = "";
		answer = 1;
	}
	else {
		msg = "Telefone nao pode ficar em branco.";
	}
	document.getElementById('telefone_alert').innerText = msg;
	return answer;
}

function validateMensagem(mensagem) {
	answer = 0;
	if (isNotEmpty(mensagem)) {
		msg = "";
		answer = 1;
	}
	else {
		msg = "Mensagem nao pode ficar em branco.";
	}
	document.getElementById('message_alert').innerText = msg;
	return answer;
}