package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.Salle;

public interface SalleService {
	public Salle findByDesignation(String designation);
	public List<Salle> findByCapacite(int capacite);
	public int deleteByDesignation(String designation);
	public List<Salle> findAll();
	public int save(Salle salle);
	public Salle update(Long id,String designation, String etat, String type,int capacite);
	public Salle findById(Long id);
	//public ResponseEntity<Salle> update (String designation,  Salle salle);
	public Salle findSalle(String designation);
	//public void saveExamSalle(List<Salle> salles, Exam exam);
}
