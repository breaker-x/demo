package com.bx.test;

import java.math.BigDecimal;



public class Test {
	public static void main(String[] args) {
		/*GenDemo<Integer> genOb = new GenDemo<Integer>(88);
		genOb.showType();
		int i = genOb.getOb();
		System.out.println("value = " + i);*/
		int []order = {8,2,3,1,9,7,6,4,5};
		int temp = 0;
		for(int i = 0; i < order.length - 1; i++){
			for(int j = 0; j < order.length - i - 1; j++){
				if(order[j] < order[j + 1]){
					temp = order[j];
					order[j] = order[j + 1];
					order[j + 1] = temp;
				}
			}
		}
		for(int i = 0; i < order.length; i++){
			System.out.println(order[i]);
		}
		System.out.println("int 最大值：" + Integer.MAX_VALUE + "\n" + "int最小值：" + Integer.MIN_VALUE);
		Integer ia = new Integer(1);
		Integer ib = 1;
		Double da = 1.0;
		Double db = 1.0;
		BigDecimal ba = BigDecimal.valueOf(1.22);
		BigDecimal bb = BigDecimal.valueOf(1.22);
		String sa = "123";
		String sb = "123";
		System.out.println("equals : " + ia.equals(ib) + "; " + "== : " + (ia == ib));
		System.out.println("equals : " + da.equals(db) + "; " + "== : " + (da == db));
		System.out.println("equals : " + ba.equals(bb) + "; " + "== : " + (ba == bb));
		ba = ba.add(bb);
		System.out.println(ba);
		System.out.println(sa.equals(sb) + "; " + (sa == sb));
	}
	
}
