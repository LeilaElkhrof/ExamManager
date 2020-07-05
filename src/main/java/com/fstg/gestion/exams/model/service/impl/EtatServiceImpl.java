package com.fstg.gestion.exams.model.service.impl;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.model.dao.EtatRepository;
import com.fstg.gestion.exams.model.service.facade.EtatService;
@Service
public class EtatServiceImpl implements EtatService {

	@Autowired
	private EtatRepository etatRepository;


	@Override
	public int save(Etat etat) {
			etat.setDateAction (new Date());
			etatRepository.save(etat);
		return 1;
	}

	@Override
	public Etat findById(Long id) {
		return etatRepository.getOne(id);
	}

	@Override
	public List<Etat> findAll() {
		return etatRepository.findAll();
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
	return etatRepository.deleteByLibelle(libelle);
	}


	@Override
	public Etat findByLibelle(String libelle) {
	return etatRepository.findByLibelle(libelle);
	}



	
}
