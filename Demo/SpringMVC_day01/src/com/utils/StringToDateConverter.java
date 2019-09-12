package com.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//自定义类型转换器: 当使用2000/1/1时会自动封装成Date类型，但是2000-1-1就会报错bad request
public class StringToDateConverter implements Converter<String, Date>{
	@Override
	public Date convert(String arg0) {//String arg0 传入进来的值
		if(arg0 == null) {
			throw new RuntimeException("Please input the date data");
		}else {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return df.parse(arg0);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new RuntimeException("Data Convert Error");
			}
		}
	}
}
