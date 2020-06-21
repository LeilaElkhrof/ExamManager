package com.fstg.gestion.exams.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Filiere;


@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {

	public Filiere findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public List<Filiere> findByDepartementLibelle(String libelle);
}
