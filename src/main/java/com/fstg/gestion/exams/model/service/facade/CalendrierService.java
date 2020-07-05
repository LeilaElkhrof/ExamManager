package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Calendrier;

public interface CalendrierService {
	
	public List<Calendrier> findAll();
	public int save(Calendrier calendrier);

	 public List<Calendrier> findByFiliereDepartementLibelle(String libelle);

	public Calendrier findByStartAndEndAndTitle(String start, String end, String title);

	
	
}
