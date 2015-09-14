package com.bx.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bx.unit.Calcuate;

public class CalcuateTest {
	Calcuate cal;
	
	@Before
	public void setUp(){
		cal = new Calcuate();
	}
	
	@Test
	public void testAdd(){
		int a = 1;
		int b = 1;
		int add_rel = cal.add(a, b);
		int delta = 2;
		Assert.assertEquals("加法有问题", add_rel, delta);
	}
	
	@Test
	public void testMinus(){
		int a = 1;
		int b = 1;
		int delta = 0;
		int minus_rel = cal.minus(a, b);
		Assert.assertEquals("减法有问题", minus_rel, delta);
	}
	
	@Test
	public void testDivide(){
		int a = 1;
		int b = 1;
		int delta = 1;
		int divide_rel = cal.divide(a, b);
		Assert.assertEquals(delta, divide_rel);
	}
	
	
	/*测试该方法有没有抛出异常
	 * 如果抛出了异常，则执行通过
	 * 如果没有，则执行不通过
	 * */
	@Test(expected = ArithmeticException.class)
	public void testDivideException(){
		int rel = cal.divide(1, 1);
		Assert.assertEquals(1, rel);
	}
	
	@Test
	public void testMul(){
		int a = 1;
		int b = 1;
		int delta = 1;
		int mul_rel = cal.mul(a, b);
		Assert.assertEquals(delta, mul_rel);
	}
	
	/*测试方法的性能
	 * 如果没有在规定的时间内完成，则执行不通过
	 * */
	
	@Test(timeout = 1000)
	public void time(){
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		int rel = cal.divide(2, 1);
		Assert.assertEquals(2, rel);
	}
}
