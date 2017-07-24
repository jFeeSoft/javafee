package com.scw.kindergarten.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "calendar")
@SequenceGenerator(name = "seq_calendar", sequenceName = "seq_calendar", initialValue = 1, allocationSize = 1)
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_calendar")
	@Column(name = "calendar_id", unique = true, nullable = false, insertable = true, updatable = true)
	private Integer id;
}
