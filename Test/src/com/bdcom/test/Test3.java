package com.bdcom.test;

import java.util.Scanner;

public class Test3 {

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("请输入n：");
		int n = in.nextInt();
		System.out.println("输入的n为："+n);
		int[] nums = new int[n+1];
		nums[0] = 0;
		nums[1] = 1;
		nums[2] = 2;
		
		for(int i = 3;i<=n;i++){
			nums[i] = nums[i-1] + nums[i-2];
		}
			
		System.out.println(nums[n]);
	}

}
