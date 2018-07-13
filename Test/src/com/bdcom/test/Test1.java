package com.bdcom.test;

public class Test1 {
	
	public  Object instance = null;
	public  static void main(String args[]){
		Test1 obj_A = new Test1();
		Test1 obj_B = new Test1();
		obj_A.instance = obj_B;
		obj_B.instance = obj_A;
		obj_A = null;
		obj_B = null;
		
		System.gc();
	}
}
