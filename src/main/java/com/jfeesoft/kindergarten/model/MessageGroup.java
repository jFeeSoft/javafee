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
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "message_group")
@SequenceGenerator(name = "seq_message_group", sequenceName = "seq_message_group", initialValue = 1, allocationSize = 1)
public class MessageGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_message_group")
	@Column(name = "message_group_id")
	private Integer id;

	@Column(name = "name", nullable = false, length = 64)
	private String name;

	@Column(name = "description", length = 256)
	private String description;

	@Column(name = "is_active")
	private Boolean isActive;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "system_user")
	private Set<SystemUser> systemUser = new HashSet<>(0);

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "message_recipient")
	private Set<MessageRecipient> messageRecipient = new HashSet<>(0);

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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<SystemUser> getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(Set<SystemUser> systemUser) {
		this.systemUser = systemUser;
	}

	public Set<MessageRecipient> getMessageRecipient() {
		return messageRecipient;
	}

	public void setMessageRecipient(Set<MessageRecipient> messageRecipient) {
		this.messageRecipient = messageRecipient;
	}
}
