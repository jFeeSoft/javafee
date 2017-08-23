package com.jfeesoft.kindergarten.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
@SequenceGenerator(name = "seq_permission", sequenceName = "seq_permission", allocationSize = 1, initialValue = 100)
public class Permission implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_permission")
	@Column(name = "permission_id")
	private Integer id;

	@Column(name = "name", nullable = false, length = 64)
	private String name;

	// TODO Association
	@Column(name = "component", length = 64)
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
