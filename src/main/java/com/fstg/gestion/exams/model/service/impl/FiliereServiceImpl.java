package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.model.dao.FiliereRepository;
import com.fstg.gestion.exams.model.service.facade.EtudiantService;
import com.fstg.gestion.exams.model.service.facade.FiliereService;
import com.fstg.gestion.exams.model.service.facade.ModuleService;

@Service
public class FiliereServiceImpl implements FiliereService {

	@Autowired
	FiliereRepository filiereRepository;
	
	@Autowired
	EtudiantService etudiantService;
	
	@Autowired
	ModuleService moduleService;
	
	
	@Override
	public Filiere findByLibelle(String libelle) {
		return filiereRepository.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		int nbrE = etudiantService.deleteByFiliereLibelle(libelle);
		int nbrM = moduleService.deleteByFiliereLibelle(libelle);
		int nbrF = filiereRepository.deleteByLibelle(libelle);
		return nbrE + nbrF + nbrM;
	}

	@Override
	public int save(Filiere filiere, List<Module> modules) {
		Filiere foundedFiliere = findByLibelle(filiere.getLibelle());
		
		if(foundedFiliere != null)
			return -1;
		
		else {
			filiereRepository.save(filiere);
			moduleService.save(filiere, modules);
			return 1;
		}
		
	}

	@Override
	public List<Filiere> findAll() {
		return filiereRepository.findAll();
	}

}
