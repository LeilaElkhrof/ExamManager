package com.fstg.gestion.exams.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Calendrier;

@Repository
public interface CalendrierRepository extends JpaRepository<Calendrier,Long>{

	public int deleteByLibelle (String libelle);
	public Calendrier findByLibelle(String libelle);

}
