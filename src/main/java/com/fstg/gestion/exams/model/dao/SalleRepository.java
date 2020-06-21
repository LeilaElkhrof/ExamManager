package com.fstg.gestion.exams.model.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import com.fstg.gestion.exams.beans.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long>{

	public Salle findByDesignation(String designation);
	public List<Salle> findByCapacite(int capacite);
	@Query("SELECT salle FROM Salle salle WHERE salle.etat LIKE 'prevue'")
	public List<Salle> findEtatPrevue();
	public int deleteByDesignation(String designation);
	
	
}
