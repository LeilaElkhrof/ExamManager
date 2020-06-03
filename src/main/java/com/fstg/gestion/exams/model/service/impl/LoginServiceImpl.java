package com.fstg.gestion.exams.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.Login;
import com.fstg.gestion.exams.model.dao.LoginRepository;
import com.fstg.gestion.exams.model.service.facade.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public Login register(Login login) {
		 loginRepository.save(login);
		 return login;
	}

	@Override
	public Login findByMailAndPassword(String mail, String password) {
		return loginRepository.findByMailAndPassword(mail, password);
	}

}
