package com.bx.test;


public class SingletonTest {
	public static class SingletonHolder{
		private final static SingletonTest INSTANCE = new SingletonTest();
	}
	private SingletonTest(){};
	public static SingletonTest getInstance(){
		return SingletonHolder.INSTANCE;
	}
}
