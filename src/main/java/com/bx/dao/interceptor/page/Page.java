package com.bx.dao.interceptor.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bx.common.constant.Const;
import com.bx.common.utils.StringUtil;


/**
 * 
 * <p>分页信息。</p>
 * <p>继承ArrayList是因为如果BaseMapper.getPage方法的返回类型是Page，而mybatis有如下判断：</p>
 * <pre>
 * if (List.class.isAssignableFrom(method.getReturnType())) {
 *    returnsList = true;//即只有返回List才执行selectList。
 * }
 * </pre>
 */
public class Page<T>  extends ArrayList<T> implements Serializable {
	private static final long serialVersionUID = -1241179900114637258L;
	
	/**每页显示几条*/
	private int pageSize = Const.PAGESIZE;
	/**
	 * 是否分页，默认为false表示分页，设为true则不分页
	 */
	public boolean noPaging = false;
	private String sort;

	private String dir;

	private int totalRecords;
	private int startIndex;
	/*
	 * 以逗号分隔的字符串
	 * 如：name，age。。。
	 */
	private String needed;//页面所需的参数
	
	public Page() {
		super();
	}

	/**存放结果集*/
	private List<T> records;

	/**
	 * 
	 * <p>获取结果集</p>
	 *
	 * @return
	 */
	public List<T> getRecords() {
		if (records == null) {
			return new ArrayList<T>();
		}
		return records;
	}
	
	
	public String getNeeded() {
		return needed;
	}


	public void setNeeded(String needed) {
		this.needed = needed;
	}


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return StringUtil.isEmpty(sort)?"id":sort;
	}

	public void setSort(String sort) {
		if(StringUtil.isNotEmpty(sort)&&sort.indexOf(" ") != -1){
			this.sort = "id";
		}else{
			this.sort = sort;
		}
	}

	public String getDir() {
		return StringUtil.isEmpty(dir)?"asc":dir;
	}

	public void setDir(String dir) {
		if("desc".equals(dir)||"asc".equals(dir)){
			this.dir = dir;
		}
	}

	public int getRecordsReturned() {
		return records.size();
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}


    /**
     * @return the noPaging
     */
    public boolean isNoPaging() {
        return noPaging;
    }


    /**
     * @param noPaging the noPaging to set
     */
    public void setNoPaging(boolean noPaging) {
        this.noPaging = noPaging;
    }
	

}