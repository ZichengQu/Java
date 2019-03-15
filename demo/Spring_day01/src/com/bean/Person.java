package com.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
	private String pname;
	private String[] array;
	private List<String> list;
	private Map<String,Object> map;
	private Properties properties;
	
	public void setArray(String[] array) {
		this.array = array;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void test(){
		System.out.println("pname="+pname);
		System.out.println("array="+Arrays.toString(array));
		System.out.println("list="+list);
		System.out.println("map="+map);
		System.out.println("properties="+properties);
	}
}
