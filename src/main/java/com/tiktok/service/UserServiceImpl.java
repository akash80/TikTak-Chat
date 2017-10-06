/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tiktok.dao.UserDao;
import com.tiktok.model.Login;
import com.tiktok.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  @Override
  public void register(User user) {
    userDao.register(user);
  }

  @Override
  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

  @Override
  public User validatedUser(String username){
      return userDao.validatedUser(username);
  }
}