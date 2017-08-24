package com.jfeesoft.kindergarten.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "event")
@AttributeOverride(name = "id", column = @Column(name = "event_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "event_seq", allocationSize = 1, initialValue = 100)
public class Event extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", length = 64)
	private String name;

	@Column(name = "description", length = 256)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "begin_date", length = 64)
	private Date beginDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", length = 64)
	private Date endDate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "events")
	private Set<Child> child = new HashSet<Child>(0);

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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<Child> getChild() {
		return child;
	}

	public void setChild(Set<Child> child) {
		this.child = child;
	}
}
