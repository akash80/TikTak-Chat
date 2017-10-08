/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.dao;

import com.tiktok.model.Message;
import java.util.List;

/**
 *
 * @author akash
 */
public interface MessageDao {
    
    void send(Message msg);
    
    List<Message> getMessages(String sender, String receiver);
    
}
