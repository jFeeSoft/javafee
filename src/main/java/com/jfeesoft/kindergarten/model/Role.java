package com.jfeesoft.kindergarten.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "role", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Role {
	@Id
	@Column(name = "name", length = 64)
	private String name;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "system_user")
	private Set<SystemUser> systemUser = new HashSet<>(0);

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "system_user_permission", //
			joinColumns = @JoinColumn(name = "system_user_id"), //
			inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private Set<Permission> permissions = new HashSet<>(0);

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
