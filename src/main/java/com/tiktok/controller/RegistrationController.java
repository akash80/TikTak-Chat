/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.tiktok.model.User;
import com.tiktok.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());
    return mav;
  }
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("user") User user) {
  ModelAndView mav = null;
  userService.register(user);
  mav = new ModelAndView("login");
  mav.addObject("message","Registered successfully! Please Login");
  return mav;
  }
  @RequestMapping(value = "/registerProcess", method = RequestMethod.GET)
  public ModelAndView registerPage(HttpServletRequest request, HttpServletResponse response){
      return new ModelAndView("register");
  }
  @RequestMapping(value = "/userAvailability", method = RequestMethod.POST)
  public void checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
      PrintWriter out = response.getWriter();
      if(userService.validatedUser(request.getParameter("username"))!=null){
          out.println("Username Already Exist");
      }else out.println("Pass");
  }
  
}