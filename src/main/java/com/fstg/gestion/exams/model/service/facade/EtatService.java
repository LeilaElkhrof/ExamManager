package com.fstg.gestion.exams.model.service.facade;

import java.util.List;


import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Salle;

public interface EtatService {

	public Etat findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Etat etat);
	public Etat findById(Long id);
	public List<Etat> findAll();
}
