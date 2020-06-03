package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.User;

public interface UserService {
       public User findByLogin(String login);
       public int seConnecter(User user) throws Exception;
       public List<User> findAll();
       public int save(User user) throws Exception;
}
