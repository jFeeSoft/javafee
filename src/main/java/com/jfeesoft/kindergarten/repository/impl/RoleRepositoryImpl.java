package com.jfeesoft.kindergarten.repository.impl;

import com.jfeesoft.kindergarten.model.Role;
import com.jfeesoft.kindergarten.repository.RoleRepositoryCustom;

public class RoleRepositoryImpl extends GenericRepositoryImpl<Role> implements RoleRepositoryCustom<Role> {

	public RoleRepositoryImpl() {
		super("role", Role.class);
	}

}
