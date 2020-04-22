package com.galaxy.service;

import java.util.List;

import com.galaxy.bean.TestBean;

public interface TestBeanService {
	
	public void insert(TestBean testBean);
	
	public void delete(int id);
	
	public void update(TestBean testBean);
	
	public TestBean queryById(int id);
	
	public int queryTotalPage(int pageSize);
	
	public List<TestBean> queryAllByPage(int pageNum,int pageSize);
}
