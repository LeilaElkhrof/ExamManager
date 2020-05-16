package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Departement;
import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.model.dao.DepartementRepository;
import com.fstg.gestion.exams.model.service.facade.DepartementService;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;

@Service
public class DepartementServiceImpl implements DepartementService {

	@Autowired
	DepartementRepository departementDao;
	
	@Autowired
	ProfesseurService professeurService;

	@Autowired
	EtatService etatService;
	
	@Override
	public Departement findByLibelle(String libelle) {
		return departementDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {

		Etat etat = new Etat();
		Departement foundedDepart = findByLibelle(libelle);
		etat.setLibelle(foundedDepart.getLibelle());
		etat.setAction("Suppression");
		etatService.save(etat);
	return departementDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Departement depart) {
	Departement foundedDepart = findByLibelle(depart.getLibelle());
	if(foundedDepart != null) 
		return -1;
		
	else {
		departementDao.save(depart);
		return 1;
	}
	}

	@Override
	public List<Departement> findAll() {
		return departementDao.findAll();
	}

	@Override
	public Departement update(Long id,String libelle) {
		Etat modifie = new Etat();
	    Departement foundedDepart = findById(id);
		foundedDepart.setLibelle(libelle);
		 Departement updateDepart = departementDao.save(foundedDepart);
		 modifie.setLibelle(foundedDepart.getLibelle());
			modifie.setAction("Modification");
			etatService.save(modifie);
		return updateDepart;
		
	}

	@Override
	public Departement findById(Long id) {
		return departementDao.getOne(id);
	}
}
