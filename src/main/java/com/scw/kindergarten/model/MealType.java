package com.scw.kindergarten.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "meal_type")
@SequenceGenerator(name = "seq_meal_type", sequenceName = "seq_meal_type", initialValue = 1, allocationSize = 1)
public class MealType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_meal_type")
	@Column(name = "meal_type_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", unique = false, nullable = false, insertable = true, updatable = true, length = 64)
	private String name;

	@Column(name = "description", unique = false, nullable = true, insertable = true, updatable = true, length = 256)
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
