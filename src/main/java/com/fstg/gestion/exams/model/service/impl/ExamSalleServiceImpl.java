package com.fstg.gestion.exams.model.service.impl;



import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Etat;
import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSalle;

import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.beans.Surveillant;
import com.fstg.gestion.exams.model.dao.ExamSalleDao;
import com.fstg.gestion.exams.model.service.facade.EtatService;
import com.fstg.gestion.exams.model.service.facade.ExamSalleService;
import com.fstg.gestion.exams.model.service.facade.ExamService;
import com.fstg.gestion.exams.model.service.facade.SalleService;
import com.fstg.gestion.exams.model.service.facade.SurveillantService;

@Service
public class ExamSalleServiceImpl implements ExamSalleService{

	@Autowired
	ExamSalleDao examSalleDao;
	
	@Autowired
	ExamService examService;
	
	@Autowired 
	SalleService salleService;
	
	@Autowired
	EtatService etatService;
	
	@Autowired
	SurveillantService surveillantService;
	
	@Override
	public List<ExamSalle> findBySalleDesignation(String designation) {
		return examSalleDao.findBySalleDesignation(designation);
	}

	@Override
	public List<ExamSalle> findByExamReference(String reference) {
		return examSalleDao.findByExamReference(reference);
	}




	@Override
	public void saveSalle(Exam exam, List<ExamSalle> examSalles) {
			for(ExamSalle valideExamSalle : examSalles) {
				Salle foundSalle = salleService.findByDesignation(valideExamSalle.getSalle().getDesignation());
				valideExamSalle.setExam(exam);
				valideExamSalle.setSalle(foundSalle);
				examSalleDao.save(valideExamSalle);
				surveillantService.save(valideExamSalle, valideExamSalle.getSurveillants());
			}
	
		
		
	}

	@Override
	public List<ExamSalle> findAll() {
return examSalleDao.findAll();
	}

	@Override
	public ExamSalle findById(Long id) {
		return examSalleDao.getOne(id);
	}

	@Override
	@Transactional
	public int deleteBySalleDesignationAndExamDateDepartAndExamDateFin(String designation, Date dateDepart, Date dateFin ) {
		
	return examSalleDao.deleteBySalleDesignationAndExamDateDepartAndExamDateFin(designation, dateDepart, dateFin);
	}

	@Override
	public ExamSalle findBySalleDesignationAndExamDateDepartAndExamDateFin(String designation, Date dateDepart,
			Date dateFin) {
	return examSalleDao.findBySalleDesignationAndExamDateDepartAndExamDateFin(designation, dateDepart, dateFin);
	}

	
	@Override
	public List<ExamSalle> findExamSalle(String designation, Date dateDepart, Date dateFin) {
		return examSalleDao.findExamSalle(designation, dateDepart, dateFin);		
	}

	@Override
	public List<ExamSalle> findSalleNonDisponible(String designation, Date date) {
		return examSalleDao.findSalleNonDisponible(designation, date);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		Etat etat = new Etat();
		ExamSalle foundedExamSalle = findById(id);
		etat.setLibelle(foundedExamSalle.getSalle().getDesignation());
		etat.setAction("Suppression");
		etat.setType("ExamSalle");
		etatService.save(etat);
	 surveillantService.deleteByExamSalleId(foundedExamSalle.getId());
		 examSalleDao.deleteById(foundedExamSalle.getId());
	}
     
	@Override
	@Transactional
	public int deleteByExamId(Long id) {
		return examSalleDao.deleteByExamId(id);
	}

	@Override
	@Transactional
	public int deleteBySalleId(Long id) {
		return examSalleDao.deleteBySalleId(id);
	}

	@Override
	public List<ExamSalle> findExamOrderBySalleDesignation(Long id) {
		return examSalleDao.findExamOrderBySalleDesignation(id);
	}

	

	

	
}
