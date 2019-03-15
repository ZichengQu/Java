package com.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="user")
@Scope(value="prototype")
public class User {
	public void add(){
		System.out.println("add......");
		
	}
}
