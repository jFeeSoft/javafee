package com.jfeesoft.kindergarten.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "group")
@SequenceGenerator(name = "seq_group", sequenceName = "seq_group", initialValue = 1, allocationSize = 1)
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_group")
	@Column(name = "group_id")
	private Integer id;

	@Column(name = "name", nullable = false, length = 64)
	private String name;

	@Column(name = "description", length = 256)
	private String description;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
	private Set<Child> child = new HashSet<Child>(0);

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "group_type_id")
	private GroupType type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_organisation")
	private Organisation organisation;

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

	public Set<Child> getChild() {
		return child;
	}

	public void setChild(Set<Child> child) {
		this.child = child;
	}

	public GroupType getType() {
		return type;
	}

	public void setType(GroupType type) {
		this.type = type;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}
}
