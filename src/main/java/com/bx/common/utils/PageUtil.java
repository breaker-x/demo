package com.bx.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;

public class PageUtil {
	private static int totalPages;
	
	public static int getTotalPages() {
		return totalPages;
	}
	public static void setTotalPages(int totalPages) {
		PageUtil.totalPages = totalPages;
	}

	

	public static void page(int page,int pageSize,int totalRows,ModelMap map){       
	    if(totalRows==0){
			totalPages=1;
		}else if(totalRows%pageSize==0){
			totalPages=totalRows/pageSize;
		}else{
			totalPages=totalRows/pageSize+1;
		}
	    map.addAttribute("totalPages", totalPages);
	    map.addAttribute("total", totalRows);
	    map.addAttribute("pageSize", pageSize);

		//页码显示
		totalPages=(int)Math.ceil((double)totalRows/pageSize);
		if(totalPages<page){
			page=totalPages;
		}
		if(page<1){
			page=1;
		}
		int listbegin = page - 3;
		if(listbegin < 1){
			listbegin = 1;
		}
		int listend = page + 3;
		if(listend >= totalPages){
			listend = totalPages + 1;
		}
		List<Integer> numList=new ArrayList<Integer>();
		for(int i=listbegin;i<listend;i++){
			numList.add(i);
		}
		if(listbegin > 1)
			map.addAttribute("begin",listbegin);
		if(listend < totalPages + 1)
			map.addAttribute("end", totalPages);
		map.addAttribute("numList", numList);
		map.addAttribute("page", page);
	}
}
