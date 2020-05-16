package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Niveau;
import com.fstg.gestion.exams.model.dao.FiliereRepository;
import com.fstg.gestion.exams.model.service.facade.EtudiantService;
import com.fstg.gestion.exams.model.service.facade.FiliereService;
import com.fstg.gestion.exams.model.service.facade.ModuleService;
import com.fstg.gestion.exams.model.service.facade.NiveauService;

@Service
public class FiliereServiceImpl implements FiliereService {

	@Autowired
	FiliereRepository filiereRepository;
	
	@Autowired
	EtudiantService etudiantService;
	
	@Autowired
	ModuleService moduleService;
	
	@Autowired
	NiveauService niveauService;
	
	
	@Override
	public Filiere findByLibelle(String libelle) {
		return filiereRepository.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		int nbrM = moduleService.deleteByFiliereLibelle(libelle);
		int nbrF = filiereRepository.deleteByLibelle(libelle);
		return nbrF + nbrM;
	}

	@Override
	public int save(Filiere filiere) {
		Filiere foundedFiliere = findByLibelle(filiere.getLibelle());
		Niveau foundedNiveau = niveauService.findByLibelle(filiere.getNiveau().getLibelle());
		if(foundedFiliere != null)
			return -1;
		
		else {
			filiere.setNiveau(foundedNiveau);
			filiereRepository.save(filiere);
			return 1;
		}
		
	}

	@Override
	public int saveFM(Filiere filiere, List<Module> modules) {
		Filiere foundedFiliere = findByLibelle(filiere.getLibelle());
		Niveau foundedNiveau = niveauService.findByLibelle(filiere.getNiveau().getLibelle());
		
		if(foundedFiliere != null)
			return -1;
		
		else {
			filiere.setNiveau(foundedNiveau);
			filiereRepository.save(filiere);
			moduleService.save(filiere, modules);
			return 1;
		}
		
	}
	@Override
	public List<Filiere> findAll() {
		return filiereRepository.findAll();
	}
	
	public int update(Long id, String libelle, String niveau) {
	Filiere foundedFiliere= findById(id);
	Niveau fondedNiveau = niveauService.findByLibelle(niveau);
	if(foundedFiliere == null) 
		return -1;
	else {
		foundedFiliere.setLibelle(libelle);
		foundedFiliere.setNiveau(fondedNiveau);
		filiereRepository.save(foundedFiliere);
		return 1;
	}
	}

	@Override
	public Filiere findById(Long id) {
		return filiereRepository.getOne(id);
	}

}
