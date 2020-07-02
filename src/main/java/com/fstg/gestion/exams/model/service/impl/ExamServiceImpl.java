package com.fstg.gestion.exams.model.service.impl;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Professeur;

import com.fstg.gestion.exams.model.dao.ExamRepository;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.ExamSalleService;
import com.fstg.gestion.exams.model.service.facade.ExamService;
import com.fstg.gestion.exams.model.service.facade.FiliereService;
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
	FiliereService filiereService;
	
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
	public Exam update(Long id, String reference, Date dateDepart, Date dateFin,Module module, Professeur prof,Filiere filiere) {
		Etat modifie = new Etat();
		Exam foundedExam = findById(id);
	foundedExam.setDateDepart(dateDepart);
	foundedExam.setDateFin(dateFin);
	foundedExam.setModule(module);
	foundedExam.setProf(prof);
	foundedExam.setReference(reference);
	foundedExam.setFiliere(filiere);

	
	Exam updateExam = examRepository.save(foundedExam);
	modifie.setLibelle(foundedExam.getReference());
	modifie.setAction("Modification");
	modifie.setType("Exam");
	etatService.save(modifie);
	return updateExam;
		

	}

	@Override
	public int save(Exam exam, List<ExamSalle> examSalles) {
		 Filiere foundedFiliere = filiereService.findByLibelle(exam.getFiliere().getLibelle());
		 Professeur foundedProfesseur = professeurService.findByNom(exam.getProf().getNom());
		 Module foundedModule = moduleService.findByLibelle(exam.getModule().getLibelle());
		;
		
	    if(foundedFiliere == null) {
			return -2;
		}
		 else {
			 exam.setReference(foundedModule.getLibelle());
			 exam.setProf(foundedProfesseur);
			 exam.setModule(foundedModule);
			 exam.setFiliere(foundedFiliere);
			examRepository.save(exam);	
			examSalleService.saveSalle(exam, examSalles);
			return 1;
		}
	}

@Override
@Transactional
public int deleteById(Long id) {
	Etat etat = new Etat();
	Exam foundedExam = examRepository.getOne(id);
	if(foundedExam.getDateDepart().getTime() - new Date().getTime() > 0) {
		System.out.println(foundedExam.getDateDepart().getTime() - new Date().getTime());
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
	// TODO Auto-generated method stub
	return 0;
}

@Override
public List<Exam> findByFiliereDepartementLibelle(String libelle) {
	return examRepository.findByFiliereDepartementLibelle(libelle);
}


}
