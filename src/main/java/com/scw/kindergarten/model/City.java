package com.scw.kindergarten.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "city")
@SequenceGenerator(name = "seq_city", sequenceName = "seq_city", initialValue = 1, allocationSize = 1)
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_city")
	@Column(name = "city_id", unique = true, nullable = false, insertable = true, updatable = true)
	private Integer id;

	@Column(name = "name", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	private String name;

	@Column(name = "postal_code", unique = false, nullable = true, insertable = true, updatable = true, length = 6)
	private String postalCode;

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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}