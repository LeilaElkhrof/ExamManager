package com.fstg.gestion.exams.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.NiveauSemestre;
@Repository
public interface NiveauSemestreRepository extends JpaRepository<NiveauSemestre, Long> {

	public List<NiveauSemestre> findByNiveauLibelle(String niveau);
	public List<NiveauSemestre> findByNiveauId(Long id);
}
