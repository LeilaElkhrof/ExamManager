package com.fstg.gestion.exams.model.service.facade;

import java.util.Date;
import java.util.List;
import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.beans.Surveillant;

public interface SurveillantService {
	public Surveillant findById(Long id);
	public Surveillant findByNom(String nom);
	public int deleteByExam(Long exam);
	public int deleteByNom(String nom);
	public int save(Surveillant surveillant);
	public int save(ExamSalle examSalle, List<Surveillant> surveillants);
	public List<Surveillant> findByExam(Long exam);
	public List<Surveillant> findAll();
	public Surveillant update(Long id, String nom, String prenom, String mail);
	public List<Surveillant> findByExamSalleSalleDesignationAndExamSalleExamDateDepartAndExamSalleExamDateFin(String designation, Date dateDepart, Date dateFin);
	public List<Surveillant> findSurveillant(String nom, Date dateDepart, Date dateFin);
	}