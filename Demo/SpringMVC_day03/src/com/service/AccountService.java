package com.service;

import com.bean.Account;

import java.util.List;

public interface AccountService {

    // ��ѯ�����˻�
    public List<Account> findAll();

    // �����ʻ���Ϣ
    public void saveAccount(Account account);

}
