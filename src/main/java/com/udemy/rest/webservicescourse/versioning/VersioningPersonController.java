package com.udemy.rest.webservicescourse.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Mapashito");
	}
	
	@GetMapping(value = "/person/param", params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Mapashito");
	}
	
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Mapa", "shito"));
	}
	
	@GetMapping(value = "/person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Mapashito");
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Mapa", "shito"));
	}
	
	@GetMapping(value = "/person/produces", headers="application/vnd.company.app-v1+json")
	public PersonV1 headerProducesV1() {
		return new PersonV1("Mapashito");
	}
	
	@GetMapping(value="/person/produces", headers="application/vnd.company.app-v2+json")
	public PersonV2 headerProducesV2() {
		return new PersonV2(new Name("Mapa", "shito"));
	}

}
