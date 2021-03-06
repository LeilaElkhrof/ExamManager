package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;


public interface ModuleService {

	public Module findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public List<Module> findByFiliereLibelle(String libelle);
	public int deleteByFiliereLibelle(String libelle);
	public void save(Filiere filiere, List<Module> module);
	public List<Module> findAll();
	public int addModule(Module module);
	public int updateModule(Long id, String libelle, String semestre, String professeur);
	public void deleteById(Long id);

	public List<Module> findByFiliereDepartementLibelle(String libelle);

	public Module findByFiliereModuleAndModuleLibelle(String filiere, String module);

	
}
