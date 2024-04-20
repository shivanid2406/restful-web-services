package com.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	// URI Versioning for version1
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionofPerson() {
		return new PersonV1("Bob Charlie");
	}

	// URI Versioning for version2
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionofPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// Request Parameter for version 1
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionofPersonRequestParam() {
		return new PersonV1("Bob Charlie");
	}

	// Request Parameter for version 2
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionofPersonRequestParam() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// Header Mapping for version 1
	@GetMapping(path = "/person/headers", headers = "X-API-version=1")
	public PersonV1 getFirstVersionofPersonHeader() {
		return new PersonV1("Bob Charlie");
	}

	// Request Parameter for version 2
	@GetMapping(path = "/person/headers", headers = "X-API-version=2")
	public PersonV2 getSecondVersionofPersonHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

}
