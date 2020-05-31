package com.fstg.gestion.exams.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Personnel;

@Repository
public interface PersonnelDao extends JpaRepository<Personnel,Long> {

	public int deleteByNom(String nom);
	public Personnel findByNom(String nom);

}
