function excluirCategoria(idCategoria) {

	if (window.confirm("Tem certeza que deseja excluir essa categoria? ")){

		var form = $("#formRemoverCategoria" + idCategoria);

		form.submit();
	}
}