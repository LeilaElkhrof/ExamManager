package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Departement;
import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Personnel;
import com.fstg.gestion.exams.beans.Professeur;
import com.fstg.gestion.exams.beans.Responsabilite;

import com.fstg.gestion.exams.model.dao.ProfesseurRepository;
import com.fstg.gestion.exams.model.service.facade.DepartementService;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.PersonnelService;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;
import com.fstg.gestion.exams.model.service.facade.ResponsabiliteService;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

	@Autowired
	ProfesseurRepository professeurRepository;
	
	@Autowired
	DepartementService departementService;
	
	@Autowired
	EtatService etatService;
	
	@Autowired
	PersonnelService personnelService;
	
	@Autowired
	ResponsabiliteService responsabiliteService;
	
	
	
	@Override
	@Transactional
	public int deleteByDepartementLibelle(String libelle) {

		return professeurRepository.deleteByDepartementLibelle(libelle);
	}

	@Override
	public int save(Professeur professeur) {
		Etat etat = new Etat();
		Personnel personnel = new Personnel();
		Professeur foundedProfesseur = findByNom(professeur.getNom());
		Departement foundedDepartement = departementService.findByLibelle(professeur.getDepartement().getLibelle());
		
		if(foundedProfesseur != null)
			return -1;
		if(foundedDepartement == null)
			return -2;
		else {
			
			professeur.setDepartement(foundedDepartement);
			personnel.setMail(professeur.getMail());
			personnel.setNom(professeur.getNom());
			personnel.setPrenom(professeur.getPrenom());
			personnel.setFonction("professeur");
			etat.setLibelle(professeur.getNom());
			etat.setAction("Insertion");
			etat.setType("Professeur");
			etatService.save(etat);	
			personnelService.save(personnel);
			professeurRepository.save(professeur);
		}
		return 1;
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
	@Transactional
	public int deleteByNom(String nom) {
		Etat etat = new Etat();
		Professeur foundedProf = findByNom(nom);
		etat.setLibelle(foundedProf.getNom());
		etat.setAction("Suppression");
		etat.setType("Professeur");
		etatService.save(etat);
		return professeurRepository.deleteByNom(nom);
	}

	@Override
	public Professeur update(Long id,String nom, String prenom, String mail, String responsabilite, String departement) {
		Etat modifie = new Etat();
	   Professeur foundedProfesseur = findById(id);
	   Responsabilite foundedResponsabilite = responsabiliteService.findByLibelle(responsabilite);
	   Departement foundedDepartement = departementService.findByLibelle(departement);
		foundedProfesseur.setNom(nom);
		foundedProfesseur.setPrenom(prenom);
		foundedProfesseur.setMail(mail);
		foundedProfesseur.setResponsabilite(foundedResponsabilite);
		foundedProfesseur.setDepartement(foundedDepartement);
		Professeur  updateProfesseur = professeurRepository.save(foundedProfesseur);
		modifie.setLibelle(foundedProfesseur.getNom());
		modifie.setAction("Modification");
		modifie.setType("Professeur");
		etatService.save(modifie);
		return updateProfesseur;
	}

	@Override
	public Professeur findById(Long id) {
		return professeurRepository.getOne(id);
	}

	@Override
	public List<Professeur> findByDepartementLibelle(String libelle) {
		return professeurRepository.findByDepartementLibelle(libelle);
	}

}
