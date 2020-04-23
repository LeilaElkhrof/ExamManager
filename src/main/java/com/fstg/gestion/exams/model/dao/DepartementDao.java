package com.fstg.gestion.exams.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Departement;


@Repository
public interface DepartementDao extends JpaRepository<Departement,Long> {

	public Departement findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
}
