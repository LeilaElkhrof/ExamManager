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

import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.model.service.facade.EtatService;

@RestController
@RequestMapping("exam-api/etat" )
@CrossOrigin(origins= {"http://localhost:4200" })
public class EtatRest {

	@Autowired 
	EtatService etatService;

	@GetMapping("/find-by-designation/{designation}")
	public Etat findByDesignation(@PathVariable String designation) {
		return etatService.findByDesignation(designation);
	}

	@DeleteMapping("/delete-by-designation/{designation}")
	public int deleteByDesignation(@PathVariable String designation) {
		return etatService.deleteByDesignation(designation);
	}

	@PostMapping("/save")
	public int save(@RequestBody Etat etat) {
		return etatService.save(etat);
	}

	@GetMapping("/findAll")
	public List<Etat> findAll() {
		return etatService.findAll();
	}

	@DeleteMapping("/{designation}")
	public int recupere(@PathVariable String designation, Salle salle) {
		return etatService.recupere(designation, salle);
	}
}
