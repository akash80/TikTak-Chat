/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/wschat")
public class WsChat{
    //notice:not thread-safe
    private static ArrayList<Session> sessionList = new ArrayList<Session>();
    
    @OnOpen
    public void onOpen(Session session){
        try{
            sessionList.add(session);
            //asynchronous communication
            session.getBasicRemote().sendText("Welcome!");
        }catch(IOException e){}
    }
    
    @OnClose
    public void onClose(Session session){
        System.out.println("close");
        sessionList.remove(session);
    }
    
    @OnMessage
    public void onMessage(String msg){
        System.out.println("message");
        try{
            for(Session session : sessionList){
                //asynchronous communication
                session.getBasicRemote().sendText(msg);
            }
        }catch(IOException e){}
    }
}