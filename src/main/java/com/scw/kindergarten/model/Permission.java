package com.scw.kindergarten.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
@SequenceGenerator(name = "seq_permission", sequenceName = "seq_permission", allocationSize = 1)
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_permission")
	@Column(name = "permission_id", unique = false, nullable = false, insertable = true, updatable = true)
	private Integer id;

	@Column(name = "name", unique = false, nullable = false, insertable = true, updatable = true, length = 64)
	private String name;

	// TODO Association
	@Column(name = "component", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	private String component;

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

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}
}
