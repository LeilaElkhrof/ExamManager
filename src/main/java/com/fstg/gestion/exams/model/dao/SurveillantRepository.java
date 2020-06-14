package com.fstg.gestion.exams.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Surveillant;

@Repository
public interface SurveillantRepository  extends JpaRepository<Surveillant,Long>{

	public Surveillant findByNom(String nom);
	public List<Surveillant> findByExam(Long Exam);
	public int deleteByNom(String nom);
	public List<Surveillant> findByExamSalleSalleDesignationAndExamSalleExamDateDepartAndExamSalleExamDateFin(String designation, Date dateDepart, Date dateFin);
}
