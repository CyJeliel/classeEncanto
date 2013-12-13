function alterarVisibilidadeDaImagem(file){

	var nome = $(file).val();

	if (nome != null && !nome == ""){

		$("#imagem").hide();

	} else {

		$("#imagem").show();
	}
}

function validaCadastro(form) {

	if ( ! validarNome(form) ) {

		return;
	}

	if ( ! validarResumo(form) ) {

		return;
	}

	if ( ! validarDescricao(form) ) {

		return;
	}

	if ( ! validarGruposDoProduto(form) ) {

		return;
	}

	if ( ! validarTemasDoProduto(form) ) {

		return;
	}

	form.submit();
}

function validarNome (form){

	var nome = form.nome.value;

	if (nome == null || nome == ""){

		window.alert("O nome não pode estar em branco.");

		return false;
	}

	return true;
}

function validarImagem (){

	var imagem = $("#imagem").val();
	
	if (imagem == null || imagem == ""){

		window.alert("A imagem não pode estar em branco.");

		return false;
	}

	return true;
}

function validarResumo(form) {

	var resumo = form.resumo.value;
	
	if (resumo == null || resumo == ""){

		window.alert("O resumo não pode estar em branco.");

		return false;
	}

	return true;
}

function validarDescricao(form) {

	var descricao = form.descricao.value;

	if (descricao == null || descricao == ""){

		window.alert("A descrição não pode estar em branco.");

		return false;
	}

	return true;
}

function validarGruposDoProduto(form) {

	var grupoDoProduto = $("#grupoDoProduto option:selected").val();

	if (grupoDoProduto == null || grupoDoProduto.length == 0){

		window.alert("Escolha ao menos um evento.");

		return false;
	}

	return true;
}

function validarTemasDoProduto(form) {

	var temaDoProduto = $("#temaDoProduto option:selected").val();

	if (temaDoProduto == null || temaDoProduto.length == 0){

		window.alert("escolha ao menos uma decoração.");

		return false;
	}

	return true;
}
