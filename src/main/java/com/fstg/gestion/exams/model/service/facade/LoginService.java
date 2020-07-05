package com.fstg.gestion.exams.model.service.facade;


import com.fstg.gestion.exams.beans.Login;

public interface LoginService {

	public Login register(Login login);
	public Login findByMailAndPassword(String mail, String password);
}
