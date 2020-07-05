package com.fstg.gestion.exams.model.service.facade;


import java.util.Date;
import java.util.List;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamSalle;


public interface ExamService {
	public Exam findById (Long id);
	public Exam findByReference(String reference);
	public int deleteByReference(String reference);
	public List<Exam> findByModuleLibelle(String reference);
	public int save(Exam exam, List<ExamSalle> examSalles);
	public int deleteById(Long id);
	public List<Exam> findByFiliereLibelle(String filiere);
	public List<Exam>findAll();
public List<Exam> findByFiliereDepartementLibelle(String libelle);

	public int update(Long id, Date dateDepart, Date dateFin,String module, String prof,String filiere, String title);

	public Exam findByDateDepartAndDateFinAndModuleLibelle(Date dateDepart, Date dateFin, String module);
}
