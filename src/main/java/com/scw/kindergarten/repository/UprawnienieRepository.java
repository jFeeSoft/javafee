package com.scw.kindergarten.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.scw.kindergarten.model.Permission;

public interface UprawnienieRepository extends CrudRepository<Permission, String>
{

}
