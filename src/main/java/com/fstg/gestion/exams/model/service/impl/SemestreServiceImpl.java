package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Semestre;
import com.fstg.gestion.exams.model.dao.SemestreDao;
import com.fstg.gestion.exams.model.service.facade.SemestreService;

@Service
public class SemestreServiceImpl implements SemestreService {

	@Autowired
	SemestreDao semestreDao;
	
	@Override
	public Semestre findByLibelle(String libelle) {
		return semestreDao.findByLibelle(libelle);
	}

	@Override
	public int deleteByLibelle(String libelle) {
		return semestreDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Semestre semestre) {
		Semestre foundedSemestre = findByLibelle(semestre.getLibelle());
		
		if(foundedSemestre != null)
			return -1;
		
		else {
			semestreDao.save(semestre);
			return 1;
		}
		
	}

	@Override
	public List<Semestre> findAll() {
		return semestreDao.findAll();
	}

	@Override
	public Semestre findById(Long id) {
		return semestreDao.getOne(id);
	}
}
