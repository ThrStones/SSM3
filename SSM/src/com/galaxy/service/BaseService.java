package com.galaxy.service;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
	
	public List<T> queryAllByPage(int pageNum,int pageSize,T t);
	
	public Map<String,Integer> queryTotalPage(int pageSize,T t);
	
	public void insert(T t);
	
	public void delete(int[] ids,String tableName);
	
	public T queryById(int id);
	
	public int update(T t);
	
}
