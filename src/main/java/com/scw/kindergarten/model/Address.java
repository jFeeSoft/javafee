package com.scw.kindergarten.model;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@SequenceGenerator(name = "seq_address", sequenceName = "seq_address", initialValue = 1, allocationSize = 1)
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
	@Column(name = "address_id")
	private Integer id;
	
	@Column(name = "street", length = 128)
	private String street;
	
	@Column(name = "house_number", length = 16)
	private String houseNumber;
	
	@Column(name = "local_number", length = 16)
	private String localNumber;
	
	@OneToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "system_user")
	private Set<SystemUser> systemUsers = new HashSet<>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<SystemUser> getSystemUsers() {
		return systemUsers;
	}

	public void setSystemUsers(Set<SystemUser> systemUsers) {
		this.systemUsers = systemUsers;
	}
}
