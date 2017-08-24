package com.jfeesoft.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;

import com.jfeesoft.kindergarten.model.Organisation;

public interface OrganisationRepository
		extends CrudRepository<Organisation, Integer>, OrganisationRepositoryCustom<Organisation> {

}
