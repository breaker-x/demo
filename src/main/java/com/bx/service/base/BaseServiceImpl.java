package com.bx.service.base;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bx.dao.base.BaseMapper;

public class BaseServiceImpl<T extends Serializable, ID, baseDao extends BaseMapper<T, ID>> implements IBaseService<T,ID> {
	private Class<T> modelClass;
	private Class<ID> keyClass;
	protected baseDao basedao;
	
	@Autowired
	public void setBasedao(baseDao basedao) {
		this.basedao = basedao;
	}

	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		super();
		if(modelClass == null)
			modelClass = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
		if(keyClass == null)
			keyClass = (Class<ID>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		
	}
	public T add(T t) {
		basedao.insertSelective(t);
		return t;
	}

	public void update(T t) {
		basedao.updateByPrimaryKeySelective(t);
	}

	public void delete(ID id) {
		
		T t = null;
		try {
			t = modelClass.newInstance();
			Method setId = modelClass.getMethod("setId", keyClass);
			setId.invoke(t, id);	
			Method delete = modelClass.getMethod("setDeletedflg", String.class);
			delete.invoke(t, "1");	
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	
		basedao.updateByPrimaryKeySelective(t);
	}

	public T SelectByKey(ID id) {
		return basedao.selectByPrimaryKey(id);
	}

	public List<T> selectAll(Object... object) {
		return basedao.selectAll(object);
	}

    public List<T> selectBySelective(T t) {
    	return basedao.selectBySelective(t);
    }
	public void delete(T t) {
		Method delete;
		try {
			delete = modelClass.getMethod("setDeletedflg", String.class);
			delete.invoke(t, "1");	
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		basedao.updateByPrimaryKeySelective(t);
	}
}
