package com.fstg.gestion.exams.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fstg.gestion.exams.beans.ExamSurve;
import com.fstg.gestion.exams.model.service.facade.ExamSurveService;
import com.fstg.gestion.exams.model.service.util.DateUtil;


@RestController
@RequestMapping("exam-api/exams-surve")
@CrossOrigin(origins= {"http://localhost:4200" })
public class ExamSurveRest {

	@Autowired
	ExamSurveService examSurveService;

	@GetMapping("/surveillant/find-by-reference/{reference}")
	public List<ExamSurve> findBySurveillantNom(@PathVariable String nom) {
		return examSurveService.findBySurveillantNom(nom);
	}

	@GetMapping("/exam/find-by-reference/{reference}")
	public List<ExamSurve> findByExamReference(@PathVariable String reference) {
		return examSurveService.findByExamReference(reference);
	}



	@DeleteMapping("/exam/delete-by-reference/{reference}")
	public int deleteByExamReference(@PathVariable String reference) {
		return examSurveService.deleteByExamReference(reference);
	}



	@GetMapping("/find-all")
	public List<ExamSurve> findAll() {
		return examSurveService.findAll();
	}
	@GetMapping("/find-by-id/{id}")
	public ExamSurve findById(@PathVariable Long id) {
		return examSurveService.findById(id);
	}

	@GetMapping("/nom/{nom}/dateDepart/{dateDepart}/dateFin/{dateFin}")
	public List<ExamSurve> findExamSurveillant(@PathVariable String nom,@PathVariable String dateDepart,@PathVariable String dateFin) {
		System.out.println("dateDepart "+dateDepart);
		return examSurveService.findExamSurveillant(nom ,DateUtil.parse(dateDepart), DateUtil.parse(dateFin));
	}
	
	
}
