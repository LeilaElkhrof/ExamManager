package com.fstg.gestion.exams.model.service.facade;

import java.util.Date;
import java.util.List;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Professeur;
import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.beans.Surveillant;

public interface ExamService {

	
	public Exam findById (Long id);
	public Exam findByReference(String reference);
	public int deleteByReference(String reference);
	public List<Exam> findByModuleLibelle(String reference);
	public List<Exam> findByDate(Date date);
	public int save(Exam exam);
	public List<Exam>findAll();
	public Exam update(Long id, String reference,Date date, String heureDepart, String heureFin,Module module, Professeur prof, List<Surveillant> surveillants, List<Salle> salles);
}
