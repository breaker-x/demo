package com.bx.utils;

public class Singleton {
	private static Singleton singleton = null;
	//private的构造方法，让该类无法实例化
	private Singleton(){
		
	}
	public static Singleton getInstance(){
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton;
	}
}
