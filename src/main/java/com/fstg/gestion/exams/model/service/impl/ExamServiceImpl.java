package com.fstg.gestion.exams.model.service.impl;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Calendrier;
import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Professeur;

import com.fstg.gestion.exams.model.dao.ExamRepository;
import com.fstg.gestion.exams.model.service.facade.CalendrierService;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.ExamSalleService;
import com.fstg.gestion.exams.model.service.facade.ExamService;
import com.fstg.gestion.exams.model.service.facade.FiliereService;
import com.fstg.gestion.exams.model.service.facade.ModuleService;
import com.fstg.gestion.exams.model.service.facade.ProfesseurService;
import com.fstg.gestion.exams.model.service.facade.SalleService;
import com.fstg.gestion.exams.model.service.facade.SurveillantService;
import com.fstg.gestion.exams.model.service.util.DateUtil;



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
	FiliereService filiereService;
	
	@Autowired 
	CalendrierService calendrierService;
	
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
	public int update(Long id, Date dateDepart, Date dateFin,String module, String prof,String filiere, String title) {
		Etat modifie = new Etat();
		Exam foundedExam = findById(id);
		Module foundedModule = moduleService.findByFiliereModuleAndModuleLibelle(filiere, module);
		Filiere foundedFiliere = filiereService.findByLibelle(filiere);
		Professeur foundedProfesseur = professeurService.findByNom(prof);
		Calendrier foundedCalendrier = calendrierService.findByStartAndEndAndTitle(DateUtil.parseDateHour(dateDepart), DateUtil.parseDateHour(dateFin), title);
		System.out.println(DateUtil.parseDateHour(dateDepart));
	foundedExam.setDateDepart(dateDepart);
	foundedExam.setDateFin(dateFin);
	foundedExam.setModule(foundedModule);
	foundedExam.setProf(foundedProfesseur);
	foundedExam.setReference(module);
	foundedExam.setFiliere(foundedFiliere);

	foundedCalendrier.setTitle(module);
	foundedCalendrier.setStart(DateUtil.parseDateHour(dateDepart));
	foundedCalendrier.setEnd(DateUtil.parseDateHour(dateFin));
	foundedCalendrier.setFiliere(foundedFiliere);
	foundedCalendrier.setDepartement(foundedFiliere.getDepartement());
	foundedCalendrier.setColor(foundedFiliere.getCouleur());
	

	
	Exam updateExam = examRepository.save(foundedExam);
	modifie.setLibelle(foundedExam.getReference());
	modifie.setAction("Modification");
	modifie.setType("Exam");
	etatService.save(modifie);
	return 1;
		

	}

	@Override
	public int save(Exam exam, List<ExamSalle> examSalles) {
		Etat etat = new Etat();
		 Filiere foundedFiliere = filiereService.findByLibelle(exam.getFiliere().getLibelle());
		 Professeur foundedProfesseur = professeurService.findByNom(exam.getProf().getNom());
		 Module foundedModule = moduleService.findByLibelle(exam.getModule().getLibelle());
		
		
	    if(foundedFiliere == null) {
			return -2;
		}
		 else {
			 Calendrier calendrier = new Calendrier();
			 exam.setReference(foundedModule.getLibelle()); 
			 exam.setProf(foundedProfesseur);
			 exam.setModule(foundedModule);
			 exam.setFiliere(foundedFiliere);
				etat.setLibelle(exam.getReference());
				etat.setAction("Insertion");
				etat.setType("Examen");
				etatService.save(etat);	
			 examRepository.save(exam);	
			 
			 calendrier.setTitle(foundedModule.getLibelle());
			 calendrier.setColor(foundedFiliere.getCouleur());
			 calendrier.setStart(DateUtil.parseDateHour(exam.getDateDepart()));
			 calendrier.setEnd(DateUtil.parseDateHour(exam.getDateFin()));
			 calendrier.setFiliere(foundedFiliere);
			 calendrier.setDepartement(foundedFiliere.getDepartement());
			
			 examSalleService.saveSalle(exam, examSalles);
			 calendrierService.save(calendrier);
			 
			return 1;
		}
	}

@Override
@Transactional
public int deleteById(Long id) {
	Etat etat = new Etat();
	Exam foundedExam = examRepository.getOne(id);
	if(foundedExam.getDateDepart().getTime() - new Date().getTime() > 0) {
		return -1;
	}else {
	etat.setLibelle(foundedExam.getReference());
	etat.setAction("Suppression");
	etat.setType("Examen");
	etatService.save(etat);	
	int surveillant = surveillantService.deleteByExam(foundedExam.getId());
	int examSalle = examSalleService.deleteByExamId(foundedExam.getId());
	 examRepository.deleteById(id);
	return examSalle+surveillant;
	}
}

@Override
public List<Exam> findByModuleLibelle(String reference) {
	return examRepository.findByModuleLibelle(reference);
}

@Override
public int deleteByReference(String reference) {

	return 0;
}

@Override

public List<Exam> findByFiliereDepartementLibelle(String libelle) {
	return examRepository.findByFiliereDepartementLibelle(libelle);
}

@Override
public List<Exam> findByFiliereLibelle(String filiere) {
	return examRepository.findByFiliereLibelle(filiere);
}

@Override
public Exam findByDateDepartAndDateFinAndModuleLibelle(Date dateDepart, Date dateFin, String module) {
	return examRepository.findByDateDepartAndDateFinAndModuleLibelle(dateDepart, dateFin, module);
}


}
