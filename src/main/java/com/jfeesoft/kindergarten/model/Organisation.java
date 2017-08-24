package com.jfeesoft.kindergarten.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "organisation")
@AttributeOverride(name = "id", column = @Column(name = "organisation_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "organisation_seq", allocationSize = 1, initialValue = 100)
public class Organisation extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false, length = 64)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "nip_number", nullable = false, length = 16)
	private String nip;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "organisations")
	private Set<Child> children = new HashSet<>(0);

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organisation")
	private Set<Group> groups = new HashSet<Group>(0);

	@OneToOne
	@JoinColumn(name = "system_data_id")
	private SystemData systemData;

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
