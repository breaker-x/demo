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
		Assert.assertEquals("", add_rel, delta);
	}
	
	@Test
	public void testMinus(){
		int a = 1;
		int b = 1;
		int delta = 0;
		int minus_rel = cal.minus(a, b);
		Assert.assertEquals("", minus_rel, delta);
	}
	
	@Test
	public void testDivide(){
		int a = 1;
		int b = 1;
		int delta = 1;
		int divide_rel = cal.divide(a, b);
		Assert.assertEquals(delta, divide_rel);
	}
	
	/*@Test(expected = ArithmeticException.class)
	public void testDivideException(){
		int rel = cal.divide(1, 1);
		Assert.assertEquals(1, rel);
	}*/
	
	@Test
	public void testMul(){
		int a = 1;
		int b = 1;
		int delta = 1;
		int mul_rel = cal.mul(a, b);
		Assert.assertEquals(delta, mul_rel);
	}
	
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
