package com.jfeesoft.kindergarten.model;

import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "system_user")
@SequenceGenerator(name = "seq_system_user", sequenceName = "seq_system_user", initialValue = 1, allocationSize = 1)
public class SystemUser {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_system_user")
	@Column(name = "system_user_id")
	private Integer id;

	@Column(name = "password", nullable = false, length = 64)
	private String password;

	@Column(name = "password_attempt_count", length = 2)
	private Integer passwordAttemptCount;

	@Column(name = "first_name", length = 64)
	private String fisrstName;

	@Column(name = "second_name", length = 64)
	private String secondName;

	@Column(name = "surname", length = 64)
	private String surname;

	@Column(name = "email_address", unique = true, nullable = false, length = 64)
	private String emailAddress;

	@Column(name = "phone_number", length = 64)
	private String phoneNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", length = 13)
	private Date birthDate;

	@Column(name = "sex", length = 1)
	private Character sex;

	@Column(name = "pesel", unique = true, length = 11)
	private String peselNumber;

	@Column(name = "document_number", unique = true, length = 20)
	private String documentNumber;

	@Column(name = "registered")
	private Boolean registered;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "description", length = 256)
	private String description;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@Column(name = "is_blocked")
	private Boolean isBlocked;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registration_date", length = 64)
	private Date registrationDate;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "system_user_role", //
			joinColumns = @JoinColumn(name = "system_user_id"), //
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>(0);

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "system_user_message_group", //
			joinColumns = @JoinColumn(name = "system_user_id"), //
			inverseJoinColumns = @JoinColumn(name = "message_group_id"))
	private Set<MessageGroup> messageGroups = new HashSet<>(0);

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "system_user_child", //
			joinColumns = @JoinColumn(name = "system_user_id"), //
			inverseJoinColumns = @JoinColumn(name = "child_id"))
	private Set<Child> children = new HashSet<>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPasswordAttemptCount() {
		return passwordAttemptCount;
	}

	public void setPasswordAttemptCount(Integer passwordAttemptCount) {
		this.passwordAttemptCount = passwordAttemptCount;
	}

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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getPeselNumber() {
		return peselNumber;
	}

	public void setPeselNumber(String peselNumber) {
		this.peselNumber = peselNumber;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Boolean getRegistered() {
		return registered;
	}

	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<MessageGroup> getMessageGroups() {
		return messageGroups;
	}

	public void setMessageGroups(Set<MessageGroup> messageGroups) {
		this.messageGroups = messageGroups;
	}

	public Set<Child> getChildren() {
		return children;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}
}
