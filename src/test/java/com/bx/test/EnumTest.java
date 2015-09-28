package com.bx.test;


public class EnumTest {
	public enum Light{
		RED("��ɫ",0), GREEN("��ɫ", 1), YELLOW("��ɫ", 2);
		private String name;
		private int index;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}

		private Light(String name, int index){
			this.name = name;
			this.index = index;
		}
		
		@Override
		public String toString(){
			return String.valueOf(this.index);
		}
	}
	public static void main(String[] args) {
		testTraversalEnum();
	}
	
	public static void testTraversalEnum(){
		Light[] allLight = Light.values();
		for(Light light : allLight){
			System.out.println("" + light.getName());
			System.out.println("" + light.ordinal());
			System.out.println("" + light);
		}
	}
}
