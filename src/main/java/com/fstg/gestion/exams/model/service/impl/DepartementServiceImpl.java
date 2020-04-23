package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Departement;
import com.fstg.gestion.exams.model.dao.DepartementDao;
import com.fstg.gestion.exams.model.service.facade.DepartementService;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;

@Service
public class DepartementServiceImpl implements DepartementService {

	@Autowired
	DepartementDao departementDao;
	
	@Autowired
	ProfesseurService professeurService;

	@Override
	public Departement findByLibelle(String libelle) {
		return departementDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		int nbrD = departementDao.deleteByLibelle(libelle);
		int nbrP = professeurService.deleteByDepartementLibelle(libelle);
		return nbrD + nbrP;
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
}
