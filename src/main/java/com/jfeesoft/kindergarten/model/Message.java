package com.jfeesoft.kindergarten.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "message")
@AttributeOverride(name = "id", column = @Column(name = "message_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "message_seq", allocationSize = 1, initialValue = 100)
public class Message extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "system_user_id")
	private SystemUser sender;

	@Column(name = "title", length = 64)
	private String title;

	@Column(name = "content", length = 1024)
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "send_date", nullable = false, length = 64)
	private Date sendDate;

	@Column(name = "status", nullable = false, length = 2)
	private Integer status;

	@Column(name = "is_priority")
	private Boolean isPriority;

	@Column(name = "is_send", nullable = false)
	private Boolean isSend;

	@Column(name = "is_read")
	private Boolean isRead;

	@Column(name = "send_attempt_count", length = 2)
	private Integer sendAttemptCount;

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
