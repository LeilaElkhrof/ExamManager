package com.fstg.gestion.exams.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

	public Module findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public List<Module> findByFiliereLibelle(String libelle);
	public int deleteByFiliereLibelle(String libelle);
	public List<Module> findByFiliereDepartementLibelle(String libelle);
}
