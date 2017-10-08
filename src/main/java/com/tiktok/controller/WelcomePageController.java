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
import com.tiktok.model.Message;
import com.tiktok.model.User;
import com.tiktok.service.MessageService;
import com.tiktok.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    @Autowired
    MessageService messageService;
    @RequestMapping(value = "/logoutSession", method = RequestMethod.POST)
  public ModelAndView logoutSession(HttpServletRequest request, HttpServletResponse response){
      ModelAndView mav = null;
      HttpSession session = request.getSession(false);
      session.invalidate();
      mav=new ModelAndView("login");
      mav.addObject("message","You have been successfully logged out");
      return mav;
  }
    @RequestMapping(value = {"/welcome", "/loginProcess", "/uploadImage", "login","/logoutSession"}, method = RequestMethod.GET)
    public ModelAndView showWelcome(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
    HttpSession session = request.getSession(false);
    ModelAndView mav=null;
    if(session.getAttribute("UserName")!=null){
    User user = userService.validatedUser(session.getAttribute("UserName").toString());
    mav = new ModelAndView("welcome");
    model.addAttribute("list", userService.getUsers(session.getAttribute("UserName").toString()));
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
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.POST)
    public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        HttpSession session = request.getSession(false);
    ModelAndView mav=null;
    if(session.getAttribute("UserName")!=null){
    User user = userService.validatedUser(session.getAttribute("UserName").toString());
    mav = new ModelAndView("welcome");
    model.addAttribute("list", userService.getUsers(session.getAttribute("UserName").toString()));
    List<User> li = userService.getUsers(session.getAttribute("UserName").toString());
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
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
   public void profile(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException{
   PrintWriter out = response.getWriter();
   String sender = request.getParameter("sender");
   String receiver = request.getParameter("receiver");
   List<Message> list = new ArrayList<>(messageService.getMessages(sender, receiver));
   
   //parsing data into json then send it to ajax
   JSONObject obj=new JSONObject();
    JSONArray arr = new JSONArray();
   String[] requestNos = new String[list.size()];
   for (int i = 0; i < list.size(); i++) {
    requestNos[i] = list.get(i).getSender();
    arr.add(requestNos[i]);
    requestNos[i] = list.get(i).getReceiver();
    arr.add(requestNos[i]);
    requestNos[i] = list.get(i).getMessage();
    arr.add(requestNos[i]);
}
    obj.put("data",arr);
    obj.put("count", list.size());
   out.println(obj);
  }
   @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
  public void messageSend(HttpServletRequest request, HttpServletResponse response) throws IOException{
   PrintWriter out = response.getWriter();
   Message msg = new Message(request.getParameter("sender").trim(),request.getParameter("receiver").trim(),request.getParameter("message"));
   messageService.send(msg);
   out.println(msg.getMessage());
  }
}
