package com.fstg.gestion.exams.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.Login;
import com.fstg.gestion.exams.model.service.facade.LoginService;

@RestController
@RequestMapping("exam-api/")
@CrossOrigin(origins= {"http://localhost:4200" })
public class LoginRest {

	@Autowired
	LoginService loginService;

	@PostMapping("register")
	public Login register(@RequestBody Login login) {
		return loginService.register(login);
	}

	@GetMapping("/login")
	public Login findByMailAndPassword(@RequestParam String mail, @RequestParam String password) {
		return loginService.findByMailAndPassword(mail, password);
	}
	
	
}
