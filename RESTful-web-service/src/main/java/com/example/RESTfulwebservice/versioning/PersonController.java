package com.example.RESTfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	
	@GetMapping("v1/person")
	public PersonV1 pesonV1() {
		return new PersonV1("Framdani");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Fatim-zahra", "Ramdani"));
	}
	
	@GetMapping(value="person/param", params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Framdani");
	}
	
	@GetMapping(value="person/param", params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Fatim-zahra", "Ramdani"));
	}
	
	@GetMapping(value="person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Framdani");
	}
	
	@GetMapping(value="person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Fatim-zahra", "Ramdani"));
	}
	
	/*Accept header versioning */
	@GetMapping(value="person/header", produces="application/framdani.company.v2")
	public PersonV1 poducesV1() {
		return new PersonV1("Framdani");
	}
	
	@GetMapping(value="person/header", produces="application/framdani.company.v1")
	public PersonV2 poducesV2() {
		return new PersonV2(new Name("Fatim-zahra", "Ramdani"));
	}
	
}
