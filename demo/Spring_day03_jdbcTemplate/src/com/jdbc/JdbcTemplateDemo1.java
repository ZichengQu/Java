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
	//添加
	@Test
	public void testAdd1(){
		//创建数据源，设置数据库信息
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/userdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//创建jdbcTemplate，设置数据源
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		String sql="insert into t_user(name,password,email) values(?,?,?)";
		//调用jdbcTemplate对象里面的方法实现操作
		int rows = jdbcTemplate.update(sql, "张三丰","123456","zsf@qq.com");
		System.out.println(rows);
	}
	@Test
	public void testAdd2(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="insert into t_user(name,password,email) values(?,?,?)";
		//调用jdbcTemplate对象里面的方法实现操作
		int rows = jdbcTemplate.update(sql, "张无忌","123456","zwj@qq.com");
		System.out.println(rows);
	}
	//删除
	@Test
	public void testDelete(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="delete from t_user where name=?";
		//调用jdbcTemplate对象里面的方法实现操作
		int rows = jdbcTemplate.update(sql, "张无忌");
		System.out.println(rows);
	}
	//修改
	@Test
	public void testUpdate(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="update t_user set password=? where name=?";
		//调用jdbcTemplate对象里面的方法实现操作
		int rows = jdbcTemplate.update(sql, "888", "张三丰");
		System.out.println(rows);
	}
	//查询表中有多少条记录
	@Test
	public void testCount(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="select count(*) from t_user";
		//调用jdbcTemplate对象里面的方法实现操作
		Integer nums = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(nums);
	}
	//查询返回对象
	@Test
	public void testObject(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="select * from t_user where name=?";
		//调用jdbcTemplate对象里面的方法实现操作
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, "张三丰");
		System.out.println(user);

	}
	//查询返回集合
	@Test
	public void testList(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
		String sql="select * from t_user";
		//调用jdbcTemplate对象里面的方法实现操作
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		List<User> list= jdbcTemplate.query(sql, rowMapper);
		System.out.println(list);
	}
	
}
