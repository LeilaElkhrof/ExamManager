package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Responsabilite;

import com.fstg.gestion.exams.model.dao.ResponsabiliteRepository;
import com.fstg.gestion.exams.model.service.facade.ResponsabiliteService;

@Service
public class ResponsabiliteServiceImpl implements ResponsabiliteService {

	@Autowired
	ResponsabiliteRepository respoRepository;

	@Override
	public Responsabilite findByLibelle(String libelle) {
		return respoRepository.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return respoRepository.deleteByLibelle(libelle);
	}

	@Override
	public int save(Responsabilite respo) {
		Responsabilite foundedRespo = findByLibelle(respo.getLibelle());
		if(foundedRespo != null) 
			return -1;
			
		else {
			respoRepository.save(respo);
			return 1;
		}
	}

	@Override
	public List<Responsabilite> findAll() {
		return respoRepository.findAll();
	}

	@Override
	public Responsabilite update(Long id,String libelle) {
	    Responsabilite foundedResponsabilite = findById(id);
		foundedResponsabilite.setLibelle(libelle);
		Responsabilite updateResponsabilite = respoRepository.save(foundedResponsabilite);
		return updateResponsabilite;
		
	}

	@Override
	public Responsabilite findById(Long id) {
		return respoRepository.getOne(id);
	}
}
