package com.jfeesoft.kindergarten.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;

import com.jfeesoft.kindergarten.model.Organisation;
import com.jfeesoft.kindergarten.repository.OrganisationRepositoryCustom;

public class OrganisationRepositoryImpl extends GenericRepositoryImpl<Organisation>
		implements OrganisationRepositoryCustom<Organisation> {

	public OrganisationRepositoryImpl() {
		super("organisation", Organisation.class);
	}

	@Override
	void createQuery(Criteria criteria) {
		criteria.setFetchMode("address", FetchMode.JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	}

}
