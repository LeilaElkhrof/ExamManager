package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import org.springframework.data.repository.query.Param;

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
public ExamSalle findBySalleDesignationAndExamDateDepartAndExamDateFin(String designation,String dateDepart,String dateFin);
public ExamSalle findExamSalle(@Param(value = "dateDepart") String dateDepart,@Param(value = "dateFin") String dateFin,@Param(value = "designation") String designation);

}
