package com.test;

import com.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1(){
        // ���������ļ�
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // ��ȡ����
        AccountService as = (AccountService) ac.getBean("accountService");
        // ���÷���
        as.findAll();
    }
}
