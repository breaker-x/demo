package com.bx.unit;

public class SingleTest {
	private static class SingletonHolder{
		private static final SingleTest INSTANCE = new SingleTest();
	}
	private SingleTest(){
		
	}
	public static final SingleTest getInstance(){
		return SingletonHolder.INSTANCE;
	}
}
