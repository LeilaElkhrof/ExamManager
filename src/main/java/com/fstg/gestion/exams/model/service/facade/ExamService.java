package com.fstg.gestion.exams.model.service.facade;


import java.util.List;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.beans.ExamSurve;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Professeur;



public interface ExamService {
	public Exam findById (Long id);
	public Exam findByReference(String reference);
	public int deleteByReference(String reference);
	public List<Exam> findByModuleLibelle(String reference);
	public int save(Exam exam, List<ExamSurve> ExamSurveillants, List<ExamSalle> examSalles);
	//public Exam findByDateDepartAndDateFin(String dateDebut, String dateFin);

	public List<Exam>findAll();
	public Exam update(Long id, String reference, String dateDepart, String dateFin,Module module, Professeur prof);
}
