package com.bx.service.base;

import java.io.Serializable;
import java.util.List;


public interface IBaseService<T extends Serializable, ID> {
public T add(T t);
	
	public void update(T t);
	
	public void delete(ID id);
	
	public void delete(T t);
	
	public T SelectByKey(ID id);
	
	public List<T> selectAll(Object...object);

	public List<T> selectBySelective(T t);
	
}
