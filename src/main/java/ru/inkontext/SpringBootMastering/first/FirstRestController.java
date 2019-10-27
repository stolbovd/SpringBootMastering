package ru.inkontext.SpringBootMastering.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.inkontext.SpringBootMastering.first.model.Person;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "rest")
public class FirstRestController {

	@GetMapping("hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("param/{param}")
	public String hello(@PathVariable String param) {
		return "hello " + param;
	}

	@PostMapping("persons")
	public List<Person> personList() {
		return new ArrayList<>();
	}
}
