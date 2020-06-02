package com.fstg.gestion.exams.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.fstg.gestion.exams.beans.ExamSurve;

@Repository
public interface ExamSurveDao  extends JpaRepository<ExamSurve, Long> {
	public List<ExamSurve> findBySurveillantNom(String nom);
	public List<ExamSurve> findByExamReference(String reference);
	public int deleteBySurveillantNom(String nom);
	public int deleteByExamReference(String reference);
	@Query("SELECT examSurve FROM ExamSurve examSurve WHERE examSurve.surveillant.nom = :nom AND((:dateDepart BETWEEN examSurve.exam.dateDepart AND examSurve.exam.dateFin ) OR (:dateFin BETWEEN examSurve.exam.dateDepart AND examSurve.exam.dateFin))")
	public List<ExamSurve> findExamSurveillant(@Param(value = "nom") String nom,@Param(value = "dateDepart")Date dateDepart,@Param(value = "dateFin") Date dateFin);


}
