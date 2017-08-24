package com.jfeesoft.kindergarten.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "child")
@AttributeOverride(name = "id", column = @Column(name = "child_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "child_seq", allocationSize = 1, initialValue = 100)
public class Child extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "first_name", length = 64)
	private String fisrstName;

	@Column(name = "second_name", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	private String secondName;

	@Column(name = "surname", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	private String surname;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", unique = false, nullable = true, insertable = true, updatable = true, length = 13)
	private Date birthDate;

	@Column(name = "sex", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	private Character sex;

	@Column(name = "description", unique = false, nullable = true, insertable = true, updatable = true, length = 256)
	private String description;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "children")
	private Set<SystemUser> systemUser = new HashSet<>(0);

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "child_organisation", //
			joinColumns = @JoinColumn(name = "child_id"), //
			inverseJoinColumns = @JoinColumn(name = "organisation_id"))
	private Set<Organisation> organisations = new HashSet<>(0);

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "child_group", //
			joinColumns = @JoinColumn(name = "child_id"), //
			inverseJoinColumns = @JoinColumn(name = "group_id"))
	private Set<Group> groups = new HashSet<>(0);

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "child_event", //
			joinColumns = @JoinColumn(name = "child_id"), //
			inverseJoinColumns = @JoinColumn(name = "event_id"))
	private Set<Event> events = new HashSet<>(0);

	public String getFisrstName() {
		return fisrstName;
	}

	public void setFisrstName(String fisrstName) {
		this.fisrstName = fisrstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<SystemUser> getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(Set<SystemUser> systemUser) {
		this.systemUser = systemUser;
	}

	public Set<Organisation> getOrganisations() {
		return organisations;
	}

	public void setOrganisations(Set<Organisation> organisations) {
		this.organisations = organisations;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
}
