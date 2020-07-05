package com.fstg.gestion.exams.model.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.beans.Personnel;
import com.fstg.gestion.exams.beans.Surveillant;
import com.fstg.gestion.exams.model.dao.SurveillantRepository;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.PersonnelService;
import com.fstg.gestion.exams.model.service.facade.SurveillantService;

@Service
public class SurveillantServiceImpl implements SurveillantService {

	@Autowired
	SurveillantRepository surveillantRepository;
	@Autowired
	EtatService etatService;
	
	@Autowired
	PersonnelService personnelService;
	
	@Override
	public Surveillant findByNom(String nom) {
		
		return surveillantRepository.findByNom(nom);
	}

	@Override
	@Transactional
	public void deleteById(String nom, Date dateDepart, Date dateFin, String module) {
		Surveillant foundedSurve= findByNomAndExamDateDepartAndExamDateFinAndExamModuleLibelle(nom, dateDepart, dateFin, module);
		Etat etat = new Etat();
		etat.setLibelle(foundedSurve.getNom());
		etat.setAction("Suppression");
		etat.setType("Surveillant");
		etatService.save(etat);
	    surveillantRepository.deleteById(foundedSurve.getId());
	}

	@Override
	public int save(Surveillant surveillant) {
		Personnel personnel = new Personnel();
		Surveillant foundedSurveillant = findByNom(surveillant.getNom());
		if(foundedSurveillant != null) 
			return -1;
			
		else {
			personnel.setMail(surveillant.getMail());
			personnel.setNom(surveillant.getNom());
			personnel.setPrenom(surveillant.getPrenom());
			personnelService.save(personnel);
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
		Etat modifie = new Etat();
		Surveillant foundedSurveillant = findById(id);
			foundedSurveillant.setNom(nom);
			foundedSurveillant.setPrenom(prenom);
			foundedSurveillant.setMail(mail);
			Surveillant  updateSurveillant = surveillantRepository.save(foundedSurveillant);
			modifie.setLibelle(foundedSurveillant.getNom());
			modifie.setAction("Modification");
			modifie.setType("Surveillant");
			etatService.save(modifie);
			return updateSurveillant;
	}

	@Override
	public Surveillant findById(Long id) {
	return surveillantRepository.getOne(id);
	}

	@Override
	public List<Surveillant> findByExamSalleSalleDesignationAndExamSalleExamDateDepartAndExamSalleExamDateFin(
			String designation, Date dateDepart, Date dateFin) {
		return surveillantRepository.findByExamSalleSalleDesignationAndExamSalleExamDateDepartAndExamSalleExamDateFin(designation, dateDepart, dateFin);
	}

	@Override
	public int save(ExamSalle examsalle, List<Surveillant> surveillants) {
        for(Surveillant surveillant : surveillants) {
        	Personnel surve = personnelService.findByNom(surveillant.getNom());
        	surveillant.setNom(surve.getNom());
        	surveillant.setPrenom(surve.getPrenom());
        	surveillant.setMail(surve.getMail());
        	surveillant.setExam(examsalle.getExam());
            surveillant.setExamSalle(examsalle);
			surveillantRepository.save(surveillant);		
		}
		return 1;
	}
	
	@Override
	public List<Surveillant> findSurveillant(String nom, Date dateDepart, Date dateFin) {
		return surveillantRepository.findSurveillant(nom, dateDepart, dateFin);
	}

	

	@Override
	public List<Surveillant> findByExamModuleLibelleAndExamDateDepartAndExamDateFin(String module, Date dateDepart,
			Date dateFin) {
		return surveillantRepository.findByExamModuleLibelleAndExamDateDepartAndExamDateFin(module, dateDepart, dateFin);
	}

	@Override
	public int deleteByExam(Long id) {
		return surveillantRepository.deleteByExam(id);
	}

	@Override
	public List<Surveillant> findByExamId(Long exam) {
		return surveillantRepository.findByExamId(exam);
	}

	@Override
	public Surveillant findByNomAndExamDateDepartAndExamDateFinAndExamModuleLibelle(String nom, Date dateDepart,
			Date dateFin, String module) {
		return surveillantRepository.findByNomAndExamDateDepartAndExamDateFinAndExamModuleLibelle(nom, dateDepart, dateFin, module);
	}


}
