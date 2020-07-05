package com.fstg.gestion.exams.model.dao;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Calendrier;

@Repository
public interface CalendrierRepository extends JpaRepository<Calendrier,Long>{

 public List<Calendrier> findByFiliereDepartementLibelle(String libelle);

	
	public Calendrier findByStartAndEndAndTitle(String start, String end, String title);

}
