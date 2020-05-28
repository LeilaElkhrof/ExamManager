package com.fstg.gestion.exams.model.service.impl;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.beans.ExamSurve;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Professeur;

import com.fstg.gestion.exams.model.dao.ExamRepository;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.ExamSalleService;
import com.fstg.gestion.exams.model.service.facade.ExamService;
import com.fstg.gestion.exams.model.service.facade.ExamSurveService;
import com.fstg.gestion.exams.model.service.facade.ModuleService;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;
import com.fstg.gestion.exams.model.service.facade.SalleService;
import com.fstg.gestion.exams.model.service.facade.SurveillantService;



@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	ProfesseurService professeurService;
	
	@Autowired
	SurveillantService surveillantService;
	
	@Autowired
	ModuleService moduleService;
	
	@Autowired
	SalleService salleService;
	
	@Autowired
	EtatService etatService;
	@Autowired
	ExamSalleService examSalleService;
	@Autowired
	ExamSurveService examSurveService;
	
	@Override
	public Exam findByReference(String reference) {
		return examRepository.findByReference(reference);
	}

	@Override
	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	@Override
	public Exam findById(Long id) {
		return examRepository.getOne(id);
	}


	@Override
	public Exam update(Long id, String reference, String dateDepart, String dateFin,Module module, Professeur prof) {
		Etat modifie = new Etat();
		Exam foundedExam = findById(id);
	foundedExam.setDateDepart(dateDepart);
	foundedExam.setDateFin(dateFin);
	foundedExam.setModule(module);
	foundedExam.setProf(prof);
	foundedExam.setReference(reference);

	
	Exam updateExam = examRepository.save(foundedExam);
	modifie.setLibelle(foundedExam.getReference());
	modifie.setAction("Modification");
	etatService.save(modifie);
	return updateExam;
		

	}

	@Override
	public int save(Exam exam, List<ExamSurve> examSurves, List<ExamSalle> examSalles) {
		Exam examFound = findByReference(exam.getReference());
		if (examFound != null) {
			return -1;
		} 
		 else {
			examRepository.save(exam);	
			examSalleService.saveSalle(exam, examSalles);
			examSurveService.saveSurve(exam, examSurves);
			return 1;
		}
	}

@Override
@Transactional
public int deleteByReference(String reference) {
	Etat etat = new Etat();
	Exam foundedExam = findByReference(reference);
	etat.setLibelle(foundedExam.getReference());
	etat.setAction("Suppression");
	etatService.save(etat);
	return examRepository.deleteByReference(reference);
}

@Override
public List<Exam> findByModuleLibelle(String reference) {
	return examRepository.findByModuleLibelle(reference);
}


}
