package com.jfeesoft.kindergarten.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.kindergarten.model.Organisation;
import com.jfeesoft.kindergarten.repository.OrganisationRepository;
import com.jfeesoft.kindergarten.service.OrganisationService;

@Component
@Transactional
public class OrganisationServiceImpl extends GenericServiceImpl<Organisation, Integer> implements OrganisationService {

	@Autowired
	public OrganisationServiceImpl(OrganisationRepository organisationRepository) {
		super(organisationRepository);

	}

	@Override
	public List<Organisation> load(int first, int pageSize, String sortField, Direction sortOrder,
			Map<String, Object> filters) {
		return ((OrganisationRepository) repository).findRepositorySortFilterPage(first, pageSize, sortField, sortOrder,
				filters);
	}

	@Override
	public Long countRepositoryFilter(Map<String, Object> filters) {
		return ((OrganisationRepository) repository).countRepositoryFilter(filters);
	}
}
