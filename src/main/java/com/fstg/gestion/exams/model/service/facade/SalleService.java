package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Salle;

public interface SalleService {
	public Salle findByDesignation(String designation);
	public List<Salle> findByCapacite(int capacite);
	public int deleteByDesignation(String designation);
	public List<Salle> findAll();
	public int save(Salle salle);
}
