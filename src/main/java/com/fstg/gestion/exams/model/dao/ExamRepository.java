package com.fstg.gestion.exams.model.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Exam;


@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

	public Exam findByReference(String reference);
	public int deleteByReference(String reference);
	public List<Exam> findByModuleLibelle(String reference);
	public List<Exam> findByDate(Date date);
}
