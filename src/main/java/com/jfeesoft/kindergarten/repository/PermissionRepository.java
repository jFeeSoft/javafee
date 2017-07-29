package com.jfeesoft.kindergarten.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.jfeesoft.kindergarten.model.Permission;

public interface PermissionRepository extends CrudRepository<Permission, String>
{

}
