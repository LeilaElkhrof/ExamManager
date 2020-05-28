package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.NiveauSemestre;
import com.fstg.gestion.exams.model.dao.NiveauSemestreRepository;
import com.fstg.gestion.exams.model.service.facade.FiliereService;
import com.fstg.gestion.exams.model.service.facade.NiveauSemestreService;
import com.fstg.gestion.exams.model.service.facade.NiveauService;

@Service
public class NiveauSemestreServiceImpl implements NiveauSemestreService {

	@Autowired
	NiveauSemestreRepository niveauSemestreDao;
	
	@Autowired
	NiveauService niveauService;
	
	@Autowired
	FiliereService filiereService;
	
	@Override
	public List<NiveauSemestre> findAll() {
		return niveauSemestreDao.findAll();
	}

	@Override
	public List<NiveauSemestre> findByNiveauId(Long niveau) {
		return niveauSemestreDao.findByNiveauId(niveau);
	}

	@Override
	public List<NiveauSemestre> findByNiveauLibelle(String niveau) {
		return niveauSemestreDao.findByNiveauLibelle(niveau);
	}

	@Override
	public List<NiveauSemestre> getSemestresByFiliere(String filiere) {
		Filiere foundedFiliere = filiereService.findByLibelle(filiere);
		return niveauSemestreDao.findByNiveauLibelle(foundedFiliere.getNiveau().getLibelle());
	}

}
