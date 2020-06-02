package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Professeur;
import com.fstg.gestion.exams.beans.Semestre;
import com.fstg.gestion.exams.model.dao.ModuleRepository;
import com.fstg.gestion.exams.model.service.facade.FiliereService;
import com.fstg.gestion.exams.model.service.facade.ModuleService;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;
import com.fstg.gestion.exams.model.service.facade.SemestreService;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	FiliereService filiereService;
	
	@Autowired
	SemestreService semestreService;
	@Autowired
	ProfesseurService profService;
	
	@Override
	public Module findByLibelle(String libelle) {
		return moduleRepository.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return moduleRepository.deleteByLibelle(libelle);
	}

	@Override
	public List<Module> findByFiliereLibelle(String libelle) {
		return moduleRepository.findByFiliereLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByFiliereLibelle(String libelle) {
		return moduleRepository.deleteByFiliereLibelle(libelle);
	}

	@Override
	public void save(Filiere filiere, List<Module> modules) {
		for(Module module : modules) {
			Module foundedModule = findByLibelle(module.getLibelle());
			Semestre foundedSemestre = semestreService.findByLibelle(module.getSemestre().getLibelle());
			Professeur foundedProfesseur = profService.findByNom(module.getProfesseur().getNom());
			
			module.setProfesseur(foundedProfesseur);
				module.setFiliere(filiere);
				module.setSemestre(foundedSemestre);
				moduleRepository.save(module);
				
		}
	}

	@Override
	public List<Module> findAll() {
		return moduleRepository.findAll();
	}

	@Override
	public int addModule(Module module) {
		Module foundedModule = findByLibelle(module.getLibelle());
		Filiere foundedFiliere = filiereService.findByLibelle(module.getFiliere().getLibelle());
		Semestre foundedSemestre = semestreService.findByLibelle(module.getSemestre().getLibelle());
		
		if(foundedFiliere == null)
			return -2;
		
		else {
			module.setFiliere(foundedFiliere);
			module.setSemestre(foundedSemestre);
			moduleRepository.save(module);
			return 1;
		}
		
	}

	@Override
	public int updateModule(Long id, String libelle, String semestre, Professeur professeur) {
		Module foundedModule = moduleRepository.getOne(id);
		Semestre foundedSemestre = semestreService.findByLibelle(semestre);
		Professeur foundedProfesseur = profService.findByNom(professeur.getNom());
		
		if(foundedModule == null)
			return -1;
		else {
			foundedModule.setLibelle(libelle);
			foundedModule.setSemestre(foundedSemestre);
			foundedModule.setProfesseur(foundedProfesseur);
		    foundedModule.setFiliere(foundedModule.getFiliere());
			moduleRepository.save(foundedModule);
			return 1;
		}
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		 moduleRepository.deleteById(id);
	}

}
