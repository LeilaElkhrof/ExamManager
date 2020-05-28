package com.fstg.gestion.exams.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.NiveauSemestre;
import com.fstg.gestion.exams.model.service.facade.NiveauSemestreService;

@RestController
@RequestMapping("exam-api/niveau-semestre")
@CrossOrigin(origins= {"http://localhost:4200" })
public class NiveauSemestreRest {

	@Autowired
	 NiveauSemestreService niveauSemestreService;
	 
	@GetMapping("/")
	 public List<NiveauSemestre> findAll() {
			return niveauSemestreService.findAll();
		}
	@GetMapping("/find-by-niveau/{niveau}")
	public List<NiveauSemestre> findByNiveauLibelle(@PathVariable String niveau) {
		return niveauSemestreService.findByNiveauLibelle(niveau);
	}
	@GetMapping("/find-by-filiere/{filiere}")
	public List<NiveauSemestre> getSemestresByFiliere(@PathVariable String filiere) {
		return niveauSemestreService.getSemestresByFiliere(filiere);
	}

	

}
