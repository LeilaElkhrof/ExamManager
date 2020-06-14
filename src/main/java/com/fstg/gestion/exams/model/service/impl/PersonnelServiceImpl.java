package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Personnel;
import com.fstg.gestion.exams.beans.Professeur;
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
		Personnel foundedPersonnel = findByNom(personnel.getNom());
		if(foundedPersonnel != null) {
			return -1;
		}else {
			personnelDao.save(personnel);
			return 1;
		}	
		
	}
	@Override
	@Transactional
	public int deleteByNom(String nom) {
		Professeur foundProf= professeurService.findByNom(nom);

		
		if(foundProf == null) {	
		int perso = personnelDao.deleteByNom(nom);
			return perso;
		}
		else {
			int prof = professeurService.deleteByNom(nom);
			int perso = personnelDao.deleteByNom(nom);
				return prof+perso;
		}
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
	public Personnel update(Long id,String nom, String prenom, String mail, String fonction) {
		Etat modifie = new Etat();
	   Personnel foundedPersonnel = findById(id);
		foundedPersonnel.setNom(nom);
		foundedPersonnel.setPrenom(prenom);
		foundedPersonnel.setMail(mail);
		foundedPersonnel.setFonction(fonction);

		Personnel  updatePersonnel = personnelDao.save(foundedPersonnel);
		modifie.setLibelle(foundedPersonnel.getNom());
		modifie.setAction("Modification");
		etatService.save(modifie);
		return updatePersonnel;
	}
	@Override
	public Personnel findById(Long id) {
	return personnelDao.getOne(id);
	}
	@Override
	public List<Personnel> findByFonction(String fonction) {
		return personnelDao.findByFonction(fonction);
	}
	@Override
	public List<Personnel> findFonction() {
		return personnelDao.findFonction();
	}

}
