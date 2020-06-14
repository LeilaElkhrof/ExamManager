package com.fstg.gestion.exams.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Personnel;

@Repository
public interface PersonnelDao extends JpaRepository<Personnel,Long> {

	public int deleteByNom(String nom);
	public Personnel findByNom(String nom);
	public List<Personnel> findByFonction(String fonction);
	@Query( "SELECT p FROM Personnel p WHERE p.fonction NOT LIKE 'professeur' ")
	public List<Personnel> findFonction();

}
