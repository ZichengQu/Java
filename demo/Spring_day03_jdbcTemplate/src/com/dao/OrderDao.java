package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//������Ǯ�ķ���
	public void lessMoney(){
		String sql="update account set salary=salary-? where username=?";
		jdbcTemplate.update(sql,1000,"����");
	}
	//���Ķ�Ǯ�ķ���
	public void moreMoney(){
		String sql="update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql,1000,"����");
	}

}
