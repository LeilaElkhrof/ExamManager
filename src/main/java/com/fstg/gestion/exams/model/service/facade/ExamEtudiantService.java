package com.fstg.gestion.exams.model.service.facade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.fstg.gestion.exams.beans.ExamEtudiant;
import com.itextpdf.text.DocumentException;


public interface ExamEtudiantService {

	public int save(List<ExamEtudiant> examEtudiants);
	public List<ExamEtudiant> findByExamId(Long exam);
	public int imprimerListeEtudiants(Long exam) throws FileNotFoundException, DocumentException;
	public int exportExcel(Long exam) throws DocumentException, IOException;
}
