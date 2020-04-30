package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.model.dao.SalleRepository;
import com.fstg.gestion.exams.model.service.facade.SalleService;

@Service
public class SalleServiceImpl implements SalleService {

	@Autowired
	SalleRepository salleRepository;
	
	@Override
	public Salle findByDesignation(String designation) {
		return salleRepository.findByDesignation(designation);
	}

	@Override
	public List<Salle> findByCapacite(int capacite) {
		return salleRepository.findByCapacite(capacite);
	}

	@Override
	@Transactional
	public int deleteByDesignation(String designation) {
		return salleRepository.deleteByDesignation(designation);
	}

	@Override
	public List<Salle> findAll() {
		return salleRepository.findAll();
	}

	@Override
	public int save(Salle salle) {
		Salle foundedSalle = findByDesignation(salle.getDesignation());
		
		if(foundedSalle != null)
			return -1;
		
		else {
			salleRepository.save(salle);
			return 0;
		}
		
	}
	

	@Override
	public Salle update(String designation, String etat, String type,int capacite ) {
    Salle foundedSalle = findByDesignation(designation);
	foundedSalle.setCapacite(capacite);
	foundedSalle.setDesignation(designation);
	foundedSalle.setEtat(etat);
	foundedSalle.setType(type);
	 Salle updateSalle = salleRepository.save(foundedSalle);
	return updateSalle;
	
	}

	@Override
	public Salle findById(Long id) {
		return salleRepository.getOne(id);
	}


}
