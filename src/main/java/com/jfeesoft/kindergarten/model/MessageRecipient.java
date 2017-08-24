package com.jfeesoft.kindergarten.model;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "message_recipient")
@AttributeOverride(name = "id", column = @Column(name = "message_recipient_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "message_recipient_seq", allocationSize = 1, initialValue = 100)
public class MessageRecipient extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "system_user_id")
	private SystemUser systemUser;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "message_recipient_message_group", //
			joinColumns = @JoinColumn(name = "message_recipient_id"), //
			inverseJoinColumns = @JoinColumn(name = "message_group_id"))
	private Set<MessageGroup> messageGroup = new HashSet<>(0);

	@OneToOne
	@JoinColumn(name = "message_id")
	private Message message;

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	public Set<MessageGroup> getMessageGroup() {
		return messageGroup;
	}

	public void setMessageGroup(Set<MessageGroup> messageGroup) {
		this.messageGroup = messageGroup;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}
