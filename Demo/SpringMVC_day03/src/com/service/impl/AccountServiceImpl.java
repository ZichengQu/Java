package com.service.impl;

import com.dao.AccountDao;
import com.bean.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

//    @Autowired
//    private AccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("ҵ��㣺��ѯ�����˻�...");
        return null;
        //return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("ҵ��㣺�����ʻ�...");
        //accountDao.saveAccount(account);
    }
}
