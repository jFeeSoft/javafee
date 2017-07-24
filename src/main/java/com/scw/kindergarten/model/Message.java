package com.scw.kindergarten.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "message")
@SequenceGenerator(name = "seq_message", sequenceName = "seq_message", initialValue = 1, allocationSize = 1)
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_message")
	@Column(name = "message_id", unique = true, nullable = false, insertable = true, updatable = true)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "system_user_id")
	private SystemUser sender;
	
	@Column(name = "title", unique = false, nullable = true, insertable = true, updatable = true, length = 1024)
	private String title;
	
	@Column(name = "content", unique = false, nullable = true, insertable = true, updatable = true, length = 1024)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "send_date", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	private Date sendDate;
	
	@Column(name = "status", unique = false, nullable = false, insertable = true, updatable = true, length = 2)
	private Integer status;
	
	@Column(name = "is_priority", unique = false, nullable = true, insertable = true, updatable = true)
	private Boolean isPriority;

	@Column(name = "is_send", unique = false, nullable = true, insertable = true, updatable = true)
	private Boolean isSend;
	
	@Column(name = "is_read", unique = false, nullable = true, insertable = true, updatable = true)
	private Boolean isRead;
	
	@Column(name = "send_attempt_count", unique = false, nullable = false, insertable = true, updatable = true, length = 2)
	private Integer sendAttemptCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SystemUser getSender() {
		return sender;
	}

	public void setSender(SystemUser sender) {
		this.sender = sender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getIsPriority() {
		return isPriority;
	}

	public void setIsPriority(Boolean isPriority) {
		this.isPriority = isPriority;
	}

	public Boolean getIsSend() {
		return isSend;
	}

	public void setIsSend(Boolean isSend) {
		this.isSend = isSend;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	public Integer getSendAttemptCount() {
		return sendAttemptCount;
	}

	public void setSendAttemptCount(Integer sendAttemptCount) {
		this.sendAttemptCount = sendAttemptCount;
	}
}
