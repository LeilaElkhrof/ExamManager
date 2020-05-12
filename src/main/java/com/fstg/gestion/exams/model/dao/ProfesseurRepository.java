package com.fstg.gestion.exams.model.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Professeur;


@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {

	public Professeur findByNom(String nom);

	public int deleteByNom(String nom);
	public int deleteByDepartementLibelle(String libelle);
}
