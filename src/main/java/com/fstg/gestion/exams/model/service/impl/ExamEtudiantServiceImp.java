package com.fstg.gestion.exams.model.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamEtudiant;
import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.model.dao.ExamEtudiantDao;
import com.fstg.gestion.exams.model.service.facade.ExamEtudiantService;
import com.fstg.gestion.exams.model.service.facade.ExamService;
import com.fstg.gestion.exams.model.service.facade.SalleService;
import com.fstg.gestion.exams.model.service.util.ExcelUtil;
import com.fstg.gestion.exams.model.service.util.PdfUtil;
import com.itextpdf.text.DocumentException;

@Service
public class ExamEtudiantServiceImp implements ExamEtudiantService {
	
	@Autowired
	private ExamEtudiantDao examEtudiantDao;
	
	@Autowired
	private ExamService examService;

	@Autowired
	private SalleService salleService;
	
	
	
	@Override
	public int save(List<ExamEtudiant> examEtudiants) {
	for(ExamEtudiant examEtudiant : examEtudiants) {
		Exam foundedExam = examService.findByDateDepartAndDateFinAndModuleLibelle(examEtudiant.getExam().getDateDepart(), examEtudiant.getExam().getDateFin(), examEtudiant.getExam().getModule().getLibelle());
		Salle foundedSalle = salleService.findByDesignation(examEtudiant.getSalle().getDesignation());
			examEtudiant.setExam(foundedExam);
			examEtudiant.setSalle(foundedSalle);
			examEtudiantDao.save(examEtudiant);		
	}

	return 1;

	}

	@Override
	public List<ExamEtudiant> findByExamId(Long exam) {
		return examEtudiantDao.findByExamIdOrderBySalleDesignation(exam);
	}
	
	@Override
	public int imprimerListeEtudiants(String module, Date dateDepart, Date dateFin) throws FileNotFoundException, DocumentException {
		Exam foundedExam = examService.findByDateDepartAndDateFinAndModuleLibelle(dateDepart, dateFin, module);
		return PdfUtil.imprimerListeEtudiants(findByExamId(foundedExam.getId()), foundedExam );
	}
	
	@Override
	public int exportExcel(String module, Date dateDepart, Date dateFin) throws DocumentException, IOException {
		Exam foundedExam = examService.findByDateDepartAndDateFinAndModuleLibelle(dateDepart, dateFin, module);
		return ExcelUtil.exportExcel(findByExamId(foundedExam.getId()), foundedExam);
	}

	@Override
	public List<ExamEtudiant> findByExamModuleLibelleAndExamDateDepartAndExamDateFin(String module, Date dateDepart,
			Date dateFin) {
		return examEtudiantDao.findByExamModuleLibelleAndExamDateDepartAndExamDateFin(module, dateDepart, dateFin);
	}
}
