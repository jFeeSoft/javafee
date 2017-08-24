package com.jfeesoft.kindergarten.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "meal")
@AttributeOverride(name = "id", column = @Column(name = "meal_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "meal_seq", allocationSize = 1, initialValue = 100)
public class Meal extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "description", length = 256)
	private String description;

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "meal_type_id")
	private MealType type;

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
