package com.jfeesoft.kindergarten.view.model;

import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.Role;
import com.jfeesoft.kindergarten.service.RoleService;

@Component
public class RoleLazyDataModel extends GenericLazyDataModel<Role> {

	private static final long serialVersionUID = 1L;

	public RoleLazyDataModel(RoleService roleService) {
		super(roleService);
	}

}
