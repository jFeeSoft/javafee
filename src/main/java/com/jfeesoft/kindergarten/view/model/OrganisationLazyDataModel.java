package com.jfeesoft.kindergarten.view.model;

import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.Organisation;
import com.jfeesoft.kindergarten.service.OrganisationService;

@Component
public class OrganisationLazyDataModel extends GenericLazyDataModel<Organisation> {

	private static final long serialVersionUID = 1L;

	public OrganisationLazyDataModel(OrganisationService organisationService) {
		super(organisationService);
	}

}
