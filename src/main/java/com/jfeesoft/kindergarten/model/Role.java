package com.jfeesoft.kindergarten.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_role", sequenceName = "seq_role", allocationSize = 1)
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
	@Column(name = "role_id")
	private Integer id;

	@Column(name = "name", length = 64)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<SystemUser> systemUser = new HashSet<>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_permission", //
			joinColumns = @JoinColumn(name = "role_id"), //
			inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private Set<Permission> permissions = new HashSet<>(0);

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

	public Set<SystemUser> getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(Set<SystemUser> systemUser) {
		this.systemUser = systemUser;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

}
