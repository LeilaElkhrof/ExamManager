package com.fstg.gestion.exams.model.service.facade;

import java.util.List;


import com.fstg.gestion.exams.beans.Personnel;


public interface PersonnelService {
public int save(Personnel personnel);
public int deleteByNom(String nom);
public Personnel findByNom(String nom);
public List<Personnel> findAll();
public Personnel update(Long id,String nom, String prenom, String mail);
public Personnel findById(Long id);
}
