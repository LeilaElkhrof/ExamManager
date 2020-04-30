package com.fstg.gestion.exams.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.model.dao.SalleRepository;
import com.fstg.gestion.exams.model.service.facade.SalleService;



@RestController
@RequestMapping(value="exam-api/salles", method=RequestMethod.POST )
@CrossOrigin(origins= {"http://localhost:4200" })
public class SalleRest {

	@Autowired
	SalleService salleService;
	
	@Autowired
	SalleRepository salleRepository;

	@GetMapping("/find-by-designation/{designation}")
	public Salle findByDesignation(@PathVariable String designation) {
		return salleService.findByDesignation(designation);
	}

	@GetMapping("/find-by-capacite/{capacite}")
	public List<Salle> findByCapacite(@PathVariable int capacite) {
		return salleService.findByCapacite(capacite);
	}

	@GetMapping("/find-by-id/{id}")
	public Salle findById(@PathVariable Long id) {
		return salleService.findById(id);
	}
	
	
	@DeleteMapping("/delete-by-designation/{designation}")
	public int deleteByDesignation(@PathVariable String designation) {
		return salleService.deleteByDesignation(designation);
	}
	
	@GetMapping("/")
	public List<Salle> findAll() {
		return salleService.findAll();
	}
	
	@PostMapping("/")
	public int save(@RequestBody Salle salle) {
		return salleService.save(salle);
	}
	
	@PutMapping("/{designation}/{etat}/{type}/{capacite}")
	public Salle update(@PathVariable String designation,@PathVariable  String etat, @PathVariable String type,@PathVariable int capacite) {
		return salleService.update(designation,etat, type, capacite);
	}
}
