/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tiktok.model.Login;
import com.tiktok.model.User;
import com.tiktok.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author akash
 */
@Controller
public class WelcomePageController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/logoutSession", method = RequestMethod.POST)
  public ModelAndView logoutSession(HttpServletRequest request, HttpServletResponse response){
      ModelAndView mav = null;
      HttpSession session = request.getSession(false);
      session.invalidate();
      mav=new ModelAndView("login");
      mav.addObject("message","You have been successfully logged out");
      return mav;
  }
    @RequestMapping(value = {"/welcome", "/loginProcess"}, method = RequestMethod.GET)
  public ModelAndView showWelcome(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(false);
    ModelAndView mav=null;
    if(session.getAttribute("UserName")!=null){
    User user = userService.validatedUser(session.getAttribute("UserName").toString());
    mav = new ModelAndView("welcome");
    mav.addObject("name",user.getName());
    mav.addObject("phone",user.getPhone());
    mav.addObject("email",user.getEmail());
    mav.addObject("username",user.getUsername());
    }else{
        mav = new ModelAndView("login");
        mav.addObject("login", new Login());
    }
    return mav;
  }
}
