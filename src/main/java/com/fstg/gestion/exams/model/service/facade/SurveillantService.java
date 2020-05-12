package com.fstg.gestion.exams.model.service.facade;

import java.util.List;


import com.fstg.gestion.exams.beans.Surveillant;

public interface SurveillantService {
	public Surveillant findById(Long id);
	public Surveillant findByNom(String nom);
	public int deleteByNom(String nom);
	public int save(Surveillant surveillant);
	public List<Surveillant> findAll();
	public Surveillant update(Long id, String nom, String prenom, String mail);
}
