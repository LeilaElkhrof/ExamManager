package com.fstg.gestion.exams.model.service.impl;

import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Calendrier;
import com.fstg.gestion.exams.model.dao.CalendrierRepository;
import com.fstg.gestion.exams.model.service.facade.CalendrierService;


@Service
public class CalendrierServiceImpl implements CalendrierService {

	@Autowired
	CalendrierRepository calendrierRepository;
	
	@Override
	public int save(Calendrier calendrier) {
		calendrierRepository.save(calendrier);
		return 1;
	}

	@Override
	public List<Calendrier> findAll() {
		return calendrierRepository.findAll();
	}

	@Override
	public Calendrier findByStartAndEndAndTitle(String start, String end, String title) {
		return calendrierRepository.findByStartAndEndAndTitle(start, end, title);
	}
	
}
