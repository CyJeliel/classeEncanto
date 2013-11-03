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
		// TODO ENVIAR MENSAGEM.
		document.getElementById('telefone_alert').innerText = 'Mensagem enviada.';
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

function validateEmail(email) {
	answer = 0;
	if (isNotEmpty(email)) {
		if (valideEmail(email)) {
			msg = "";
			answer = 1;
		}
		else {
			msg = "Email nao eh valido.";
		}
	}
	else {
		msg = "Email nao pode ficar em branco.";
	}

	document.getElementById('email_alert').innerText = msg;
	return answer;
}

function isNotEmpty(text) {
	return text.length;
}

function valideEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}