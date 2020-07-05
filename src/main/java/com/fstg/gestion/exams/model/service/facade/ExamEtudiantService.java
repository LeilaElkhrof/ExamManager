package com.fstg.gestion.exams.model.service.facade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.fstg.gestion.exams.beans.ExamEtudiant;
import com.itextpdf.text.DocumentException;


public interface ExamEtudiantService {

	public int save(List<ExamEtudiant> examEtudiants);
	public List<ExamEtudiant> findByExamId(Long exam);
	public int imprimerListeEtudiants(String module, Date dateDepart, Date dateDebut) throws FileNotFoundException, DocumentException;
	public int exportExcel(String module, Date dateDepart, Date dateDebut) throws DocumentException, IOException;
	public List<ExamEtudiant> findByExamModuleLibelleAndExamDateDepartAndExamDateFin(String module, Date dateDepart, Date dateFin);
}
