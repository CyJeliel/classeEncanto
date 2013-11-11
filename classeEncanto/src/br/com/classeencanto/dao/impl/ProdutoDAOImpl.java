package br.com.classeencanto.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Destaque;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.model.impl.Usuario;

@Repository
public class ProdutoDAOImpl extends AbstractDAO<Produto> implements ProdutoDAO {

	
	@Override
	public Produto findById(Long id) {
		//TODO REMOVER MÉTODO
		
        Produto produto = new Produto();
        produto.setNome("Bandaid's personalizados 2");
        produto.setResumo("Bandaid's personalizados para Kit Banheiro 2");
        produto.setDescricao("Bandaid's personalizados para Kit Banheiro 2");
        produto.setId(id);
        produto.setLocalizacao("img/bandaid.jpg");
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

	@Override
	public List<Produto> findListaDeDesejos(Usuario usuario) {
		// TODO MÉTODO EM MOCK
		
		List<Produto> listaDeDesejos= new ArrayList<>();
		
		Produto produto = findById(1l);
		
		listaDeDesejos.add(produto);
		
		Produto produto2 = findById(2l);
		
		listaDeDesejos.add(produto2);
		
		return listaDeDesejos;
	}

	@Override
	public List<Produto> addToListaDeDesejos(Produto produto, Usuario usuario) {
		// TODO MÉTODO EM MOCK
		List<Produto> listaDeDesejos = findListaDeDesejos(usuario);
		
		listaDeDesejos.add(produto);
		
		return listaDeDesejos;
	}

	@Override
	public List<Produto> findProdutos(Long idCategoria) {
		// TODO MÉTODO EM MOCK

		return findListaDeDesejos(null);
	}

	@Override
	public List<Destaque> findListaDeDestaques() {
		// TODO MÉTODO EM MOCK

		List<Destaque> listaDeDestaques = new ArrayList<>();
		
		for (int i = 1; i <= 3; ++i){
			
			Destaque destaque = new Destaque();
			
			destaque.setNome("Bandaid's personalizados 2");
			
			destaque.setResumo("Bandaid's personalizados para Kit Banheiro 2");
			
			destaque.setDescricao("Bandaid's personalizados para Kit Banheiro 2");
			
			destaque.setId(Long.valueOf(i));
			
			destaque.setLocalizacao("img/bandaid.jpg");
	        
			destaque.setPosicao(i);
			
			listaDeDestaques.add(destaque);
		}
		
		return listaDeDestaques ;
	}
	
}
