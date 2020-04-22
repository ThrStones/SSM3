package com.galaxy.service;

import java.util.List;
import java.util.Map;

import com.galaxy.bean.Emp;

public interface EmpService {

	public List<Emp> queryAllByPage(Emp emp, int pageNum, int pageSize);

	public Map<String,Integer> queryTotalPage(Emp emp, int pageNum, int pageSize);

	public void insert(Emp emp);

	public void delete(int[] ids);

	public Emp queryById(int id);

	public int update(Emp emp);

}
