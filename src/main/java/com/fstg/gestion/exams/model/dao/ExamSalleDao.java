package com.fstg.gestion.exams.model.dao;

import java.util.Date;
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
	public ExamSalle findBySalleDesignationAndExamDateDepartAndExamDateFin(String designation,Date dateDepart,Date dateFin);
	public int deleteByExamReference(String reference);
	public int deleteBySalleDesignation(String designation);
	@Query("SELECT examSalle FROM ExamSalle examSalle WHERE examSalle.salle.designation = :designation AND((:dateDepart BETWEEN examSalle.exam.dateDepart AND examSalle.exam.dateFin ) OR (:dateFin BETWEEN examSalle.exam.dateDepart AND examSalle.exam.dateFin))")
<<<<<<< HEAD
	public List<ExamSalle> findExamSalle(@Param(value = "designation") String designation,@Param(value = "dateDepart")Date dateDepart,@Param(value = "dateFin") Date dateFin);
}
=======
	public ExamSalle findExamSalle(@Param(value = "designation") String designation,@Param(value = "dateDepart")Date dateDepart,@Param(value = "dateFin") Date dateFin);
}
>>>>>>> branch 'master' of https://github.com/LeilaElkhrof/ExamManager.git
