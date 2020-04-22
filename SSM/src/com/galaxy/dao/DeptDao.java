package com.galaxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.galaxy.bean.Dept;

@Repository
public interface DeptDao {
	
	/*
	 * 分析条件查询
	 * 判断条件是否存在的问题
	 * 	<select id="queryAllByCondition" parameterType="department" resultType="department">
		select * from department 
		<where>
			<if test="name!=null and name!=''">
				<bind name="dName" value="'%'+name+'%'"/>
				and name like #{dName}
			</if>
		</where>
	</select>
	 */
	
	//@Select("select * from dept order by id desc")
	@Select("<script>"
			+ "select * from dept "
			+ "<where>"
			+ "<if test=\"name!=null and name!=''\">"
			+ "<bind name=\"dName\" value=\"'%'+name+'%'\"/>"
			+ "and name like #{dName} "
			+ "</if></where>"
			+ "order by id desc"
			+ "</script>")
	public List<Dept> queryAllByPage(String name);
	
	//@Select("select count(*) from dept")
	@Select("<script>"
			+ "select count(*) from dept "
			+ "<where>"
			+ "<if test=\"name!=null and name!=''\">"
			+ "<bind name=\"dName\" value=\"'%'+name+'%'\"/>"
			+ "and name like #{dName} "
			+ "</if></where>"
			+ "order by id desc"
			+ "</script>")
	public int queryTotalCount(String name);
	
	@Insert("insert into dept values(0,#{departNo},#{name},#{description})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	public void insert(Dept dept);
	
	@Delete("delete from dept where id=#{id}")
	public void delete(int id);
	
	@Select("select * from dept where id=#{id}")
	public Dept queryById(int id);
	
	@Update("update dept set name=#{name},description=#{description} where id=#{id}")
	public int update(Dept dept);

}
