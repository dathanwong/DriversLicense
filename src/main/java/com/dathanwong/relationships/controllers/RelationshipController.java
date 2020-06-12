package com.dathanwong.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dathanwong.relationships.models.License;
import com.dathanwong.relationships.models.Person;
import com.dathanwong.relationships.services.LicenseService;
import com.dathanwong.relationships.services.PersonService;

@Controller
public class RelationshipController {
	
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public RelationshipController(PersonService ps, LicenseService ls) {
		this.personService = ps;
		this.licenseService = ls;
	}
	
	@RequestMapping("/persons/new")
	public String newPersonPage(@ModelAttribute("person") Person person) {
		return "newPersonPage.jsp";
	}
	
	@PostMapping("/persons")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newPersonPage.jsp";
		}else {
			personService.createPerson(person);
			System.out.println("Created person successfully");
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping("/licenses/new")
	public String newLicensesPage(Model model, @ModelAttribute("license") License license) {
		List<Person> people = personService.findAllPersons();
		model.addAttribute("persons", people);
		return "newLicensePage.jsp";
	}
	
	@PostMapping("/licenses")
	public String createLicense(@ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newLicensePage.jsp";
		}else {
			licenseService.createLicense(license);
			return "redirect:/persons/" + license.getPerson().getId();
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String personsPage(@PathVariable("id") Long id, Model model) {
		Person person = personService.findPersonById(id);
		License license = person.getLicense();
		model.addAttribute("person", person);
		model.addAttribute("license", license);
		return "person.jsp";
	}
}
