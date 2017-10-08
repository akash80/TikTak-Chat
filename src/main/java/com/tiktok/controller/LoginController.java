/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.tiktok.model.Login;
import com.tiktok.model.User;
import com.tiktok.service.UserService;
@Controller
public class LoginController {
  @Autowired
  UserService userService;
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public String loginProcess(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("login") Login login) {
    ModelAndView mav = null;
    User user = userService.validateUser(login);
    if (null != user) {
    HttpSession session = request.getSession(true);
    session.setAttribute("UserName", user.getUsername());
    session.setMaxInactiveInterval(18000);
    }
    return "forward:/welcome";
  }
  
}
