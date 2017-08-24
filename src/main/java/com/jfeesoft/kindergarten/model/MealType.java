package com.jfeesoft.kindergarten.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "meal_type")
@AttributeOverride(name = "id", column = @Column(name = "meal_type_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "meal_type_seq", allocationSize = 1, initialValue = 100)
public class MealType extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", unique = true, nullable = false, length = 64)
	private String name;

	@Column(name = "description", length = 256)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
