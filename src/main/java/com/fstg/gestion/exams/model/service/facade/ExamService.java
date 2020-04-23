package com.fstg.gestion.exams.model.service.facade;

import java.util.Date;
import java.util.List;


import com.fstg.gestion.exams.beans.Exam;

public interface ExamService {

	public Exam findByReference(String reference);
	public int deleteByReference(String reference);
	public List<Exam> findByModuleLibelle(String reference);
	public List<Exam> findByDate(Date date);
	public int save(Exam exam);
	public List<Exam>findAll();
}
