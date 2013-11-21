function alterarVisibilidadeDaImagem(file){

	var nome = $(file).val();
	
	if (nome != null && !nome == ""){
		
		$("#imagem").hide();
	
	} else {
	
		$("#imagem").show();
	}
}