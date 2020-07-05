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
import com.fstg.gestion.exams.model.service.util.DateUtil;
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

	@PostMapping("/imprimer/module/{module}/date-depart/{dateDepart}/date-fin/{dateFin}")
	public int imprimerListeEtudiants(@PathVariable String module,@PathVariable String dateDepart,@PathVariable String dateFin) throws FileNotFoundException, DocumentException {
		return examEtudiantService.imprimerListeEtudiants(module, DateUtil.parse(dateDepart), DateUtil.parse(dateFin));
	}

	@PostMapping("/export-excel/module/{module}/date-depart/{dateDepart}/date-fin/{dateFin}")
	public int exportExcel(@PathVariable String module,@PathVariable String dateDepart,@PathVariable String dateFin) throws DocumentException, IOException {
		return examEtudiantService.exportExcel( module, DateUtil.parse(dateDepart), DateUtil.parse(dateFin));
	}
	
	@GetMapping("/module/{module}/dateDepart/{dateDepart}/dateFin/{dateFin}")
	public List<ExamEtudiant> findByExamModuleLibelleAndExamDateDepartAndExamDateFin(@PathVariable String module,@PathVariable String dateDepart,
			@PathVariable String dateFin) {

		return examEtudiantService.findByExamModuleLibelleAndExamDateDepartAndExamDateFin(module, DateUtil.parse(dateDepart), DateUtil.parse(dateFin));
	}
	
	
	
	
}
