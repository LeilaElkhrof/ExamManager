package com.fstg.gestion.exams.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Responsabilite;

@Repository
public interface ResponsabiliteRepository extends JpaRepository<Responsabilite,Long>{

	public Responsabilite findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
}
