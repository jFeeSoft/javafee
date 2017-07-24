package com.scw.kindergarten.model;

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
	@Column(name = "event_id", unique = true, nullable = false, insertable = true, updatable = true)
	private Integer id;
	
	@Column(name = "name", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	private String name;
	
	@Column(name = "description", unique = false, nullable = true, insertable = true, updatable = true, length = 256)
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "begin_date", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	private Date beginDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	private Date endDate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "event")
	private Set<Child> child = new HashSet<Child>(0);
}
