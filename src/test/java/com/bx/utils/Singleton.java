package com.bx.utils;

public class Singleton {
	private static Singleton singleton = null;
	//private�Ĺ��췽�����ø����޷�ʵ����
	private Singleton(){
		
	}
	public static Singleton getInstance(){
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton;
	}
}
