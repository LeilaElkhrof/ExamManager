package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fstg.gestion.exams.beans.Surveillant;
import com.fstg.gestion.exams.model.dao.SurveillantRepository;
import com.fstg.gestion.exams.model.service.facade.SurveillantService;

@Service
public class SurveillantServiceImpl implements SurveillantService {

	@Autowired
	SurveillantRepository surveillantRepository;

	@Override
	public Surveillant findByNom(String nom) {
		
		return surveillantRepository.findByNom(nom);
	}

	@Override
	@Transactional
	public int deleteByNom(String nom) {
		
		return surveillantRepository.deleteByNom(nom);
	}

	@Override
	public int save(Surveillant surveillant) {
		Surveillant foundedSurveillant = findByNom(surveillant.getNom());
		if(foundedSurveillant != null) 
			return -1;
			
		else {
			surveillantRepository.save(surveillant);
			return 1;
		}
	}

	@Override
	public List<Surveillant> findAll() {
		return surveillantRepository.findAll();
	}

	@Override
	public Surveillant update(Long id, String nom, String prenom, String mail) {
		Surveillant foundedSurveillant = findById(id);
			foundedSurveillant.setNom(nom);
			foundedSurveillant.setPrenom(prenom);
			foundedSurveillant.setMail(mail);
			Surveillant  updateSurveillant = surveillantRepository.save(foundedSurveillant);
			return updateSurveillant;
	}

	@Override
	public Surveillant findById(Long id) {
	return surveillantRepository.getOne(id);
	}
}