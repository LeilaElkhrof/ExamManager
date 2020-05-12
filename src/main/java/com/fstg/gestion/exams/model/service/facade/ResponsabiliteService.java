package com.fstg.gestion.exams.model.service.facade;

import java.util.List;


import com.fstg.gestion.exams.beans.Responsabilite;


public interface ResponsabiliteService {
	public Responsabilite findById(Long id);
	public Responsabilite findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Responsabilite respo);
	public List<Responsabilite> findAll();
	public Responsabilite update(Long id, String libelle);
}
