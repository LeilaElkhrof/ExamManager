package com.fstg.gestion.exams.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/find-all")
	public List<Calendrier> findAll() {
		return calendrierService.findAll();
	}
	
	@GetMapping("/{start}/{end}/{title}")
	public Calendrier findByStartAndEndAndTitle(@PathVariable String start,@PathVariable String end,@PathVariable String title) {
		return calendrierService.findByStartAndEndAndTitle(start, end, title);
	}

	@GetMapping("/filiere/departement/{libelle}")
	public List<Calendrier> findByFiliereDepartementLibelle(@PathVariable String libelle) {
 return calendrierService.findByFiliereDepartementLibelle(libelle);
	}
}
