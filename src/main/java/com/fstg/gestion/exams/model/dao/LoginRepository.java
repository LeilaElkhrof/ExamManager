package com.fstg.gestion.exams.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestion.exams.beans.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	public Login findByMailAndPassword(String mail, String password);

}
