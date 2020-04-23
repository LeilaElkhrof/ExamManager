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

import com.fstg.gestion.exams.beans.Professeur;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;

@RestController
@RequestMapping("exam-api/professeurs")
public class ProfesseurRest {

	@Autowired
	ProfesseurService professeurService;

	@GetMapping("/find-by-cin/{cin}")
	public Professeur findByCin(@PathVariable String cin) {
		return professeurService.findByCin(cin);
	}

	@DeleteMapping("/delete-by-cin/{cin}")
	public int deleteByCin(@PathVariable String cin) {
		return professeurService.deleteByCin(cin);
	}

	@GetMapping("/find-by-departement/{libelle}")
	public List<Professeur> findByDepartementLibelle(@PathVariable String libelle) {
		return professeurService.findByDepartementLibelle(libelle);
	}

	@PostMapping("/save/")
	public int save(@RequestBody Professeur professeur) {
		return professeurService.save(professeur);
	}

	@GetMapping("/find-all/")
	public List<Professeur> findAll() {
		return professeurService.findAll();
	}

	@DeleteMapping("/delete-by-departement/{libelle}")
	public int deleteByDepartementLibelle(@PathVariable String libelle) {
		return professeurService.deleteByDepartementLibelle(libelle);
	}
	
	
}
