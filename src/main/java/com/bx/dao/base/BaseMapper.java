package com.bx.dao.base;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bx.dao.interceptor.page.Page;

public interface BaseMapper<T extends Serializable, ID> {
	int deleteByPrimaryKey(ID id);

 	int insert(T t);

 	int insertSelective(T t);

    T selectByPrimaryKey(ID id);
    
    Page<T> selectByPage(@Param("page") Page<T> page,@Param("entity")Object...obj );
    
    List<T> selectAll(@Param("entity") Object...object);
    
    List<T> selectBySelective(T t);
    
    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}
