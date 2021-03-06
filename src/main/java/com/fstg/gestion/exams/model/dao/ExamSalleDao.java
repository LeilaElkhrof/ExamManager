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
	public int deleteByExamId(Long id);
	public int deleteBySalleDesignationAndExamDateDepartAndExamDateFin(String designation, Date dateDepart, Date dateFin ) ;
	public int deleteBySalleId(Long id);
	
	@Query("SELECT examSalle FROM ExamSalle examSalle WHERE examSalle.exam.id = :id ORDER BY examSalle.salle.id")
	public List<ExamSalle> findExamOrderBySalleDesignation(@Param(value = "id") Long id);
	@Query("SELECT examSalle FROM ExamSalle examSalle WHERE examSalle.salle.designation = :designation AND((:dateDepart BETWEEN examSalle.exam.dateDepart AND examSalle.exam.dateFin ) OR (:dateFin BETWEEN examSalle.exam.dateDepart AND examSalle.exam.dateFin))")
	public List<ExamSalle> findExamSalle(@Param(value = "designation") String designation,@Param(value = "dateDepart")Date dateDepart,@Param(value = "dateFin") Date dateFin);
    @Query("SELECT examSalle FROM ExamSalle examSalle WHERE examSalle.salle.designation = :designation AND ((:currentDate <= examSalle.exam.dateDepart) OR (:currentDate <= examSalle.exam.dateFin))")
    public List<ExamSalle> findSalleNonDisponible(@Param(value = "designation") String designation,@Param(value = "currentDate") Date currentDate);
    public List<ExamSalle> findByExamDateDepartAndExamDateFinAndExamModuleLibelle(Date dateDepart, Date dateFin, String module);


}