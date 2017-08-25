package com.jfeesoft.kindergarten.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.kindergarten.model.Role;
import com.jfeesoft.kindergarten.repository.RoleRepository;
import com.jfeesoft.kindergarten.service.RoleService;

@Component
@Transactional
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		super(roleRepository);

	}

}
