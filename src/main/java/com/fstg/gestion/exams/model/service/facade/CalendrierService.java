package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Calendrier;

public interface CalendrierService {
/*
	
	public int deleteByLibelle (String libelle);
	public Calendrier findByLibelle(String libelle);
	public int save(Calendrier calendar);
	public Calendrier update(Long id, String libelle, Integer anneUniversitaire);
	public Calendrier findById(Long id);*/
	public List<Calendrier> findAll();
	public int save(Calendrier calendrier);
	
	
}
