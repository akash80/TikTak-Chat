/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Test{
  @RequestMapping(value = "/testData", method = RequestMethod.POST)
  public void testProcess(HttpServletRequest request, HttpServletResponse response) throws IOException{
       JSONObject obj=new JSONObject();   
        PrintWriter out = response.getWriter();
        obj.put("name","sonoo");    
        obj.put("age",new Integer(27));    
        obj.put("salary",new Double(600000));    
        out.print(obj);        
    }
}