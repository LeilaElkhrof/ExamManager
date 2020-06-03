package com.fstg.gestion.exams.model.service.impl;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.beans.Salle;
import com.fstg.gestion.exams.model.dao.ExamSalleDao;
import com.fstg.gestion.exams.model.service.facade.ExamSalleService;
import com.fstg.gestion.exams.model.service.facade.ExamService;
import com.fstg.gestion.exams.model.service.facade.SalleService;

@Service
public class ExamSalleServiceImpl implements ExamSalleService{

	@Autowired
	ExamSalleDao examSalleDao;
	
	@Autowired
	ExamService examService;
	
	@Autowired 
	SalleService salleService;
	
	@Override
	public List<ExamSalle> findBySalleDesignation(String designation) {
		return examSalleDao.findBySalleDesignation(designation);
	}

	@Override
	public List<ExamSalle> findByExamReference(String reference) {
		return examSalleDao.findByExamReference(reference);
	}



	@Override
	@Transactional
	public int deleteByExamReference(String reference) {
		return examSalleDao.deleteByExamReference(reference);
	}




	@Override
	public void saveSalle(Exam exam, List<ExamSalle> examSalles) {
	System.out.println("hola"+examSalles);
	//List<ExamSalle> validateExamSalle = validateSalle(examSalles,exam);
	//if(validateExamSalle != null) {
			for(ExamSalle valideExamSalle : examSalles) {
				System.out.println("sdvcjsh "+valideExamSalle.getSalle().getDesignation());
				Salle foundSalle = salleService.findByDesignation(valideExamSalle.getSalle().getDesignation());
				
				valideExamSalle.setExam(exam);
				//valideExamSalle.getSalle().setDisponibilite(false);
				valideExamSalle.setSalle(foundSalle);
				examSalleDao.save(valideExamSalle);	
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
	public int deleteBySalleDesignation(String designation) {
	return examSalleDao.deleteBySalleDesignation(designation);
	}

	@Override
	public ExamSalle findBySalleDesignationAndExamDateDepartAndExamDateFin(String designation, Date dateDepart,
			Date dateFin) {
	return examSalleDao.findBySalleDesignationAndExamDateDepartAndExamDateFin(designation, dateDepart, dateFin);
	}

	/*public List<ExamSalle> validateSalle(List<ExamSalle> examSalles, Exam exam) {
		List<ExamSalle> valideSalle = new ArrayList<ExamSalle>();
		
		for(ExamSalle examsSalle: examSalles) {
		//ExamSalle examSalle = findBySalleDesignationAndExamDateDepartAndExamDateFin(examsSalle.getSalle().getDesignation(),exam.getDateDepart(),exam.getDateFin());
			//List<ExamSalle> examSalle = findExamSalle(examsSalle.getSalle().getDesignation(),exam.getDateDepart(),exam.getDateFin());
		if(examSalle == null) {
			valideSalle.add(examsSalle);
			System.out.println("salle"+examsSalle.getSalle().getDesignation());
		}
		}
		return valideSalle;
	}*/

	
	@Override
<<<<<<< HEAD
	public List<ExamSalle> findExamSalle(String designation, Date dateDepart, Date dateFin ) {
		return examSalleDao.findExamSalle(designation, dateDepart, dateFin );
=======
	public ExamSalle findExamSalle(Date dateDepart, Date dateFin, String designation) {
		System.out.println( dateDepart);
		System.out.println(dateFin);
		System.out.println(designation);
		return examSalleDao.findExamSalle(designation, dateDepart, dateFin);
>>>>>>> branch 'master' of https://github.com/LeilaElkhrof/ExamManager.git
		
	}

}
