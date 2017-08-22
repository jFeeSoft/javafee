package com.jfeesoft.kindergarten.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.kindergarten.model.Role;
import com.jfeesoft.kindergarten.repository.RoleRepository;
import com.jfeesoft.kindergarten.service.RoleService;

@Component
@Transactional
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer> implements RoleService {

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		super(roleRepository);

	}

	@Override
	public List<Role> load(int first, int pageSize, String sortField, Direction sortOrder,
			Map<String, Object> filters) {
		return ((RoleRepository) repository).findRepositorySortFilterPage(first, pageSize, sortField, sortOrder,
				filters);
	}

	@Override
	public Long countRepositoryFilter(Map<String, Object> filters) {
		return ((RoleRepository) repository).countRepositoryFilter(filters);
	}
}
