package com.fstg.gestion.exams.model.service.facade;

import java.util.Date;
import java.util.List;



import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSalle;

public interface ExamSalleService {
	
	public List<ExamSalle> findBySalleDesignation(String designation);
	public List<ExamSalle> findByExamReference(String reference);

	public int deleteByExamReference(String reference);

	public void saveSalle(Exam exam, List<ExamSalle> examSalles);
public List<ExamSalle> findAll();
public ExamSalle findById(Long id);
public int deleteBySalleDesignation(String designation);
public ExamSalle findBySalleDesignationAndExamDateDepartAndExamDateFin(String designation,Date dateDepart,Date dateFin);
public List<ExamSalle> findExamSalle(String designation, Date dateDepart, Date dateFin);

}
