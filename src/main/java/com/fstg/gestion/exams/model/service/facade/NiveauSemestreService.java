package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.NiveauSemestre;

public interface NiveauSemestreService {

	public List<NiveauSemestre> findAll();
	public List<NiveauSemestre> findByNiveauId(Long niveau);
	public List<NiveauSemestre> findByNiveauLibelle(String niveau);
	public List<NiveauSemestre> getSemestresByFiliere(String filiere);
}
