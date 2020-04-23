package com.galaxy.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.galaxy.bean.Emp;
import com.galaxy.dao.EmpDao;
import com.galaxy.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class EmpServiceImpl implements EmpService {

	@Resource
	private EmpDao empDao;

	@Override
	public List<Emp> queryAllByPage(Emp emp, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Emp> empList = empDao.queryAllByPage(emp);
		new PageInfo<Emp>(empList);
		return empList;
	}

	@Override
	public Map<String, Integer> queryTotalPage(Emp emp, int pageNum, int pageSize) {
		int totalCount = empDao.queryTotalCount(emp);
		int totalPage = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;

		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		countMap.put("totalCount", totalCount);
		countMap.put("totalPage", totalPage);

		return countMap;
	}

	@Override
	public void insert(Emp emp) {
		String eNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		emp.seteNo("No." + eNo);
		emp.setState("Õý³£");
		empDao.insert(emp);
	}

	@Override
	public void delete(int[] ids) {
		for (int id : ids) {
			empDao.delete(id);
		}
	}

	@Override
	public Emp queryById(int id) {
		return empDao.queryById(id);
	}

	@Override
	public int update(Emp emp) {
		return empDao.update(emp);
	}

}
