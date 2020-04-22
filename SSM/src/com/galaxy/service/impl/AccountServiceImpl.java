package com.galaxy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.galaxy.bean.Account;
import com.galaxy.dao.AccountDao;
import com.galaxy.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Resource
	private AccountDao accountDao;

	@Override
	public Account login(Account account) {
		return accountDao.login(account);
	}

}
