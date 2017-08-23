package com.jfeesoft.kindergarten.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;

import com.jfeesoft.kindergarten.model.Role;
import com.jfeesoft.kindergarten.repository.RoleRepositoryCustom;

public class RoleRepositoryImpl extends GenericRepositoryImpl<Role> implements RoleRepositoryCustom<Role> {

	public RoleRepositoryImpl() {
		super("role", Role.class);
	}

	@Override
	void createQuery(Criteria criteria) {
		criteria.setFetchMode("permissions", FetchMode.JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	}

}
