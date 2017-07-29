package com.scw.kindergarten.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scw.kindergarten.model.SystemUser;

@Repository
public interface UzytkownikRepository extends CrudRepository<SystemUser, String> {
	@Query(value = "SELECT user FROM Uzytkownik user LEFT JOIN FETCH user.rola rola LEFT JOIN FETCH rola.uprawnienie WHERE user.email = :email ")
	SystemUser findByEmail(@Param("email") String email);
}
