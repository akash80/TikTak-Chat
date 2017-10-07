/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.model;

/**
 *
 * @author akash
 */
public class UserList {
    
    private String name;
    private String username;
    public UserList(String username, String name){
        this.name=name;
        this.username=username;
    }
    @Override
public String toString(){
   return username+" "+name;
}
}
