package com.galaxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.galaxy.bean.TestBean;

@Repository
public interface TestBeanDao {
	
	@Insert("insert into testBean values(0,#{name})")
	public void insert(TestBean testBean);
	
	@Delete("delete from testBean where id = #{id}")
	public void delete(int id);
	
	@Update("update testBean set name=#{name} where id =#{id}")
	public void update(TestBean testBean);
	
	@Select("select * from testBean where id=#{id}")
	public TestBean queryById(int id);
	
	@Select("select count(*) from testBean")
	public int queryTotalCount();
	
	@Select("select * from testBean")
	public List<TestBean> queryAllByPage();

}
