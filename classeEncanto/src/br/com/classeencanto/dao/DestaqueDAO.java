package br.com.classeencanto.dao;

import java.util.List;

import br.com.classeencanto.model.impl.Destaque;

public interface DestaqueDAO extends DAO<Destaque> {

	List<Destaque> findListaDeDestaques();

	Destaque findDestaque(Integer posicao);

}
