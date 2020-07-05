package com.fstg.gestion.exams.model.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
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
		Exam foundedExam = examService.findById(examEtudiant.getExam().getId());
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
	public int imprimerListeEtudiants(Long exam) throws FileNotFoundException, DocumentException {
		return PdfUtil.imprimerListeEtudiants(findByExamId(exam), examService.findById(exam) );
	}
	
	@Override
	public int exportExcel(Long exam) throws DocumentException, IOException {
		return ExcelUtil.exportExcel(findByExamId(exam), examService.findById(exam) );
	}
}
