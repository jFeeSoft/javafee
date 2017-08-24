package com.jfeesoft.kindergarten.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "calendar")
@AttributeOverride(name = "id", column = @Column(name = "calendar_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "calendar_seq", allocationSize = 1, initialValue = 100)
public class Calendar extends GenericEntity {

	private static final long serialVersionUID = 1L;

}
