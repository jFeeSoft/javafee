package com.jfeesoft.kindergarten.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.kindergarten.model.Permission;
import com.jfeesoft.kindergarten.repository.PermissionRepository;
import com.jfeesoft.kindergarten.service.PermissionService;

@Component
@Transactional
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Long> implements PermissionService {

	@Autowired
	public PermissionServiceImpl(PermissionRepository permissionRepository) {
		super(permissionRepository);

	}
}
