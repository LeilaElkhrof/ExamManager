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

import com.fstg.gestion.exams.beans.Departement;
import com.fstg.gestion.exams.model.service.facade.DepartementService;

@RestController
@RequestMapping("exam-api/departements")
@CrossOrigin(origins= {"http://localhost:4200" })
public class DepartementRest {
	
	@Autowired
	DepartementService departementService;

	@GetMapping("/find-by-libelle/{libelle}")
	public Departement findByLibelle( @PathVariable String libelle) {
		return departementService.findByLibelle(libelle);
	}

	@DeleteMapping("/delete-by-libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return departementService.deleteByLibelle(libelle);
	}

	@PostMapping("/save")
	public int save(@RequestBody Departement depart) {
		return departementService.save(depart);
	}

	@GetMapping("/find-all")
	public List<Departement> findAll() {
		return departementService.findAll();
	}
	
	@PutMapping("/{id}/{libelle}")
	public Departement update(@PathVariable Long id,@PathVariable String libelle) {
		return departementService.update(id,libelle);
	}

}
