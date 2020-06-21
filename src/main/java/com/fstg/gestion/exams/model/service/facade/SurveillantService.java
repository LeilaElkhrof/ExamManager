package com.fstg.gestion.exams.model.service.facade;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.beans.Personnel;
import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.beans.Surveillant;

public interface SurveillantService {
	public Surveillant findById(Long id);
	
	public Surveillant findByNom(String nom);
	public int deleteByNom(String nom);
	public int save(ExamSalle examSalle, List<Surveillant> surveillants);
	public List<Surveillant> findByExam(Long Exam);
	//public int saveSurveillant(Exam exam, List<Surveillant> surveillants);
	public List<Surveillant> findAll();
	public Surveillant update(Long id, String nom, String prenom, String mail);
	//public void saveExamSurve(List<Surveillant> surveillants, Exam exam);
	public List<Surveillant> findByExamSalleSalleDesignationAndExamSalleExamDateDepartAndExamSalleExamDateFin(String designation, Date dateDepart, Date dateFin);
}
