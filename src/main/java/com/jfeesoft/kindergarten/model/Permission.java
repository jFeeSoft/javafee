package com.jfeesoft.kindergarten.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permission")
@SequenceGenerator(name = "seq_permission", sequenceName = "seq_permission", allocationSize = 1, initialValue = 100)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_permission")
	@Column(name = "permission_id")
	private Integer id;

	@Column(name = "name", nullable = false, length = 64)
	private String name;

	// TODO Association
	@Column(name = "component", length = 64)
	private String component;

}
