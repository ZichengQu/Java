package com.jdbc;

import java.beans.PropertyVetoException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcTemplateDemo2 {
	//���
	@Test
	public void testAdd() throws PropertyVetoException{
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="insert into t_user(name,password,email) values(?,?,?)";
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		int rows = jdbcTemplate.update(sql, "������","123456","zsf@qq.com");
		System.out.println(rows);
	}
	
}
