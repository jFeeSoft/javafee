package com.jfeesoft.kindergarten.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.kindergarten.model.City;
import com.jfeesoft.kindergarten.repository.CityRepository;
import com.jfeesoft.kindergarten.service.CityService;

@Component
@Transactional
public class CityServiceImpl extends GenericServiceImpl<City, Long> implements CityService {

	@Autowired
	public CityServiceImpl(CityRepository cityRepository) {
		super(cityRepository);

	}

}
