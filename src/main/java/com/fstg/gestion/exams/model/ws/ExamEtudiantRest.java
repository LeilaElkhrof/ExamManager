package com.fstg.gestion.exams.model.ws;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.ExamEtudiant;
import com.fstg.gestion.exams.model.service.facade.ExamEtudiantService;
import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping("exam-api/exam-etudiants")
@CrossOrigin(origins= {"http://localhost:4200" })
public class ExamEtudiantRest {

	@Autowired
	ExamEtudiantService examEtudiantService;

	@PostMapping("/save-exam-etudiant/")
	public int save(@RequestBody List<ExamEtudiant> examEtudiants) {
		return examEtudiantService.save(examEtudiants);
	}

	@GetMapping("/exam/{exam}")
	public List<ExamEtudiant> findByExamId(@PathVariable Long exam) {
		return examEtudiantService.findByExamId(exam);
	}

	@PostMapping("/imprimer/exam/{exam}")
	public int imprimerListeEtudiants(@PathVariable Long exam) throws FileNotFoundException, DocumentException {
		return examEtudiantService.imprimerListeEtudiants(exam);
	}

	@PostMapping("/export-excel/exam/{exam}")
	public int exportExcel(@PathVariable Long exam) throws DocumentException, IOException {
		return examEtudiantService.exportExcel(exam);
	}
	
	
	
	
	
	
}
