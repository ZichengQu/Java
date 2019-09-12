package com.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//�Զ�������ת����: ��ʹ��2000/1/1ʱ���Զ���װ��Date���ͣ�����2000-1-1�ͻᱨ��bad request
public class StringToDateConverter implements Converter<String, Date>{
	@Override
	public Date convert(String arg0) {//String arg0 ���������ֵ
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
