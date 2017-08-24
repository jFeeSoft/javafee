package com.jfeesoft.kindergarten.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "message_group")
@AttributeOverride(name = "id", column = @Column(name = "message_group_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "message_group_seq", allocationSize = 1, initialValue = 100)
public class MessageGroup extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false, length = 64)
	private String name;

	@Column(name = "description", length = 256)
	private String description;

	@Column(name = "is_active")
	private Boolean isActive;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "messageGroups")
	private Set<SystemUser> systemUser = new HashSet<>(0);

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "messageGroup")
	private Set<MessageRecipient> messageRecipient = new HashSet<>(0);

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
