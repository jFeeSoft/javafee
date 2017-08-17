package com.jfeesoft.kindergarten.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort.Direction;

import com.jfeesoft.kindergarten.model.Permission;

public interface PermissionService extends GenericService<Permission, Integer> {
	List<Permission> load(int first, int pageSize, String sortField, Direction sortOrder, Map<String, Object> filters);

	Long countPermissionRepositoryFilter(Map<String, Object> filters);
}
