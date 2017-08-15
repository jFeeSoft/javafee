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

import lombok.Data;

@Entity
@Table(name = "system_user")
@SequenceGenerator(name = "seq_system_user", sequenceName = "seq_system_user", initialValue = 1, allocationSize = 1)
@Data
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registration_date", length = 64)
	private Date registrationDate;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "system_user_role", //
			joinColumns = { @JoinColumn(name = "system_user_id") }, //
			inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<Role>(0);

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

}
