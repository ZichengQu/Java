package com.jdbc;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.bean.User;

public class JdbcTemplateDemo1 {
	//���
	@Test
	public void testAdd1(){
		//��������Դ���������ݿ���Ϣ
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/userdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//����jdbcTemplate����������Դ
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		String sql="insert into t_user(name,password,email) values(?,?,?)";
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		int rows = jdbcTemplate.update(sql, "������","123456","zsf@qq.com");
		System.out.println(rows);
	}
	@Test
	public void testAdd2(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="insert into t_user(name,password,email) values(?,?,?)";
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		int rows = jdbcTemplate.update(sql, "���޼�","123456","zwj@qq.com");
		System.out.println(rows);
	}
	//ɾ��
	@Test
	public void testDelete(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="delete from t_user where name=?";
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		int rows = jdbcTemplate.update(sql, "���޼�");
		System.out.println(rows);
	}
	//�޸�
	@Test
	public void testUpdate(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="update t_user set password=? where name=?";
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		int rows = jdbcTemplate.update(sql, "888", "������");
		System.out.println(rows);
	}
	//��ѯ�����ж�������¼
	@Test
	public void testCount(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="select count(*) from t_user";
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		Integer nums = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(nums);
	}
	//��ѯ���ض���
	@Test
	public void testObject(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="select * from t_user where name=?";
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, "������");
		System.out.println(user);

	}
	//��ѯ���ؼ���
	@Test
	public void testList(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="select * from t_user";
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		List<User> list= jdbcTemplate.query(sql, rowMapper);
		System.out.println(list);
	}
	
}
