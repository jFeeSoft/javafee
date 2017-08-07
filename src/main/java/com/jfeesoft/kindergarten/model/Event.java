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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "event")
@SequenceGenerator(name = "seq_event", sequenceName = "seq_event", initialValue = 1, allocationSize = 1)
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_event")
	@Column(name = "event_id")
	private Integer id;

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
