package com.fstg.gestion.exams.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Surveillant;

@Repository
public interface SurveillantRepository  extends JpaRepository<Surveillant,Long>{

	public Surveillant findByNom(String nom);
	public int deleteByExam(Long exam);
	public List<Surveillant> findByExamSalleSalleDesignationAndExamSalleExamDateDepartAndExamSalleExamDateFin(String designation, Date dateDepart, Date dateFin);
	@Query("SELECT surveillant FROM Surveillant surveillant WHERE surveillant.nom = :nom AND((:dateDepart BETWEEN surveillant.examSalle.exam.dateDepart AND surveillant.examSalle.exam.dateFin) OR (:dateFin BETWEEN surveillant.examSalle.exam.dateDepart AND surveillant.examSalle.exam.dateFin))")
    public List<Surveillant> findSurveillant(@Param(value = "nom") String nom,@Param(value = "dateDepart")Date dateDepart,@Param(value = "dateFin") Date dateFin);
	public List<Surveillant> findByExamModuleLibelleAndExamDateDepartAndExamDateFin(String module, Date dateDepart, Date dateFin);
	public List<Surveillant> findByExamId(Long exam);
	public Surveillant findByNomAndExamDateDepartAndExamDateFinAndExamModuleLibelle(String nom, Date dateDepart, Date dateFin, String module);
	}
