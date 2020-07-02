package com.fstg.gestion.exams.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.ExamEtudiant;

@Repository
public interface ExamEtudiantDao extends JpaRepository<ExamEtudiant, Long>{

	public List<ExamEtudiant> findByExamIdOrderBySalleDesignation(Long exam);
}
