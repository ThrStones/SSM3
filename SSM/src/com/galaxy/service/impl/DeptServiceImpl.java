package com.galaxy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.galaxy.bean.Dept;
import com.galaxy.dao.DeptDao;
import com.galaxy.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
//@Scope("prototype")
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptDao deptDao;

	@Override
	public List<Dept> queryAllByPage(int pageNum, int pageSize, String name) {

		PageHelper.startPage(pageNum, pageSize);
		List<Dept> deptList = deptDao.queryAllByPage(name);
		new PageInfo<Dept>(deptList);

		return deptList;
	}

	@Override
	public Map<String, Integer> queryTotalPage(int pageSize, String name) {
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();

		int totalCount = deptDao.queryTotalCount(name);
		int totalPage = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;

		countMap.put("totalCount", totalCount);
		countMap.put("totalPage", totalPage);

		return countMap;
	}

	@Override
	public void insert(Dept dept) {
		deptDao.insert(dept);
	}

	@Override
	public void delete(int[] ids) {
		for (int id : ids) {
			deptDao.delete(id);
		}
	}

	@Override
	public Dept queryById(int id) {
		return deptDao.queryById(id);
	}

	@Override
	public int update(Dept dept) {
		return deptDao.update(dept);
	}

}
