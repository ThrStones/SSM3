package com.galaxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.galaxy.bean.Emp;

@Repository
public interface EmpDao {
	
	
	@Select("<script>"
			+ "select * from emp "
			+ "<where>"
			+ "<if test=\"eNo!=null and eNo!=''\">"
			+ "<bind name=\"empNo\" value=\"'%'+eNo+'%'\"/>"
			+ "and eNo like #{empNo} "
			+ "</if>"
			+ "<if test=\"name!=null and name!=''\">"
			+ "<bind name=\"eName\" value=\"'%'+name+'%'\"/>"
			+ "and name like #{eName} "
			+ "</if></where>"
			+ "order by id desc"
			+ "</script>")
	public List<Emp> queryAllByPage(Emp emp);
	
	@Select("<script>"
			+ "select count(*) from emp "
			+ "<where>"
			+ "<if test=\"eNo!=null and eNo!=''\">"
			+ "<bind name=\"empNo\" value=\"'%'+eNo+'%'\"/>"
			+ "and eNo like #{empNo} "
			+ "</if>"
			+ "<if test=\"name!=null and name!=''\">"
			+ "<bind name=\"eName\" value=\"'%'+name+'%'\"/>"
			+ "and name like #{eName} "
			+ "</if></where>"
			+ "order by id desc"
			+ "</script>")
	public int queryTotalCount(Emp emp);
	
	
	
	@Insert("insert into emp values(0,#{eNo},#{name},#{sex},#{phone},#{dept},#{role},#{state})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(Emp emp);
	
	@Delete("delete from emp where id=#{id}")
	public void delete(int id);
	
	@Select("select * from emp where id=#{id}")
	public Emp queryById(int id);
	
	@Update("update emp set name=#{name},sex=#{sex},phone=#{phone},dept=#{dept},role=#{role} where id=#{id}")
	public int update(Emp emp);


}
