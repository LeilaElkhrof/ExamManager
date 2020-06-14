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
import com.fstg.gestion.exams.beans.Professeur;
import com.fstg.gestion.exams.beans.Responsabilite;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;

@RestController
@RequestMapping("exam-api/professeurs" )
@CrossOrigin(origins= {"http://localhost:4200" })
public class ProfesseurRest {

	@Autowired
	ProfesseurService professeurService;

	@GetMapping("/find-by-departement/{libelle}")
	public List<Professeur> findByDepartementLibelle(@PathVariable String libelle) {
		return professeurService.findByDepartementLibelle(libelle);
	}

	@GetMapping("/find-by-nom/{nom}")
	public Professeur findByNom(@PathVariable String nom) {
		return professeurService.findByNom(nom);
	}

	@DeleteMapping("/delete-by-nom/{nom}")
	public int deleteByNom(@PathVariable String nom) {
		return professeurService.deleteByNom(nom);
	}

	@PostMapping("/save")
	public int save(@RequestBody Professeur professeur) {
		return professeurService.save(professeur);
	}

	@GetMapping("/find-all")
	public List<Professeur> findAll() {
		return professeurService.findAll();
	}

	@DeleteMapping("/delete-by-departement/{libelle}")
	public int deleteByDepartementLibelle(@PathVariable String libelle) {
		return professeurService.deleteByDepartementLibelle(libelle);
	}
	@PutMapping("/{id}/{nom}/{prenom}/{mail}/{responsabilite}/{departement}")
	public Professeur update(@PathVariable Long id,@PathVariable String nom,@PathVariable String prenom,@PathVariable String mail,@PathVariable String responsabilite,@PathVariable String departement ) {
		return professeurService.update(id,nom, prenom, mail, responsabilite,departement);
	}
	
}
