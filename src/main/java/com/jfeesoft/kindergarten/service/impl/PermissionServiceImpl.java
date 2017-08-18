package com.jfeesoft.kindergarten.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.kindergarten.model.Permission;
import com.jfeesoft.kindergarten.repository.PermissionRepository;
import com.jfeesoft.kindergarten.service.PermissionService;

@Component
@Transactional
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Integer> implements PermissionService {

	@Autowired
	public PermissionServiceImpl(PermissionRepository permissionRepository) {
		super(permissionRepository);

	}

	@Override
	public List<Permission> load(int first, int pageSize, String sortField, Direction sortOrder,
			Map<String, Object> filters) {
		return ((PermissionRepository) repository).findPermissionRepositorySortFilterPage(first, pageSize, sortField,
				sortOrder, filters);
	}

	@Override
	public Long countPermissionRepositoryFilter(Map<String, Object> filters) {
		return ((PermissionRepository) repository).countPermissionRepositoryFilter(filters);
	}
}
