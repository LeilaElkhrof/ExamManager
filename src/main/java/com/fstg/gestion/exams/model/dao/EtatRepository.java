package com.fstg.gestion.exams.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Etat;



@Repository
public interface EtatRepository extends JpaRepository<Etat,Long>{

	public int deleteByDesignation(String designation);
	public Etat findByDesignation(String designation);
}
