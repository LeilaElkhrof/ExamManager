package com.fstg.gestion.exams.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.Niveau;
import com.fstg.gestion.exams.model.service.facade.NiveauService;

@RestController
@RequestMapping("exam-api/niveaux")
@CrossOrigin(origins= {"http://localhost:4200" })
public class NiveauRest {
	@Autowired
	NiveauService niveauService;

    @GetMapping("/find-by-libelle/{libelle}")
	public Niveau findByLibelle(@PathVariable String libelle) {
		return niveauService.findByLibelle(libelle);
	}

	
    @DeleteMapping("/delete-by-libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return niveauService.deleteByLibelle(libelle);
	}

    @PostMapping("/save")
	public int save(@RequestBody Niveau niveau) {
		return niveauService.save(niveau);
	}

    @GetMapping("/find-all")
	public List<Niveau> findAll() {
		return niveauService.findAll();
	}
	
}
