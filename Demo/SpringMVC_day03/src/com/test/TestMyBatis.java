package com.test;

import com.dao.AccountDao;
import com.bean.Account;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    /**
     * ���Բ�ѯ
     * @throws Exception
     */
    /*
    @Test
    public void run1() throws Exception {
        // ���������ļ�
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // ����SqlSessionFactory����
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // ����SqlSession����
        SqlSession session = factory.openSession();
        // ��ȡ���������
        AccountDao dao = session.getMapper(AccountDao.class);
        // ��ѯ��������
        List<Account> list = dao.findAll();
        for(Account account : list){
            System.out.println(account);
        }
        // �ر���Դ
        session.close();
        in.close();
    }
    */

    /**
     * ���Ա���
     * @throws Exception
     */
	/*
    @Test
    public void run2() throws Exception {
        Account account = new Account();
        account.setName("�ܴ�");
        account.setMoney(400d);

        // ���������ļ�
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // ����SqlSessionFactory����
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // ����SqlSession����
        SqlSession session = factory.openSession();
        // ��ȡ���������
        AccountDao dao = session.getMapper(AccountDao.class);

        // ����
        dao.saveAccount(account);

        // �ύ����
        session.commit();

        // �ر���Դ
        session.close();
        in.close();
    }
    */

}
