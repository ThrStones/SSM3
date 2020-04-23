package com.galaxy.service;

import java.util.List;
import java.util.Map;

import com.galaxy.bean.Meeting;

public interface MeetingService {
	
	public List<Meeting> queryAllByPage(int pageNum,int pageSize,String title);
	
	public Map<String,Integer> queryTotalPage(int pageSize,String title);
	
	public void insert(Meeting meeting);
	
	public void delete(int[] ids);
	
	public Meeting queryById(int id);
	
	public int update(Meeting meeting);

}
