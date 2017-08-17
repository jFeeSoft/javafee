package com.jfeesoft.kindergarten.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort.Direction;

import com.jfeesoft.kindergarten.model.Permission;

public interface PermissionRepositoryCustom {
	public Long countPermissionRepositoryFilter(Map<String, Object> filters);

	public List<Permission> findPermissionRepositorySortFilterPage(int first, int pageSize, String sortField,
			Direction sortOrder, Map<String, Object> filters);
}
