package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.beans.Semestre;
import com.fstg.gestion.exams.model.dao.SalleRepository;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.SalleService;

@Service
public class SalleServiceImpl implements SalleService {

	@Autowired
	SalleRepository salleRepository;
	
	@Autowired
	EtatService etatService;
	
	
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
		Etat etat = new Etat();
		Salle foundedSalle = findByDesignation(designation);
		if(foundedSalle.getDisponibilite() == false)
			return -1;
		else {
		etat.setLibelle(foundedSalle.getDesignation());
		etat.setAction("Suppression");
		etatService.save(etat);
		return salleRepository.deleteByDesignation(designation);
		}
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
			salle.setDisponibilite(true);
			salleRepository.save(salle);
			return 0;
		}
		
	}
	

	@Override
    public Salle update(Long id,String designation, String etat, String type,int capacite) {
		Etat modifie = new Etat();
        Salle foundedSalle = findById(id);
	foundedSalle.setCapacite(capacite);
	foundedSalle.setDesignation(designation);
	foundedSalle.setEtat(etat);
	foundedSalle.setType(type);
	 Salle updateSalle = salleRepository.save(foundedSalle);
		modifie.setLibelle(foundedSalle.getDesignation());
		modifie.setAction("Modification");
		etatService.save(modifie);
	return updateSalle;
	}

	@Override
	public Salle findById(Long id) {
		return salleRepository.getOne(id);
	}

	@Override
	public Salle findSalle(String designation) {
		return  salleRepository.findByDesignation(designation);
	}

	@Override
	public List<Salle> findEtatPrevue() {
	return salleRepository.findEtatPrevue();	}
}
