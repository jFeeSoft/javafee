package com.jfeesoft.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;

import com.jfeesoft.kindergarten.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>, RoleRepositoryCustom<Role> {

}
