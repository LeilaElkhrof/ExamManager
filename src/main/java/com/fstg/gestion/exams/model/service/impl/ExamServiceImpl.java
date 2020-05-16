package com.fstg.gestion.exams.model.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Professeur;
import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.beans.Surveillant;
import com.fstg.gestion.exams.model.dao.ExamRepository;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.ExamService;
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
	
	@Override
	public Exam findByReference(String reference) {
		return examRepository.findByReference(reference);
	}

	@Override
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

	@Override
	public List<Exam> findByDate(Date date) {
		return examRepository.findByDate(date);
	}
	
	public List<Surveillant> validateSurveillants(List<Surveillant> surveillants){
		List<Surveillant> validateSurveillants = new ArrayList<Surveillant>();
		for(Surveillant surveillant : surveillants) {
			if(surveillantService.findByNom(surveillant.getNom()) != null)
			{
				validateSurveillants.add(surveillant);
			}
		}
		return validateSurveillants;
	}
	public List<Salle> validateSalles(List<Salle> salles){
		List<Salle> validateSalles = new ArrayList<Salle>();
		for(Salle salle : salles) {
			if(salleService.findByDesignation(salle.getDesignation()) != null)
			{
				validateSalles.add(salle);
			}
		}
		return validateSalles;
	}

	@Override
	public int save(Exam exam) {
		Exam foundedExam = findByReference(exam.getReference());
		List<Surveillant> validateSurveillants = validateSurveillants(exam.getSurveillants());
		List<Salle> validateSalles = validateSalles(exam.getSalles());
		Module foundedModule = moduleService.findByLibelle(exam.getModule().getLibelle());
		Professeur foundedProfesseur = professeurService.findByNom(exam.getProf().getNom());
		
		if(foundedExam != null)
			return -1;
		
		if(validateSurveillants == null)
			return -2;
		
		if(foundedModule == null)
			return -3;
		if(validateSalles == null)
			return -4;
		if(foundedProfesseur == null)
			return -5;
		
		else {
			exam.setModule(foundedModule);
			examRepository.save(exam);
			exam.setSurveillants(validateSurveillants);
			exam.setProf(foundedProfesseur);
			exam.setSalles(validateSalles);
			
			return 1;
		}
		
		
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
	public Exam update(Long id, String reference,Date date, String heureDepart, String heureFin,Module module, Professeur prof, List<Surveillant> surveillants, List<Salle> salles) {
		Etat modifie = new Etat();
		Exam foundedExam = findById(id);
	foundedExam.setDate(date);
	foundedExam.setHeureDepart(heureDepart);
	foundedExam.setHeureFin(heureFin);
	foundedExam.setModule(module);
	foundedExam.setProf(prof);
	foundedExam.setReference(reference);
	foundedExam.setSurveillants(surveillants);
	foundedExam.setSalles(salles);
	Exam updateExam = examRepository.save(foundedExam);
	modifie.setLibelle(foundedExam.getReference());
	modifie.setAction("Modification");
	etatService.save(modifie);
	return updateExam;
		

	}


}
