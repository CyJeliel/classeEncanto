package br.com.classeencanto.util;

public class Feedback {

	private String mensagem;
	
	private TipoFeedback tipo;
	
	public Feedback(String mensagem, TipoFeedback tipo) {

		this.mensagem = mensagem;
		
		this.tipo = tipo;
		
	}

	public String getMensagem() {
		return mensagem;
	}

	public TipoFeedback getTipo() {
		return tipo;
	}

}
