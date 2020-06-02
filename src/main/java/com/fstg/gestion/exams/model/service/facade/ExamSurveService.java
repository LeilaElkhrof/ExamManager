package com.fstg.gestion.exams.model.service.facade;

import java.util.Date;
import java.util.List;



import com.fstg.gestion.exams.beans.Exam;

import com.fstg.gestion.exams.beans.ExamSurve;

public interface ExamSurveService {
	public List<ExamSurve> findBySurveillantNom(String nom);
	public List<ExamSurve> findByExamReference(String reference);
	public int deleteByExamReference(String reference);
	public void saveSurve(Exam exam, List<ExamSurve> ExamSurveillants);
	public List<ExamSurve> findAll();
	public ExamSurve findById(Long id);
	public List<ExamSurve> findExamSurveillant( String nom,Date dateDepart, Date dateFin);

	
}
