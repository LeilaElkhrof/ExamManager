package com.fstg.gestion.exams.model.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.model.service.facade.ExamService;

@RestController
@RequestMapping("exam-api/exams")
public class ExamRest {

	@Autowired
	ExamService examService;

	@GetMapping("/find-by-reference/{reference}")
	public Exam findByReference(@PathVariable String reference) {
		return examService.findByReference(reference);
	}

	@DeleteMapping("/delete-by-reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return examService.deleteByReference(reference);
	}

	@GetMapping("/find-by-module/{reference}")
	public List<Exam> findByModuleLibelle(@PathVariable String reference) {
		return examService.findByModuleLibelle(reference);
	}

	@GetMapping("/find-by-date/{date}")
	public List<Exam> findByDate(@PathVariable Date date) {
		return examService.findByDate(date);
	}

	@PostMapping("/save/")
	public int save(@RequestBody Exam exam) {
		return examService.save(exam);
	}

	@GetMapping("/find-all/")
	public List<Exam> findAll() {
		return examService.findAll();
	}
	
	
	
}
