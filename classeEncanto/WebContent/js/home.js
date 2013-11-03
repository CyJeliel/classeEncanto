var posicaoAtual = 0;

function exibeProximoDestaque() {
	
	posicaoAtual += 1;
	
	var existeProximo = $("#" + posicaoAtual).html();
	
	if (!existeProximo){
		
		posicaoAtual = 1;
	}
	
	exibeDestaque();
}

function exibeDestaqueAnterior() {
	
	posicaoAtual -= 1;
	
	var existeProximo; 
	
	var i = 0;
	
	do {
		
		existeProximo = $("#" + posicaoAtual).html();
		
		if (!existeProximo){
		
			posicaoAtual = 4 - i ;
		}
		++ i;
	} while (!existeProximo && i < 4);
	
	exibeDestaque();
}

function exibeDestaque(){
	
	for (var i = 1; i <= 4; ++i){
		
		var destaque = $("#" + i);
		
		if (destaque.html()){
			
			if (i == posicaoAtual){
				
				destaque.show();
				
			} else {
				
				destaque.hide();
			}
			
		}
	}
}