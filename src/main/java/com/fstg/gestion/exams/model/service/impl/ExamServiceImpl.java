package com.fstg.gestion.exams.model.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Professeur;
import com.fstg.gestion.exams.model.dao.ExamRepository;
import com.fstg.gestion.exams.model.service.facade.ExamService;
import com.fstg.gestion.exams.model.service.facade.ModuleService;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;


@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	ProfesseurService professeurService;
	
	@Autowired
	ModuleService moduleService;
	
	@Override
	public Exam findByReference(String reference) {
		return examRepository.findByReference(reference);
	}

	@Override
	public int deleteByReference(String reference) {
		return examRepository.deleteByReference(reference);
	}

	@Override
	public List<Exam> findByModuleLibelle(String reference) {
		return examRepository.findByModuleLibelle(reference);
	}

	@Override
	public List<Exam> findByDate(Date date) {
		return examRepository.findByDate(date);
	}
	
	public List<Professeur> validateSurveillants(List<Professeur> surveillants){
		List<Professeur> validateSurveillants = new ArrayList<Professeur>();
		for(Professeur surveillant : surveillants) {
			if(professeurService.findByCin(surveillant.getCin()) != null)
			{
				validateSurveillants.add(surveillant);
			}
		}
		return validateSurveillants;
	}

	@Override
	public int save(Exam exam) {
		Exam foundedExam = findByReference(exam.getReference());
		List<Professeur> validateSurveillants = validateSurveillants(exam.getSurveillants());
		Module foundedModule = moduleService.findByLibelle(exam.getModule().getLibelle());
		
		if(foundedExam != null)
			return -1;
		
		if(validateSurveillants == null)
			return -2;
		
		if(foundedModule == null)
			return -3;
		
		else {
			exam.setModule(foundedModule);
			examRepository.save(exam);
			exam.setSurveillants(validateSurveillants);
			
			return 1;
		}
		
		
	}

	@Override
	public List<Exam> findAll() {
		return examRepository.findAll();
	}

}
