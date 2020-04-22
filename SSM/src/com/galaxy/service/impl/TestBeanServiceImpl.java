package com.galaxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.galaxy.bean.TestBean;
import com.galaxy.dao.TestBeanDao;
import com.galaxy.service.TestBeanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TestBeanServiceImpl implements TestBeanService {

	@Resource
	private TestBeanDao testBeanDao;

	@Override
	public void insert(TestBean testBean) {
		testBeanDao.insert(testBean);
	}

	@Override
	public void delete(int id) {
		testBeanDao.delete(id);
	}

	@Override
	public void update(TestBean testBean) {
		testBeanDao.update(testBean);
	}

	@Override
	public TestBean queryById(int id) {
		return testBeanDao.queryById(id);
	}

	@Override
	public int queryTotalPage(int pageSize) {
		int totalCount = testBeanDao.queryTotalCount();
		int totalPage = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
		return totalPage;
	}

	@Override
	public List<TestBean> queryAllByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<TestBean> testBeanList = testBeanDao.queryAllByPage();
		new PageInfo<>(testBeanList);
		return testBeanList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
