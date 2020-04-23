package com.fstg.gestion.exams.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Filiere;


@Repository
public interface FiliereRepository extends JpaRepository<Filiere, String> {

	public Filiere findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
}
