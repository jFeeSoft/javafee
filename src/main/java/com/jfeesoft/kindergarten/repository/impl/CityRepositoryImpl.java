package com.jfeesoft.kindergarten.repository.impl;

import org.hibernate.Criteria;

import com.jfeesoft.kindergarten.model.City;
import com.jfeesoft.kindergarten.repository.CityRepositoryCustom;

public class CityRepositoryImpl extends GenericRepositoryImpl<City> implements CityRepositoryCustom<City> {

	public CityRepositoryImpl() {
		super("city", City.class);
	}

	@Override
	void createQuery(Criteria criteria) {
	}

}
