package com.fstg.gestion.exams.model.service.facade;


import java.util.Date;
import java.util.List;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Professeur;



public interface ExamService {
	public Exam findById (Long id);
	public Exam findByReference(String reference);
	public int deleteByReference(String reference);
	public List<Exam> findByModuleLibelle(String reference);
	public int save(Exam exam, List<ExamSalle> examSalles);
	public int deleteById(Long id);
	public List<Exam>findAll();
	public Exam update(Long id, String reference, Date dateDepart, Date dateFin,Module module, Professeur prof,Filiere filiere);
}
