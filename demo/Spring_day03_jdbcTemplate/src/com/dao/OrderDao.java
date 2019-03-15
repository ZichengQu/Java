package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//张三少钱的方法
	public void lessMoney(){
		String sql="update account set salary=salary-? where username=?";
		jdbcTemplate.update(sql,1000,"张三");
	}
	//李四多钱的方法
	public void moreMoney(){
		String sql="update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql,1000,"李四");
	}

}
