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
public class TestModel {
    private String name;
    private int age;
    public TestModel(String name, int age){
        this.name=name;
        this.age=age;
    }
    @Override
public String toString(){
   return name+" "+age;
}
}
