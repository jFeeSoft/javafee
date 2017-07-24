package com.scw.kindergarten.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "meal")
@SequenceGenerator(name = "seq_meal", sequenceName = "seq_meal", initialValue = 1, allocationSize = 1)
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_meal")
	@Column(name = "meal_id", unique = true, nullable = false, insertable = true, updatable = true)
	private Integer id;

	@Column(name = "description", unique = false, nullable = true, insertable = true, updatable = true, length = 256)
	private String description;

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "meal_type_id", unique = false, nullable = true, insertable = true, updatable = true)
	private MealType type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MealType getType() {
		return type;
	}

	public void setType(MealType type) {
		this.type = type;
	}
}
