package com.galaxy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao<T> {

	@Delete("delete from ${tableName} where id=#{id}")
	public void delete(@Param("id") int id,@Param("tableName") String tableName);

}
