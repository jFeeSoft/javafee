package com.scw.kindergarten.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "system_data", uniqueConstraints = { @UniqueConstraint(columnNames = { "license_number" }) })
@SequenceGenerator(name = "seq_system_data", sequenceName = "seq_system_data", initialValue = 1, allocationSize = 1)
public class SystemData {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_system_data")
	@Column(name = "system_data_id")
	private Integer id;

	@Column(name = "name", length = 64)
	private String name;

	@Column(name = "version", length = 64)
	private String version;

	@Column(name = "build_number", length = 64)
	private String buildNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "installation_date", length = 13)
	private Date installationDate;

	@Column(name = "has_license")
	private Boolean hasLicense = false;

	@Column(name = "license_number", length = 64)
	private String licenseNumber;

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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}

	public Date getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
	}

	public Boolean getHasLicense() {
		return hasLicense;
	}

	public void setHasLicense(Boolean hasLicense) {
		this.hasLicense = hasLicense;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
}
