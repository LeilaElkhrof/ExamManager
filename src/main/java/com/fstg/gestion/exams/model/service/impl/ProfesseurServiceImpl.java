package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Departement;
import com.fstg.gestion.exams.beans.Professeur;
import com.fstg.gestion.exams.model.dao.ProfesseurRepository;
import com.fstg.gestion.exams.model.service.facade.DepartementService;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

	@Autowired
	ProfesseurRepository professeurRepository;
	
	@Autowired
	DepartementService departementService;
	
	@Override
	public Professeur findByCin(String cin) {
		return professeurRepository.findByCin(cin);
	}

	@Override
	@Transactional
	public int deleteByCin(String cin) {
		return professeurRepository.deleteByCin(cin);
	}

	@Override
	public List<Professeur> findByDepartementLibelle(String libelle) {
		return professeurRepository.findByDepartementLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByDepartementLibelle(String libelle) {
		return professeurRepository.deleteByDepartementLibelle(libelle);
	}

	@Override
	public int save(Professeur professeur) {
		Professeur foundedProfesseur = findByCin(professeur.getCin());
		Departement foundedDepartement = departementService.findByLibelle(professeur.getDepartement().getLibelle());
		
		if(foundedProfesseur != null)
			return -1;
		if(foundedDepartement == null)
			return -2;
		else {
			professeur.setDepartement(foundedDepartement);
			professeurRepository.save(professeur);
		}
		return 0;
	}

	@Override
	public List<Professeur> findAll() {
		return professeurRepository.findAll();
	}

}
