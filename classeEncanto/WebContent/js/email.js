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