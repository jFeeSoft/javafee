package com.jfeesoft.kindergarten.repository.impl;

import com.jfeesoft.kindergarten.model.Permission;
import com.jfeesoft.kindergarten.repository.PermissionRepositoryCustom;

public class PermissionRepositoryImpl extends GenericRepositoryImpl<Permission>
		implements PermissionRepositoryCustom<Permission> {

	public PermissionRepositoryImpl() {
		super("permission", Permission.class);
	}

}
