package br.com.classeencanto.model.impl;

import javax.persistence.Id;

public abstract class AbstractModel {
	@Id
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
