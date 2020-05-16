package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Departement;
import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Professeur;
import com.fstg.gestion.exams.beans.Responsabilite;
import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.model.dao.ProfesseurRepository;
import com.fstg.gestion.exams.model.service.facade.DepartementService;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

	@Autowired
	ProfesseurRepository professeurRepository;
	
	@Autowired
	DepartementService departementService;
	
	@Autowired
	EtatService etatService;
	
	@Override
	@Transactional
	public int deleteByDepartementLibelle(String libelle) {

		return professeurRepository.deleteByDepartementLibelle(libelle);
	}

	@Override
	public int save(Professeur professeur) {
		Professeur foundedProfesseur = findByNom(professeur.getNom());
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

	@Override
	public Professeur findByNom(String nom) {
		
		return professeurRepository.findByNom(nom);
	}

	@Override
	public int deleteByNom(String nom) {
		Etat etat = new Etat();
		Professeur foundedProf = findByNom(nom);
		etat.setLibelle(foundedProf.getNom());
		etat.setAction("Suppression");
		etatService.save(etat);
		return professeurRepository.deleteByNom(nom);
	}

	@Override
	public Professeur update(Long id,String nom, String prenom, String mail, Responsabilite responsabilite, Departement departement) {
		Etat modifie = new Etat();
	   Professeur foundedProfesseur = findById(id);
		foundedProfesseur.setNom(nom);
		foundedProfesseur.setPrenom(prenom);
		foundedProfesseur.setMail(mail);
		foundedProfesseur.setResponsabilite(responsabilite);
		foundedProfesseur.setDepartement(departement);
		Professeur  updateProfesseur = professeurRepository.save(foundedProfesseur);
		modifie.setLibelle(foundedProfesseur.getNom());
		modifie.setAction("Modification");
		etatService.save(modifie);
		return updateProfesseur;
	}

	@Override
	public Professeur findById(Long id) {
		return professeurRepository.getOne(id);
	}

}
