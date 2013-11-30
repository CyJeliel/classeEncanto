package br.com.classeencanto.transformer;

import org.springframework.stereotype.Component;

import br.com.classeencanto.dto.CategoriaDTO;
import br.com.classeencanto.model.impl.Categoria;

@Component
public class CategoriaTransformer {

	public CategoriaDTO entityToDTO(Categoria categoria, boolean isSelected) {

		CategoriaDTO dto = new CategoriaDTO();

		dto.setCategoria(categoria);

		dto.setSelected(isSelected);

		return dto;
	}

}
