package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Professeur;

public interface ProfesseurService {

	public Professeur findByCin(String cin);
	public int deleteByCin(String cin);
	public List<Professeur> findByDepartementLibelle(String libelle);
	public int deleteByDepartementLibelle(String libelle);
	public int save(Professeur professeur);
	public List<Professeur> findAll();
}
