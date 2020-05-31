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
import com.fstg.gestion.exams.model.dao.PersonnelDao;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.PersonnelService;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;

@Service
public class PersonnelServiceImpl implements PersonnelService{

	@Autowired
	PersonnelDao personnelDao;
	@Autowired
	ProfesseurService professeurService;
	@Autowired
	EtatService etatService;

	@Override
	public int save(Personnel personnel) {	
			personnelDao.save(personnel);
			return 1;
		
	}
	@Override
	@Transactional
	public int deleteByNom(String nom) {
		int perso = personnelDao.deleteByNom(nom);
		int prof = professeurService.deleteByNom(nom);
		return prof+perso;
	}

	@Override
	public Personnel findByNom(String nom) {
	return personnelDao.findByNom(nom);
	}

	@Override
	public List<Personnel> findAll() {
		return personnelDao.findAll();
	}
	@Override
	public Personnel update(Long id,String nom, String prenom, String mail) {
		Etat modifie = new Etat();
	   Personnel foundedProfesseur = findById(id);
		foundedProfesseur.setNom(nom);
		foundedProfesseur.setPrenom(prenom);
		foundedProfesseur.setMail(mail);

		Personnel  updateProfesseur = personnelDao.save(foundedProfesseur);
		modifie.setLibelle(foundedProfesseur.getNom());
		modifie.setAction("Modification");
		etatService.save(modifie);
		return updateProfesseur;
	}
	@Override
	public Personnel findById(Long id) {
	return personnelDao.getOne(id);
	}

}
