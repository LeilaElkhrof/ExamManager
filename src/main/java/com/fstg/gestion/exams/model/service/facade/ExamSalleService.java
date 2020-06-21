package com.fstg.gestion.exams.model.service.facade;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.beans.Surveillant;

public interface ExamSalleService {
	public List<ExamSalle> findBySalleDesignation(String designation);
	public List<ExamSalle> findByExamReference(String reference);
	public ExamSalle findById(Long id);
    public ExamSalle findBySalleDesignationAndExamDateDepartAndExamDateFin(String designation,Date dateDepart,Date dateFin);
    public List<ExamSalle> findExamSalle(String designation, Date dateDepart, Date dateFin);
    public List<ExamSalle> findExamOrderBySalleDesignation(	Long id);
    public int deleteBySalleDesignationAndExamDateDepartAndExamDateFin(String designation, Date dateDepart, Date dateFin ) ;
	public int deleteByExamId(Long id);
    public void deleteById(Long id);
    public int deleteBySalleId(Long id);
	public void saveSalle(Exam exam, List<ExamSalle> examSalles);
    public List<ExamSalle> findAll();
    public List<ExamSalle> findSalleNonDisponible(String designation, Date date);
    
 

}
