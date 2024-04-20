package com.rest.webservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	// filtering field2
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {

		SomeBean somebean = new SomeBean("value1", "value2", "value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(somebean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

	// filtering field2 and field3
	@GetMapping("/filtering/list")
	public MappingJacksonValue filteringList() {

		List<SomeBean> asList = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value4", "value5", "value6"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(asList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}
