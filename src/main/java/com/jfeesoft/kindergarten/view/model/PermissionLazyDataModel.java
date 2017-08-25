package com.jfeesoft.kindergarten.view.model;

import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.Permission;
import com.jfeesoft.kindergarten.service.PermissionService;

@Component
public class PermissionLazyDataModel extends GenericLazyDataModel<Permission> {

	private static final long serialVersionUID = 1L;

	public PermissionLazyDataModel(PermissionService permissionService) {
		super(permissionService);
	}

}
