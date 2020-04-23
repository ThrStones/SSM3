package com.galaxy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.galaxy.bean.Meeting;
import com.galaxy.dao.MeetingDao;
import com.galaxy.service.MeetingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MeetingServiceImpl implements MeetingService {

	@Resource
	private MeetingDao meetingDao;

	@Override
	public List<Meeting> queryAllByPage(int pageNum, int pageSize, String title) {

		PageHelper.startPage(pageNum, pageSize);
		List<Meeting> meetingList = meetingDao.queryAllByPage(title);
		new PageInfo<Meeting>(meetingList);

		return meetingList;
	}

	@Override
	public Map<String, Integer> queryTotalPage(int pageSize, String title) {
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();

		int totalCount = meetingDao.queryTotalCount(title);
		int totalPage = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;

		countMap.put("totalCount", totalCount);
		countMap.put("totalPage", totalPage);

		return countMap;
	}

	@Override
	public void insert(Meeting meeting) {
		meetingDao.insert(meeting);
	}

	@Override
	public void delete(int[] ids) {
		for (int id : ids) {
			meetingDao.delete(id);
		}
	}

	@Override
	public Meeting queryById(int id) {
		return meetingDao.queryById(id);
	}

	@Override
	public int update(Meeting meeting) {
		return meetingDao.update(meeting);
	}

}
