package com.bdcom.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestInstanceof {
	
	public static void main(String[]args){
		
		List<User> list = new ArrayList<User>();
		ArrayList<User> arrayList = new ArrayList<User>(); 
		System.out.println(list.getClass());
		Map<User, User> map =new HashMap<User,User>();
		if(list.getClass() == ArrayList.class){
			System.out.println(true);
		}
		
		
	}

}
