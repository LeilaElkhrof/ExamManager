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
import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.Calendrier;
import com.fstg.gestion.exams.model.service.facade.CalendrierService;

@RestController
@RequestMapping("exam-api/calendar" )
@CrossOrigin(origins= {"http://localhost:4200" })
public class CalendrierRest {

	@Autowired 
	CalendrierService calendrierService;
/*

	@DeleteMapping("/delete-by-libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return calendrierService.deleteByLibelle(libelle);
	}

	@GetMapping("/find-by-libelle/{libelle}")
	public Calendrier findByLibelle(@PathVariable String libelle) {
		return calendrierService.findByLibelle(libelle);
	}
	
	@PostMapping("/save")
	public int save(@RequestBody Calendrier calendar) {
		return calendrierService.save(calendar);
	}

	@PutMapping("/{id}/{libelle}/{anneUniversitaire}")
	public Calendrier update(@PathVariable Long id, @PathVariable String libelle,@PathVariable Integer anneUniversitaire) {
		return calendrierService.update(id, libelle, anneUniversitaire);
	}

	@GetMapping("/find-by-id/{id}")
	public Calendrier findById(@PathVariable Long id) {
		return calendrierService.findById(id);
	}

	*/
	@GetMapping("/find-all")
	public List<Calendrier> findAll() {
		return calendrierService.findAll();
	}

	
}
