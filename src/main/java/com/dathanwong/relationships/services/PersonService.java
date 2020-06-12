package com.dathanwong.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dathanwong.relationships.models.Person;
import com.dathanwong.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository repo;
	
	public PersonService(PersonRepository repo) {
		this.repo = repo;
	}
	
	public Person createPerson(Person person) {
		return repo.save(person);
	}
	
	public List<Person> findAllPersons(){
		return repo.findAll();
	}
	
	public Person findPersonById(Long id) {
		Optional<Person> person = repo.findById(id);
		if(person.isPresent()) {
			return person.get();
		}
		return null;
	}
}
