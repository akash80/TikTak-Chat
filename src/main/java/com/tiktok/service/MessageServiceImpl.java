/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.service;

import com.tiktok.dao.MessageDao;
import com.tiktok.model.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author akash
 */
public class MessageServiceImpl implements MessageService{
    @Autowired
    public MessageDao messageDao;
    
    @Override
    public void send(Message msg){
        messageDao.send(msg);
    }
    
    @Override
    public List<Message> getMessages(String sender, String receiver){
        return messageDao.getMessages(sender,receiver);
    }
}
