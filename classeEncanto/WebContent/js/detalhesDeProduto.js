function excluirProduto() {
	
	if (window.confirm("Tem certeza que deseja excluir esse produto? ")){
		
		var form = $("#formRemoverProduto");
		
		form.submit();
	}
}