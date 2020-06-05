package com.fstg.gestion.exams.model.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSurve;
import com.fstg.gestion.exams.beans.Personnel;

import com.fstg.gestion.exams.model.dao.ExamSurveDao;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.ExamService;
import com.fstg.gestion.exams.model.service.facade.ExamSurveService;
import com.fstg.gestion.exams.model.service.facade.PersonnelService;
import com.fstg.gestion.exams.model.service.facade.SurveillantService;

@Service
public class ExamSurveServiceImpl implements ExamSurveService {

	@Autowired
	ExamSurveDao examSurveDao;
	
	@Autowired
	ExamService examService;
	
	@Autowired
	SurveillantService surveService;
	
	@Autowired 
	PersonnelService personnelService;
	@Autowired
	EtatService etatService;
	
	



	@Override
	public List<ExamSurve> findByExamReference(String reference) {
		return examSurveDao.findByExamReference(reference);
	}


	@Override
	@Transactional
	public int deleteByExamId(Long id) {
	return examSurveDao.deleteByExamId(id);
	}


	@Override
	public void saveSurve(Exam exam, List<ExamSurve> examSurveillants) {
		    
			for(ExamSurve valideExamSurve : examSurveillants) {
				Personnel foundPerso = personnelService.findByNom(valideExamSurve.getSurveillant().getNom());
				valideExamSurve.setExam(exam);
				valideExamSurve.setSurveillant(foundPerso);
				examSurveDao.save(valideExamSurve);
			}
		
	}

	@Override
	public List<ExamSurve> findAll() {
	return examSurveDao.findAll();
	}

	@Override
	public ExamSurve findById(Long id) {
	return examSurveDao.getOne(id);
	}


	@Override
	public List<ExamSurve> findBySurveillantNom(String nom) {
	return examSurveDao.findBySurveillantNom(nom);
	}


	@Override
	public List<ExamSurve> findExamSurveillant(String nom, Date dateDepart, Date dateFin) {
		return examSurveDao.findExamSurveillant(nom, dateDepart, dateFin);
	}


	@Override
	public void deleteById(Long id) {
		Etat etat = new Etat();
	
		ExamSurve foundedExamSurve = findById(id);
		
		
		etat.setLibelle(foundedExamSurve.getSurveillant().getNom());
		etat.setAction("Suppression");
		etat.setType("ExamSurveillant");
		etatService.save(etat);
		examSurveDao.deleteById(id);
		
	}



}
