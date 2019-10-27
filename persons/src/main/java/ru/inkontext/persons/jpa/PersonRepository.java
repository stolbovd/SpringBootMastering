package ru.inkontext.persons.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inkontext.persons.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
