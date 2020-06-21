package com.fstg.gestion.exams.model.service.facade;

import java.util.List;
import com.fstg.gestion.exams.beans.Salle;
import com.itextpdf.text.DocumentException;

public interface SalleService {
	public Salle findByDesignation(String designation);
	public List<Salle> findByCapacite(int capacite);
	public int deleteByDesignation(String designation);
	public List<Salle> findAll();
	public int save(Salle salle);
	public int update(Long id,String designation, String etat, String type,int capacite);
	public Salle findById(Long id);
	public Salle findSalle(String designation);
	public List<Salle> findEtatPrevue();
	public int imprimerListeSalle() throws Exception, DocumentException;
}
