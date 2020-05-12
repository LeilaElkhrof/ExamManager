package com.fstg.gestion.exams.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Surveillant;

@Repository
public interface SurveillantRepository  extends JpaRepository<Surveillant,Long>{

	public Surveillant findByNom(String nom);
	public int deleteByNom(String nom);
}
