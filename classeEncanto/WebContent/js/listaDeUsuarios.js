function excluirUsuario(idUsuario) {

	if (window.confirm("Tem certeza que deseja excluir esse usuário? ")){

		var form = $("#formRemoverUsuario" + idUsuario);

		form.submit();
	}
}