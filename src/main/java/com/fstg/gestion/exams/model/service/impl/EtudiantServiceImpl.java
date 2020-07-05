package com.fstg.gestion.exams.model.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Etudiant;
import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Semestre;
import com.fstg.gestion.exams.model.dao.EtudiantRepository;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.EtudiantService;
import com.fstg.gestion.exams.model.service.facade.FiliereService;
import com.fstg.gestion.exams.model.service.facade.ModuleService;
import com.fstg.gestion.exams.model.service.facade.SemestreService;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	FiliereService filiereService;
	
	@Autowired
	ModuleService moduleService;
	
	@Autowired
	SemestreService semestreService;
	
	@Autowired
    EtatService etatService;	

	@Override
	public Etudiant findByCne(String cne) {
		return etudiantRepository.findByCne(cne);
	}

	@Override
	public int save(Etudiant etudiant) {
		Etudiant foundedEtudiant = findByCne(etudiant.getCne());
		Filiere foundedFiliere = filiereService.findByLibelle(etudiant.getFiliere().getLibelle());
		Semestre foundedSemestre = semestreService.findByLibelle(etudiant.getSemestre().getLibelle());
		
		if(foundedEtudiant != null)
			return -1;
		
		if(foundedFiliere == null)
			return -2;
		
		if(foundedSemestre == null)
			return -3;
		
		else {
			etudiant.setFiliere(foundedFiliere);
			etudiant.setSemestre(foundedSemestre);
			etudiantRepository.save(etudiant);
			return 1;
		}
		
	}

	@Override
	public List<Etudiant> findAll() {
		return etudiantRepository.findAll();
	}

	@Override
	@Transactional
	public int deleteByCne(String cne) {
		Etat etat = new Etat();
Etudiant foundedEtudiant = findByCne(cne);
		etat.setLibelle(foundedEtudiant.getCne());
		etat.setAction("Suppression");
		etat.setType("Etudiant");
		etatService.save(etat);
		return etudiantRepository.deleteByCne(cne);
	}

	@Override
	public List<Etudiant> findByFiliereLibelle(String libelle) {
		return etudiantRepository.findByFiliereLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByFiliereLibelle(String libelle) {
		return etudiantRepository.deleteByFiliereLibelle(libelle);
	}

	@Override
	public int update(Long id, String nom, String prenom,String cne, String mail, String filiere, Long semestre ) {
		Etat modifie = new Etat();
		Etudiant foundedEtudiant = etudiantRepository.getOne(id);
		Filiere foundedFiliere = filiereService.findByLibelle(filiere);
	    Semestre foundedSemestre = semestreService.findById(semestre);
	    
	    foundedEtudiant.setCne(cne);
	    foundedEtudiant.setNom(nom);
	    foundedEtudiant.setPrenom(prenom);
	    foundedEtudiant.setMail(mail);
	    foundedEtudiant.setSemestre(foundedSemestre);
	    foundedEtudiant.setFiliere(foundedFiliere);
	    modifie.setDateAction(new Date());
	    modifie.setLibelle(foundedEtudiant.getNom());
	    modifie.setAction("modification");
	    modifie.setType("Etudiant");
	    etatService.save(modifie);
	    etudiantRepository.save(foundedEtudiant);
		return 1;
	}

	@Override
	public List<Etudiant> findByFiliereLibelleAndModuleSemestreLibelle(String filiere, String module) {
		Module foundedModule = moduleService.findByLibelle(module);
		return etudiantRepository.findByFiliereLibelleAndSemestreLibelle(filiere, foundedModule.getSemestre().getLibelle());
	}


}
