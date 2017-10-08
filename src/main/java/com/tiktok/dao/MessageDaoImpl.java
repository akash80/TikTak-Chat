/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.dao;

import com.tiktok.model.Message;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author akash
 */
public class MessageDaoImpl implements MessageDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void send(Message msg){
    String sql = "insert into message (sender,receiver,message) values(?,?,?)";
    jdbcTemplate.update(sql, new Object[] { msg.getSender(), msg.getReceiver(), msg.getMessage()});
    }
    
    @Override
    public List<Message> getMessages(String sender, String receiver) {
        String sql = "select sender,receiver,message,message_id from message where sender='"+sender+"' and receiver='"+receiver+"' or sender='"+receiver+"' and "+"receiver='"+sender+"' order by message_id";
        return this.jdbcTemplate.query(sql, new MessageMapper());
    }
}


class MessageMapper implements RowMapper<Message> {
  @Override
  public Message mapRow(ResultSet rs, int arg1) throws SQLException {
    Message msg = new Message();
    msg.setSender(rs.getString("sender"));
    msg.setReceiver(rs.getString("receiver"));
    msg.setMessage(rs.getString("message"));
    msg.setMESSAGE_ID(rs.getString("message_id"));
    
    return msg;
  }
}