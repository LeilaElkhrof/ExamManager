package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Niveau;
import com.fstg.gestion.exams.model.dao.NiveauDao;
import com.fstg.gestion.exams.model.service.facade.NiveauService;

@Service
public class NiveauServiceImpl implements NiveauService {

	@Autowired
	NiveauDao niveauDao;
	
	@Override
	public Niveau findByLibelle(String libelle) {
		return niveauDao.findByLibelle(libelle);
	}

	@Override
	public int deleteByLibelle(String libelle) {
		return niveauDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Niveau niveau) {
		Niveau foundedNiveau = findByLibelle(niveau.getLibelle());
		
		if(foundedNiveau != null)
			return -1;
		
		else {
			niveauDao.save(niveau);
			return 1;
		}
		
	}

	@Override
	public List<Niveau> findAll() {
		return niveauDao.findAll();
	}
}
