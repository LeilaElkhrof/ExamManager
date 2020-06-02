package com.fstg.gestion.exams.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.fstg.gestion.exams.beans.ExamSurve;

@Repository
public interface ExamSurveDao  extends JpaRepository<ExamSurve, Long> {
	public List<ExamSurve> findBySurveillantNom(String nom);
	public List<ExamSurve> findByExamReference(String reference);
	public int deleteBySurveillantNom(String nom);
	public int deleteByExamReference(String reference);

}
