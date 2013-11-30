package br.com.classeencanto.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.classeencanto.dto.CategoriaDTO;
import br.com.classeencanto.model.impl.Categoria;
import br.com.classeencanto.model.impl.Produto;

@Component
public class CategoriaListTransformer {

	@Autowired
	private CategoriaTransformer categoriaTransformer;

	public List<CategoriaDTO> entityToDTOList(List<Categoria> categorias, Produto produto) {

		List<CategoriaDTO> categoriasDTO = new ArrayList<>();

		for (Categoria categoria: categorias){

			boolean isSelected = false;

			if (produto.getCategorias().contains(categoria)){

				isSelected = true;
			}

			CategoriaDTO dto = categoriaTransformer.entityToDTO(categoria, isSelected);

			categoriasDTO.add(dto);
		}

		return categoriasDTO;
	}

}
