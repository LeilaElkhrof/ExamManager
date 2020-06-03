package com.fstg.gestion.exams.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.User;
import com.fstg.gestion.exams.model.service.facade.UserService;

@RestController
@RequestMapping("exam-api/user")
@CrossOrigin(origins= {"http://localhost:4200" })
public class UserRest {
	
	@Autowired
	UserService userService;

	@GetMapping("/find-by-login/login")
	public User findByLogin(@PathVariable String login) {
		return userService.findByLogin(login);
	}

	@PutMapping("/se-connecter")
	public int seConnecter(@RequestBody User user) throws Exception {
		return userService.seConnecter(user);
	}

	@GetMapping("/find-all")
	public List<User> findAll() {
		return userService.findAll();
	}
	@PostMapping("/save")
	public int save(@RequestBody User user) throws Exception {
		return userService.save(user);
	}
	
	

}
