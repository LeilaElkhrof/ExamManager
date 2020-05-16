package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Niveau;

public interface NiveauService {

	public Niveau findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
    public int save(Niveau niveau);
    public List<Niveau> findAll();
}
