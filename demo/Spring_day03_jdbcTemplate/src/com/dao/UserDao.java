package com.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bean.User;

public class UserDao {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<User> select(){
		String sql="select * from t_user";
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		List<User> list = jdbcTemplate.query(sql, rowMapper);
		return list;
	}
}
