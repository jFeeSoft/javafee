package com.jfeesoft.kindergarten.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort.Direction;

import com.jfeesoft.kindergarten.model.Organisation;

public interface OrganisationService extends GenericService<Organisation, Integer> {
	List<Organisation> load(int first, int pageSize, String sortField, Direction sortOrder,
			Map<String, Object> filters);

	Long countRepositoryFilter(Map<String, Object> filters);
}
