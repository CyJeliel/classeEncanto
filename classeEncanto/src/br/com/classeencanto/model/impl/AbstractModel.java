package br.com.classeencanto.model.impl;

import javax.persistence.Id;
import br.com.classeencanto.model.Model;

public abstract class AbstractModel implements Model {
	@Id
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
