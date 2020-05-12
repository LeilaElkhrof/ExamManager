package com.fstg.gestion.exams.model.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.model.dao.EtatRepository;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.SalleService;

@Service
public class EtatServiceImpl implements EtatService {

	@Autowired
	private EtatRepository etatRepository;
	
	@Autowired
	private SalleService salleService;


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
	public int deleteByDesignation(String designation) {
	return etatRepository.deleteByDesignation(designation);
	}

	@Override
	@Transactional
	public int recupere(String designation, Salle salle) {
		
		Etat foundedEtat = findByDesignation(designation);
		salle.setCapacite(foundedEtat.getCapacite());
		salle.setDesignation(foundedEtat.getDesignation());
		salle.setEtat(foundedEtat.getEtat());
		salle.setType(foundedEtat.getType());
		salleService.save(salle);
		return deleteByDesignation(designation);
	}

	@Override
	public Etat findByDesignation(String designation) {
	return etatRepository.findByDesignation(designation);
	}



	
}
