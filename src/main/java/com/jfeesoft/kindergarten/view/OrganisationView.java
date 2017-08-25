package com.jfeesoft.kindergarten.view;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.City;
import com.jfeesoft.kindergarten.model.Organisation;
import com.jfeesoft.kindergarten.service.CityService;
import com.jfeesoft.kindergarten.service.OrganisationService;

import lombok.Getter;
import lombok.Setter;

@Component("organisationView")
@Scope("view")
public class OrganisationView extends GenericView<Organisation> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<City> cities;

	@Getter
	@Setter
	private City selectedCity;

	@Autowired
	private CityService cityService;

	public OrganisationView(OrganisationService genericService) {
		super(genericService);
	}

	@PostConstruct
	public void init() {
		cities = (List<City>) cityService.findAll();
	}

	@Override
	public void add() {
		newEntity = new Organisation();
	}

	public List<City> completeCity(String query) {
		List<City> filterdCity = cities.stream().filter(item -> item.getName().startsWith(query))
				.collect(Collectors.toList());
		return filterdCity;
	}

	public void onCitySelect(SelectEvent event) {
		City city = (City) event.getObject();
		newEntity.getAddress().setCity(city);
	}

}
