package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Departement;
import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Niveau;

import com.fstg.gestion.exams.model.dao.FiliereRepository;
import com.fstg.gestion.exams.model.service.facade.DepartementService;
import com.fstg.gestion.exams.model.service.facade.EtatService;
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
	
	@Autowired
	DepartementService departementService;
	
	@Autowired
	EtatService etatService;
	
	
	@Override
	public Filiere findByLibelle(String libelle) {
		return filiereRepository.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		Etat etat = new Etat();
		Filiere foundedFiliere = findByLibelle(libelle);
		
		
		etat.setLibelle(foundedFiliere.getLibelle());
		etat.setAction("Suppression");
		etat.setType("Filiere");
		etatService.save(etat);
		int nbrM = moduleService.deleteByFiliereLibelle(libelle);
		int nbrF = filiereRepository.deleteByLibelle(libelle);
		return nbrF + nbrM;
	}

	@Override
	public int save(Filiere filiere) {
		Filiere foundedFiliere = findByLibelle(filiere.getLibelle());
		Niveau foundedNiveau = niveauService.findById(filiere.getNiveau().getId());
		Departement foundedDepartement = departementService.findByLibelle(filiere.getDepartement().getLibelle());
		if(foundedFiliere != null)
			return -1;
		
		else {
			filiere.setNiveau(foundedNiveau);
			filiere.setDepartement(foundedDepartement);
			filiereRepository.save(filiere);
			return 1;
		}
		
	}

	@Override
	public int saveFM(Filiere filiere, List<Module> modules) {
		Filiere foundedFiliere = findByLibelle(filiere.getLibelle());
		Niveau foundedNiveau = niveauService.findByLibelle(filiere.getNiveau().getLibelle());
		System.out.println(foundedNiveau);
		Departement foundedDepartement = departementService.findByLibelle(filiere.getDepartement().getLibelle());
		
		if(foundedFiliere != null)
			return -1;
		
		else {
			filiere.setNiveau(foundedNiveau);
			filiere.setDepartement(foundedDepartement);
			filiereRepository.save(filiere);
			moduleService.save(filiere, modules);
			return 1;
		}
		
	}
	@Override
	public List<Filiere> findAll() {
		return filiereRepository.findAll();
	}
	
	public int update(Long id, String libelle, String niveau, String departement) {
		Etat modifie = new Etat();
	Filiere foundedFiliere= findById(id);
	
    Departement foundedDepartement = departementService.findByLibelle(departement);
	if(foundedFiliere == null) 
		return -1;
	else {
		foundedFiliere.setLibelle(libelle);
		foundedFiliere.setDepartement(foundedDepartement);
		modifie.setLibelle(foundedFiliere.getLibelle());
		modifie.setAction("Modification");
		modifie.setType("Filiere");
		etatService.save(modifie);
		//foundedFiliere.setNiveau(fondedNiveau);
		filiereRepository.save(foundedFiliere);
		return 1;
	}
	}

	@Override
	public Filiere findById(Long id) {
		return filiereRepository.getOne(id);
	}

	@Override
	public List<Filiere> findByDepartementLibelle(String libelle) {
	return filiereRepository.findByDepartementLibelle(libelle);
	}

}
