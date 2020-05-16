package com.fstg.gestion.exams.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Niveau;


@Repository
public interface NiveauDao extends JpaRepository<Niveau, Long> {

	public Niveau findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
}
