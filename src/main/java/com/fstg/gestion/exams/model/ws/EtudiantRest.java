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

import com.fstg.gestion.exams.beans.Etudiant;
import com.fstg.gestion.exams.model.service.facade.EtudiantService;

@RestController
@RequestMapping("exam-api/etudiants")
@CrossOrigin(origins= {"http://localhost:4200" })
public class EtudiantRest {


	@GetMapping("/find-by-filiere/{libelle}")
	public List<Etudiant> findByFiliereLibelle(@PathVariable String libelle) {
		return etudiantService.findByFiliereLibelle(libelle);
	}
	@GetMapping("/filiere/departement/{libelle}")
	public List<Etudiant> findByFiliereDepartementLibelle(@PathVariable String libelle) {
		return etudiantService.findByFiliereDepartementLibelle(libelle);
	}

	@Autowired
	EtudiantService etudiantService;

	@GetMapping("/find-by-cne/{cne}")
	public Etudiant findByCne(@PathVariable String cne) {
		return etudiantService.findByCne(cne);
	}

	@PostMapping("/save/")
	public int save(@RequestBody Etudiant etudiant) {
		return etudiantService.save(etudiant);
	}

	@GetMapping("/find-all/")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}

	@DeleteMapping("/delete-by-cne/{cne}")
	public int deleteByCne(@PathVariable String cne) {
		return etudiantService.deleteByCne(cne);
	}

	@DeleteMapping("/delete-by-filiere/{libelle}")
	public int deleteByFiliereLibelle(@PathVariable String libelle) {
		return etudiantService.deleteByFiliereLibelle(libelle);
	}
	
	@PutMapping("/{id}/{nom}/{prenom}/{cne}/{mail}/{filiere}/{semestre}")
	public int update(@PathVariable Long id,@PathVariable String nom,@PathVariable String prenom,@PathVariable String cne,@PathVariable String mail,@PathVariable String filiere,@PathVariable Long semestre) {
		return etudiantService.update(id, nom, prenom, cne, mail, filiere, semestre);
	}


	@GetMapping("/filiere/{filiere}/semestre/{semestre}")
	public List<Etudiant> findByFiliereLibelleAndModuleSemestreLibelle(@PathVariable String filiere, @PathVariable String semestre) {
		return etudiantService.findByFiliereLibelleAndModuleSemestreLibelle(filiere, semestre);
	}
	
	
	
}
