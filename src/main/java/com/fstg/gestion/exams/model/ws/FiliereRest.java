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

import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.model.service.facade.FiliereService;

@RestController
@RequestMapping("exam-api/filieres")
@CrossOrigin(origins= {"http://localhost:4200" })
public class FiliereRest {
	
	
	@PostMapping("/saveFM")
	public int saveFM(@RequestBody Filiere filiere) {
		return filiereService.saveFM(filiere, filiere.getModules());
	}

	@Autowired
	FiliereService filiereService;

	@GetMapping("/find-by-libelle/{libelle}")
	public Filiere findByLibelle(@PathVariable String libelle) {
		return filiereService.findByLibelle(libelle);
	}

	@DeleteMapping("/delete-by-libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return filiereService.deleteByLibelle(libelle);
	}

	@PostMapping("/save/")
	public int save(@RequestBody Filiere filiere) {
		return filiereService.save(filiere);
	}

	@GetMapping("/find-all")
	public List<Filiere> findAll() {
		return filiereService.findAll();
	}

	@PutMapping("id/{id}/libelle/{libelle}/niveau/{niveau}")
	public int update(@PathVariable Long id, @PathVariable String libelle,@PathVariable String niveau) {
		return filiereService.update(id, libelle, niveau);
	}

}
