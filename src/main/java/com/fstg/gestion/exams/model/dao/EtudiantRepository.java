package com.fstg.gestion.exams.model.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Etudiant;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	public Etudiant findByCne(String cne);
	public int deleteByCne(String cne);
	public List<Etudiant> findByFiliereLibelle(String libelle);
	public int deleteByFiliereLibelle(String libelle);
	public List<Etudiant> findByFiliereLibelleAndSemestreLibelle(String filiere, String semestre);
}
