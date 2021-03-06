/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiktok.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.tiktok.model.Login;
import com.tiktok.model.User;
public class UserDaoImpl implements UserDao {
  @Autowired
  JdbcTemplate jdbcTemplate;
  @Override
  public void register(User user) {
    String sql = "insert into user (username,password,name,email,phone) values(?,?,?,?,?)";
    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getPhone()});
    }
  @Override
    public User validateUser(Login login) {
    String sql = "select * from user where username='" + login.getUsername() + "' and password='" + login.getPassword()
    + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
  @Override
    public User validatedUser(String username){
    String sql = "select * from user where username='"+username+"'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
    @Override
    public List<User> getUsers(String username) {
        String sql = "select username,name,email,phone from user where username!='"+username+"'";
        return this.jdbcTemplate.query(sql, new UserMapper());
    }
  }
  class UserMapper implements RowMapper<User> {
  @Override
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setUsername(rs.getString("username"));
    user.setName(rs.getString("name"));
    user.setEmail(rs.getString("email"));
    user.setPhone(rs.getString("phone"));
    return user;
  }
}