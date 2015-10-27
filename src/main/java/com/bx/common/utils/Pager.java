package com.bx.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import com.bx.dao.interceptor.page.Page;

public class Pager<T> {
	
	private int recordsReturned;
	private int totalRecords;
	private int startIndex;
	private String sort;
	private String dir;
	private int pageSize;
	
	@SuppressWarnings("rawtypes")
	private List records = new ArrayList<Map<String, Object>>();
	
	public Pager() {
		super();
	}
	public Pager(int recordsReturned, int total, int startIndex,
			String sort, String dir, int pageSize, List<Map<String, Object>> rescords) {
		super();
		this.recordsReturned = recordsReturned;
		this.totalRecords = total;
		this.startIndex = startIndex;
		this.sort = sort;
		this.dir = dir;
		this.pageSize = startIndex+records.size();
		this.records = rescords;
	}
	
	public  Pager<T> wrapPager(Page<T> page) throws Exception{

		this.setRecordsReturned(page.getRecordsReturned());
		this.setDir(page.getDir());

		this.setSort(page.getSort());
		this.setStartIndex(page.getStartIndex());
		this.setPageSize(page.getPageSize());
		this.setTotalRecords(page.getTotalRecords());
		if(StringUtils.isEmpty(page.getNeeded())){
			this.records = page.getRecords();
		}else{
			this.setRecords(page.getRecords(),page.getNeeded());
		}
		
		return this;
	}
	
	
	public static String paintTitle(String [] columns , Map<String, String> groupMap){
		StringBuffer columnStr = new StringBuffer();
		if(columns != null){
			for(int i =0;i<columns.length;i++){
				if(groupMap.containsKey(columns[i])){
					columnStr.append(groupMap.get(columns[i]) + ",");
				}
			}

		}else{
			for(String group : groupMap.values()){
				columnStr.append(group + ",");
			}
		}
		if(columnStr.length() != 0 && columnStr.charAt(columnStr.length()-1) == ','){
			columnStr.replace(columnStr.length()-1, columnStr.length(), "");
		}
		return columnStr.toString();
	}
	/*
	 * 解析page中的needed，映射为相应的方法
	 * 调用相应的方法重新组装list
	 * 支持ognl形式的调用
	 */
	private void setRecords(List<T> list,String needed) throws Exception{
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for(T t:list){
			HashMap<String, Object> item = new HashMap<String, Object>();
			String [] params = needed.split(",");
			for (String key : params) {
				String[] methods ;

				methods= key.split("\\.");	
				if(key.lastIndexOf(".")!=-1){
					key = key.substring(key.lastIndexOf(".")+1);
				}

				item.put(key,invokeMethods(methods,t));
				
			}
			result.add(item);
		}

		this.records = result;
	}
	
	
	private Object invokeMethods(String[] methods,Object obj) throws Exception{
		
		if(obj == null){
			return null;
		}
		if(methods.length==1){
			methods[0] = "get"+methods[0].replaceFirst(".",String.valueOf(methods[0].charAt(0)).toUpperCase());
			return obj.getClass().getMethod(methods[0]).invoke(obj);
		}else if(methods.length>1){
			methods[0] = "get"+methods[0].replaceFirst(".",String.valueOf(methods[0].charAt(0)).toUpperCase());
			obj = obj.getClass().getMethod(methods[0]).invoke(obj);
			String [] newMethods = new String[methods.length-1];
			System.arraycopy(methods, 1, newMethods, 0, methods.length-1);
			//如果返回值为数组
			if(obj!=null&&List.class.isAssignableFrom(obj.getClass())){
				List<Object> result = new ArrayList<Object>();
				for (Object subEntry:(List<?>)obj) {
					result.add(invokeMethods(newMethods,subEntry));
				}
				return result;
				
			}else return invokeMethods(newMethods,obj);
	
		}else{
			return null;
		}
		
	}
	
	public int getRecordsReturned() {
		return recordsReturned;
	}
	public void setRecordsReturned(int recordsReturned) {
		this.recordsReturned = recordsReturned;
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
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@SuppressWarnings("rawtypes")
	public List getRecords() {
		return records;
	}
	

	
	
}
