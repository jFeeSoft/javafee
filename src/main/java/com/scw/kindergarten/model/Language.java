package com.scw.kindergarten.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "language")
@SequenceGenerator(name = "seq_language", sequenceName = "seq_language", initialValue = 1, allocationSize = 1)
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_language")
	@Column(name = "language_id", unique = true, nullable = false, insertable = true, updatable = true)
	private Integer id;

	@Column(name = "name", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
