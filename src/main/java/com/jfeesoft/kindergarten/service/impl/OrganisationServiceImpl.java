package com.jfeesoft.kindergarten.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.kindergarten.model.Organisation;
import com.jfeesoft.kindergarten.repository.OrganisationRepository;
import com.jfeesoft.kindergarten.service.OrganisationService;

@Component
@Transactional
public class OrganisationServiceImpl extends GenericServiceImpl<Organisation, Long> implements OrganisationService {

	@Autowired
	public OrganisationServiceImpl(OrganisationRepository organisationRepository) {
		super(organisationRepository);

	}

}
