package com.fstg.gestion.exams.model.service.facade;

import java.util.Date;
import java.util.List;
import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.beans.Surveillant;

public interface SurveillantService {
	public Surveillant findById(Long id);
	public Surveillant findByNom(String nom);
	public void deleteById(String nom, Date dateDepart, Date dateFin, String module);
	public int save(Surveillant surveillant);
	public void deleteByExamSalleId(Long id);
	public int save(ExamSalle examSalle, List<Surveillant> surveillants);
	public List<Surveillant> findAll();
	public Surveillant update(Long id, String nom, String prenom, String mail);
	public List<Surveillant> findByExamSalleSalleDesignationAndExamSalleExamDateDepartAndExamSalleExamDateFin(String designation, Date dateDepart, Date dateFin);
	public List<Surveillant> findSurveillant(String nom, Date dateDepart, Date dateFin);
	public List<Surveillant> findByExamModuleLibelleAndExamDateDepartAndExamDateFin(String module, Date dateDepart, Date dateFin);
	public int deleteByExam(Long id);
	public List<Surveillant> findByExamId(Long exam );
	public Surveillant findByNomAndExamDateDepartAndExamDateFinAndExamModuleLibelle(String nom, Date dateDepart, Date dateFin, String module);
	
}

