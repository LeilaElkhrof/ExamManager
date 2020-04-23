package com.fstg.gestion.exams.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.model.service.facade.SalleService;

@RestController
@RequestMapping("exam-api/salles")
public class SalleRest {

	@Autowired
	SalleService salleService;

	@GetMapping("/find-by-designation/{designation}")
	public Salle findByDesignation(@PathVariable String designation) {
		return salleService.findByDesignation(designation);
	}

	@GetMapping("/find-by-capacite/{capacite}")
	public List<Salle> findByCapacite(@PathVariable int capacite) {
		return salleService.findByCapacite(capacite);
	}

	@DeleteMapping("/delete-by-designation/{designation}")
	public int deleteByDesignation(@PathVariable String designation) {
		return salleService.deleteByDesignation(designation);
	}

	@GetMapping("/find-all/")
	public List<Salle> findAll() {
		return salleService.findAll();
	}

	@PostMapping("/save/")
	public int save(@RequestBody Salle salle) {
		return salleService.save(salle);
	}
	
	
}
