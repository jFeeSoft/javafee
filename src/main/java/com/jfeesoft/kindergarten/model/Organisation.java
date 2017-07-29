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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "organisation")
@SequenceGenerator(name = "seq_organisation", sequenceName = "seq_organisation", initialValue = 1, allocationSize = 1)
public class Organisation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_organisation")
	@Column(name = "organisation_id")
	private Integer id;

	@Column(name = "name", nullable = false, length = 64)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "nip_number", nullable = false, length = 16)
	private String nip;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "child")
	private Set<Child> children = new HashSet<>(0);

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organisation")
	private Set<Group> groups = new HashSet<Group>(0);

	@OneToOne
	@JoinColumn(name = "system_data_id")
	private SystemData systemData;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public Set<Child> getChildren() {
		return children;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public SystemData getSystemData() {
		return systemData;
	}

	public void setSystemData(SystemData systemData) {
		this.systemData = systemData;
	}
}
