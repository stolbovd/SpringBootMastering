package ru.inkontext.persons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Service;
import ru.inkontext.persons.jpa.PersonRepository;

@Service
@Slf4j
public class PersonService extends AbstractRepositoryEventListener {

	@Autowired
	PersonRepository personRepository;

}
