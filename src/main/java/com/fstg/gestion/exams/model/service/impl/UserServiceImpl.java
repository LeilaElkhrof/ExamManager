package com.fstg.gestion.exams.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.gestion.exams.beans.User;
import com.fstg.gestion.exams.model.dao.UserRepository;
import com.fstg.gestion.exams.model.service.facade.UserService;
import com.fstg.gestion.exams.model.service.util.DateUtil;
import com.fstg.gestion.exams.model.service.util.HashUtil;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public int seConnecter(User user) throws Exception {
        User loadedUser = findByLogin(user.getLogin());
        if (loadedUser == null) {
            return -1;
        } else
				if (!loadedUser.getPwd().equalsIgnoreCase(HashUtil.hash(user.getPwd()))) {
				    loadedUser.setNbrTentatifRestant(loadedUser.getNbrTentatifRestant() - 1);
				    if (loadedUser.getNbrTentatifRestant() == 0) {
				        loadedUser.setBloqued(true);
				        loadedUser.setDateBloquage(new Date());
				        userRepository.save(loadedUser);
				        return -2;
				    } else {
				        userRepository.save(loadedUser);
				        return -3;
				    }
				}
				else if(loadedUser.isBloqued() == true) {
				    if(DateUtil.debloquer(loadedUser.getDateBloquage())) {
				    	loadedUser.setBloqued(false);
				    	loadedUser.setNbrTentatifRestant(3);
				    	userRepository.save(loadedUser);
				    	return 2;
				    }else {
				    	return -4;
				    }
				    }else {
				    return 1;
				}
			

    }
    
    

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public int save(User user) throws Exception {
		User foundedUser = findByLogin(user.getLogin());
		if(foundedUser != null) 
			return -1;
	    else {
	    	System.out.println(user.getPwd());
				System.out.println(HashUtil.hash(user.getPwd()));
			    user.setPwd(HashUtil.hash(user.getPwd()));
	    	    user.setNbrTentatifRestant(3);
	    	    user.setBloqued(false);
				userRepository.save(user);
					return 1;
	     }
    }
}
