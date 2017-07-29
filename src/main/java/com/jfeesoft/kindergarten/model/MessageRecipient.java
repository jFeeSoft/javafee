package com.jfeesoft.kindergarten.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "message_recipient")
@SequenceGenerator(name = "seq_message_recipient", sequenceName = "seq_message_recipient", initialValue = 1, allocationSize = 1)
public class MessageRecipient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_message_recipient")
	@Column(name = "message_recipient_id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "system_user_id")
	private SystemUser systemUser;

	@JoinTable(name = "message_recipient_message_group", //
			joinColumns = @JoinColumn(name = "message_recipient_id"), //
			inverseJoinColumns = @JoinColumn(name = "message_group_id"))
	private Set<MessageGroup> messageGroup = new HashSet<>(0);

	@OneToOne
	@JoinColumn(name = "message_id")
	private Message message;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
