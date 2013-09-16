window.onload = function() {
	int maxLinhas = 5;
	int maxColunas = 5;
	int qtdItens = 24;
	int i, j;
	int productItem;
	var texto = "<ol>";
	if ( qtdItens > 0 ) {
		for ( productItem = 0; productItem < qtdItens; productItem++ ) {
			texto = texto + '<li class="artigo" ><a href=""><img src="/img/' + listaDeArtigos[productItem].codigo + '" alt="' + listaDeArtigos[productItem].nome + '" /></a></li>';
			if ( (productItem%maxColunas) == 0 )
				texto = texto + "<br />";
		}
		for ( ; (productItem%maxColunas) != 0 < qtdItens; productItem++ )
			texto = texto + '<li class="artigo" ></li>';
	}
	texto = "</ol>";
	document.getElementById('listagemDeProdutos').innerHTML = texto;
};