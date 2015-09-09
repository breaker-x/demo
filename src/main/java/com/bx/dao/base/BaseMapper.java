package com.bx.dao.base;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T extends Serializable, ID> {
	int deleteByPrimaryKey(ID id);

 	int insert(T t);

 	int insertSelective(T t);

    T selectByPrimaryKey(ID id);
    
    List<T> selectAll(@Param("entity") Object...object);
    
    List<T> selectBySelective(T t);
    
    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}
