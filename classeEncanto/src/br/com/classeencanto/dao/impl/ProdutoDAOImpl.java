package br.com.classeencanto.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Produto;

@Repository
public class ProdutoDAOImpl extends AbstractDAO<Produto> implements ProdutoDAO {

	
	@Override
	public Produto findById(Long id) {
		//TODO REMOVER MÉTODO
		
        Produto produto = new Produto();
        produto.setNome("Bandaid's personalizados");
        produto.setId(id);
        return produto;
	}

	@Override
	public List<Long> findProdutosRelacionados(Long idProduto) {
		// TODO MÉTODO EM MOCK
        
        List<Long> itensRelacionados = new ArrayList<>();
        itensRelacionados.add(2L);
        itensRelacionados.add(3L);
        itensRelacionados.add(4L);
        itensRelacionados.add(5L);
		return itensRelacionados;
	}
	
}
