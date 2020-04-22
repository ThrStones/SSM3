package com.galaxy.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.galaxy.bean.Account;

@Repository
public interface AccountDao {
	
	@Select("select * from account where name=#{name} and password=#{password}")
	public Account login(Account account);

}
