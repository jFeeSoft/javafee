package com.jfeesoft.kindergarten.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "city")
@AttributeOverride(name = "id", column = @Column(name = "city_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "city_seq", allocationSize = 1, initialValue = 100)
public class City extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", length = 64)
	private String name;

	@Column(name = "postal_code", length = 6)
	private String postalCode;

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
