package com.fstg.gestion.exams.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.fstg.gestion.exams.beans.ExamSalle;

@Repository
public interface ExamSalleDao  extends JpaRepository<ExamSalle, Long>  {

	public List<ExamSalle> findBySalleDesignation(String designation);
	public List<ExamSalle> findByExamReference(String reference);
	public ExamSalle findBySalleDesignationAndExamDateDepartAndExamDateFin(String designation,String dateDepart,String dateFin);
	public int deleteByExamReference(String reference);
	public int deleteBySalleDesignation(String designation);
	@Query("SELECT examSalle FROM ExamSalle examSalle WHERE :dateDepart BETWEEN examSalle.exam.dateDepart AND examSalle.exam.dateFin AND :dateFin BETWEEN examSalle.exam.dateDepart AND examSalle.exam.dateFin And  examSalle.salle.designation = :designation")
	public ExamSalle findExamSalle(@Param(value = "dateDepart") String dateDepart,@Param(value = "dateFin") String dateFin,@Param(value = "designation") String designation);
	

}
