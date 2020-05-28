package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;

public interface FiliereService {

	public Filiere findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Filiere filiere);
	public int saveFM(Filiere filiere, List<Module> modules);
	public List<Filiere> findAll();
	public int update(Long id, String libelle, String niveau, String departement);
	public Filiere findById(Long id);
}
