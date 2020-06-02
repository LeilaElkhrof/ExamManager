package com.fstg.gestion.exams.model.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSurve;
import com.fstg.gestion.exams.beans.Personnel;
import com.fstg.gestion.exams.beans.Surveillant;
import com.fstg.gestion.exams.model.dao.ExamSurveDao;
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
	
	



	@Override
	public List<ExamSurve> findByExamReference(String reference) {
		return examSurveDao.findByExamReference(reference);
	}


	@Override
	@Transactional
	public int deleteByExamReference(String reference) {
	return examSurveDao.deleteByExamReference(reference);
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



}
