/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.dao;

import com.tiktok.model.Login;
import com.tiktok.model.User;
import java.util.List;
public interface UserDao {
  void register(User user);
  User validateUser(Login login);
  User validatedUser(String username);
  List<User> getUsers();
}
