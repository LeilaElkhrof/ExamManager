package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.model.dao.ModuleRepository;
import com.fstg.gestion.exams.model.service.facade.FiliereService;
import com.fstg.gestion.exams.model.service.facade.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	FiliereService filiereService;
	
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
			if(foundedModule == null) {
				module.setFiliere(filiere);
				moduleRepository.save(module);
			}	
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
		
		if(foundedModule != null)
			return -1;
		
		if(foundedFiliere == null)
			return -2;
		
		else {
			module.setFiliere(foundedFiliere);
			moduleRepository.save(module);
			return 1;
		}
		
	}

}
