package ru.inkontext.persons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/rest")
public class PersonsRestController {

	@Autowired
	private PersonService personService;

	@GetMapping("hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("param/{param}")
	public String hello(@PathVariable String param) {
		return "hello " + param;
	}
}
