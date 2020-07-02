package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Calendrier;
import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.model.dao.CalendrierRepository;
import com.fstg.gestion.exams.model.service.facade.CalendrierService;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.ExamService;
import com.fstg.gestion.exams.model.service.facade.FiliereService;

@Service
public class CalendrierServiceImpl implements CalendrierService {

	@Autowired
	CalendrierRepository calendrierRepository;
	/*
	@Autowired
	EtatService etatService;

	@Autowired
	ExamService examService; 
	
	@Autowired
	FiliereService filiereService;
	


	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		int nbrC = calendrierRepository.deleteByLibelle(libelle);
		Etat etat = new Etat();
		Calendrier foundedCalendar = findByLibelle(libelle);
		etat.setLibelle(foundedCalendar.getLibelle());
		etat.setAction("Suppression");
		etatService.save(etat);
		return nbrC;
	}

	@Override
	public Calendrier findByLibelle(String libelle) {
		return calendrierRepository.findByLibelle(libelle);
	}

	@Override
	public int save(Calendrier calendar) {
		
	Calendrier foundedCalendar = findByLibelle(calendar.getLibelle());	
		Filiere foundedFiliere = filiereService.findByLibelle(calendar.getFilieres().getLibelle());
		
		if(foundedFiliere == null)
			return -1;
		
		if(foundedCalendar != null)
			return -5;
		
		else {
			calendar.setFilieres(foundedFiliere);
			calendrierRepository.save(calendar);
			return 1;
	}
	}

	@Override
	public Calendrier update(Long id, String libelle, Integer anneUniversitaire) {
		Etat modifie = new Etat();
		   Calendrier foundedCalendrier = findById(id);
		   foundedCalendrier.setLibelle(libelle);
		   foundedCalendrier.setAnneUniversitaire(anneUniversitaire);
			Calendrier  updateCalendrier = calendrierRepository.save( foundedCalendrier);
			modifie.setLibelle( foundedCalendrier.getLibelle());
			modifie.setAction("Modification");
			etatService.save(modifie);
			return updateCalendrier;
	}*/

	@Override
	public List<Calendrier> findAll() {
	return calendrierRepository.findAll();
	}
/*
	@Override
	public Calendrier findById(Long id) {
		return calendrierRepository.getOne(id);
	}
*/

	@Override
	public int save(Calendrier calendrier) {
		calendrierRepository.save(calendrier);
		return 1;
	}
	
}
