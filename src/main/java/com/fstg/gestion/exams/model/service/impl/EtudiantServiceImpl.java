package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fstg.gestion.exams.beans.Etudiant;
import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.model.dao.EtudiantRepository;
import com.fstg.gestion.exams.model.service.facade.EtudiantService;
import com.fstg.gestion.exams.model.service.facade.FiliereService;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	FiliereService filiereService;

	@Override
	public Etudiant findByCne(String cne) {
		return etudiantRepository.findByCne(cne);
	}

	@Override
	public int save(Etudiant etudiant) {
		Etudiant foundedEtudiant = findByCne(etudiant.getCne());
		Filiere foundedFiliere = filiereService.findByLibelle(etudiant.getFiliere().getLibelle());
		
		if(foundedEtudiant != null)
			return -1;
		
		if(foundedFiliere == null)
			return -2;
		
		else {
			etudiant.setFiliere(foundedFiliere);
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

}
