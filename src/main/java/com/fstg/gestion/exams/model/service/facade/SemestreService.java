package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Semestre;

public interface SemestreService {
	public Semestre findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
    public int save(Semestre semestre);
    public List<Semestre> findAll();
    public Semestre findById(Long id);
   // public List<Semestre> findByNiveauLibelle(String niveau);
}
