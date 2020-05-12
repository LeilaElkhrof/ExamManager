package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Departement;
import com.fstg.gestion.exams.beans.Professeur;
import com.fstg.gestion.exams.beans.Responsabilite;


public interface ProfesseurService {
	public Professeur findById(Long id);
	public Professeur findByNom(String nom);
	public int deleteByNom(String nom);
	public int deleteByDepartementLibelle(String libelle);
	public int save(Professeur professeur);
	public List<Professeur> findAll();
	public Professeur update(Long id,String nom, String prenom, String mail, Responsabilite responsabilite, Departement departement);
}
