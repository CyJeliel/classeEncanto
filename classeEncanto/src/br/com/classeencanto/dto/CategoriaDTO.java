package br.com.classeencanto.dto;

import br.com.classeencanto.model.impl.Categoria;

public class CategoriaDTO {

	private Categoria categoria;

	private boolean selected;

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
