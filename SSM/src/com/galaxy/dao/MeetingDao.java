package com.galaxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.galaxy.bean.Meeting;

@Repository
public interface MeetingDao {
	
	@Select("<script>"
			+ "select * from meeting "
			+ "<where>"
			+ "<if test=\"title!=null and title!=''\">"
			+ "<bind title=\"mTitle\" value=\"'%'+title+'%'\"/>"
			+ "and title like #{mTitle} "
			+ "</if></where>"
			+ "order by id desc"
			+ "</script>")
	public List<Meeting> queryAllByPage(String title);
	
	@Select("<script>"
			+ "select count(*) from meeting "
			+ "<where>"
			+ "<if test=\"title!=null and title!=''\">"
			+ "<bind title=\"mTitle\" value=\"'%'+title+'%'\"/>"
			+ "and title like #{mTitle} "
			+ "</if></where>"
			+ "order by id desc"
			+ "</script>")
	public int queryTotalCount(String title);
	
	@Insert("insert into meeting values(0,#{empId},#{beginTime},#{endTime},#{title},#{content},#{address})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	public void insert(Meeting meeting);
	
	@Delete("delete from meeting where id=#{id}")
	public void delete(int id);
	
	@Select("select * from meeting where id=#{id}")
	public Meeting queryById(int id);
	
	@Update("update meeting set beginTime=#{beginTime},endTime=#{endTime},title=#{title},content=#{content},address=#{address} where id=#{id}")
	public int update(Meeting meeting);

}
