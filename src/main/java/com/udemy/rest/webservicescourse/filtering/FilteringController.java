package com.udemy.rest.webservicescourse.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

  // field 1 and 2
  @GetMapping("/filtering")
  public MappingJacksonValue retrieveSomeBean() {
    SomeBean someBean = new SomeBean("value1", "valaue2", "val3");
    MappingJacksonValue mapping = new MappingJacksonValue(someBean);
    SimpleBeanPropertyFilter filter =
        SimpleBeanPropertyFilter.filterOutAllExcept("value1", "valaue2");
    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
    mapping.setFilters(filters);
    return mapping;
  }

  // field 1 and 3
  @GetMapping("/filteringList")
  public MappingJacksonValue retrieveSomeBeanList() {
    List<SomeBean> someBeans =
        Arrays.asList(new SomeBean("value1", "valaue2", "val3"), new SomeBean("aaa", "sss", "ddd"));
    SomeBean someBean = new SomeBean("value1", "valaue2", "val3");
    MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
    SimpleBeanPropertyFilter filter =
        SimpleBeanPropertyFilter.filterOutAllExcept("val3", "valaue2");
    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
    mapping.setFilters(filters);
    return mapping;
  }
}
