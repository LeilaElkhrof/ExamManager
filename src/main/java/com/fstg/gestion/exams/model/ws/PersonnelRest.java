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


import com.fstg.gestion.exams.beans.Personnel;

import com.fstg.gestion.exams.model.service.facade.PersonnelService;

@RestController
@RequestMapping("exam-api/personnels" )
@CrossOrigin(origins= {"http://localhost:4200" })
public class PersonnelRest {

	 @Autowired
	 PersonnelService personnelService;

	 @PostMapping("/save")
	public int save(@RequestBody Personnel personnel) {
		return personnelService.save(personnel);
	}

	 @DeleteMapping("/delete-by-nom/{nom}")
	public int deleteByNom(@PathVariable String nom) {
		return personnelService.deleteByNom(nom);
	}

	@GetMapping("/find-by-nom/{nom}")
	public Personnel findByNom(@PathVariable String nom) {
		return personnelService.findByNom(nom);
	}

	@GetMapping("/find-all")
	public List<Personnel> findAll() {
		return personnelService.findAll();
	}
	@PutMapping("/{id}/{nom}/{prenom}/{mail}")
	public Personnel update(@PathVariable Long id,@PathVariable String nom,@PathVariable String prenom,@PathVariable String mail ) {
		return personnelService.update(id,nom, prenom, mail);
	}
	 
	 
}
