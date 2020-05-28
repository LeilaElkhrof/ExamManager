package com.fstg.gestion.exams.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Semestre;


@Repository
public interface SemestreDao extends JpaRepository<Semestre, Long> {

	public Semestre findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	
}
