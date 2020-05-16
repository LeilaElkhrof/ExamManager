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

import com.fstg.gestion.exams.beans.Semestre;
import com.fstg.gestion.exams.model.service.facade.SemestreService;

@RestController
@RequestMapping("exam-api/semestre")
@CrossOrigin(origins= {"http://localhost:4200" })
public class SemestreRest {
	@Autowired
	SemestreService semestreService;

    @GetMapping("/find-by-libelle/{libelle}")
	public Semestre findByLibelle(@PathVariable String libelle) {
		return semestreService.findByLibelle(libelle);
	}

	
    @DeleteMapping("/delete-by-libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return semestreService.deleteByLibelle(libelle);
	}

    @PostMapping("/save")
	public int save(@RequestBody Semestre semestre) {
		return semestreService.save(semestre);
	}

    @GetMapping("/find-all")
	public List<Semestre> findAll() {
		return semestreService.findAll();
	}
	
	
}
