package com.jfeesoft.kindergarten.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "system_data", uniqueConstraints = { @UniqueConstraint(columnNames = { "license_number" }) })
@AttributeOverride(name = "id", column = @Column(name = "system_data_id", nullable = false))
@SequenceGenerator(name = "default_gen", sequenceName = "system_data_seq", allocationSize = 1, initialValue = 100)
public class SystemData extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", length = 64)
	private String name;

	@Column(name = "app_version", length = 64)
	private String appVersion;

	@Column(name = "build_number", length = 64)
	private String buildNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "installation_date", length = 13)
	private Date installationDate;

	@Column(name = "has_license")
	private Boolean hasLicense = false;

	@Column(name = "license_number", length = 64)
	private String licenseNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
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
