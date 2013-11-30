function escolheProduto(posicao) {
	$("#produtosEscolhidos").hide();
	$("#escolherProdutos").show();
	$(".posicao").val(posicao);
}

function selecionaProduto(produtoId) {
	$("#produtosEscolhidos").show();
	$("#escolherProdutos").hide();
	$("#selecionaProduto" + produtoId).submit();
}

function excluirDestaque(idDestaque) {

	if (window.confirm("Tem certeza que deseja excluir esse destaque? ")){

		var form = $("#formRemoverDestaque" + idDestaque);

		form.submit();
	}
}

