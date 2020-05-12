package com.fstg.gestion.exams.model.service.facade;

import java.util.List;


import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Salle;

public interface EtatService {

	public Etat findByDesignation(String designation);
	public int deleteByDesignation(String designation);
	public int save(Etat etat);
	public Etat findById(Long id);
	public List<Etat> findAll();
	public int recupere(String designation, Salle salle);
}
