package com.bx.unit;

public class GenDemo<T> {
	private T ob;
	public GenDemo(T ob){
		this.ob = ob;
	}
	
	public T getOb(){
		return ob;
	}
	
	public void setOb(T ob){
		this.ob = ob;
	}
	
	public void showType(){
		System.out.println("T的实际类型是：" + ob.getClass().getName());
	}
}
