package com.galaxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import com.galaxy.bean.Meeting;

@Repository
public interface MeetingDao extends BaseDao<Meeting>{
	
	@Select("<script>"
			+ "select * from meeting "
			+ "<where>"
			+ "<if test=\"title!=null and title!=''\">"
			+ "<bind name=\"mTitle\" value=\"'%'+title+'%'\"/>"
			+ "and title like #{mTitle} "
			+ "</if></where>"
			+ "order by id desc"
			+ "</script>")
	@Results({
		@Result(id=true, property="id", column="id"),
		@Result(property="beginTime", column="beginTime"),
		@Result(property="endTime", column="endTime"),
		@Result(property="title", column="title"),
		@Result(property="content", column="content"),
		@Result(property="address", column="address"),
		@Result(property="account", column="accountId",
			one = @One(select="com.galaxy.dao.AccountDao.queryById",
			fetchType = FetchType.EAGER ))
	})
	public List<Meeting> queryAllByPage(String title);
	
	@Select("<script>"
			+ "select count(*) from meeting "
			+ "<where>"
			+ "<if test=\"title!=null and title!=''\">"
			+ "<bind name=\"mTitle\" value=\"'%'+title+'%'\"/>"
			+ "and title like #{mTitle} "
			+ "</if></where>"
			+ "order by id desc"
			+ "</script>")
	public int queryTotalCount(String title);
	
	@Insert("insert into meeting values(0,#{empId},#{beginTime},#{endTime},#{title},#{content},#{address})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	public void insert(Meeting meeting);

	@Select("select * from meeting where id=#{id}")
	public Meeting queryById(int id);
	
	@Update("update meeting set beginTime=#{beginTime},endTime=#{endTime},title=#{title},content=#{content},address=#{address} where id=#{id}")
	public int update(Meeting meeting);

}
