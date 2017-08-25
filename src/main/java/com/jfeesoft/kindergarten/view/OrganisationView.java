package com.jfeesoft.kindergarten.view;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.Organisation;
import com.jfeesoft.kindergarten.service.OrganisationService;

@Component("organisationView")
@Scope("view")
public class OrganisationView extends GenericView<Organisation> implements Serializable {

	private static final long serialVersionUID = 1L;

	public OrganisationView(OrganisationService genericService) {
		super(genericService);
	}

	@Override
	public void add() {
		newEntity = new Organisation();
	}

}
