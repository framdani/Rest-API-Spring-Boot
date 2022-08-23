package com.example.RESTfulwebservice.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringContoller {
	
	
	
	
	@GetMapping("/filtering/employer")
	public MappingJacksonValue retrieveEmployer() {
		
		Employer employer = new Employer("Bean", "60K", "Benguerir");
		
		//return only name and salary
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "salary");
		//create a filter = abstract class => addFiler(name, simpleBeamPropertyProvider)
		FilterProvider filters = new SimpleFilterProvider().addFilter("First dynamic Filter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(employer);
		//configuere the filters
		mapping.setFilters(filters);
		return mapping;
	}

}
