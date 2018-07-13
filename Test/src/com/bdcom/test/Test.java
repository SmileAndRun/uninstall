package com.bdcom.test;



public class Test {
	
	public static Test test = null;
	public static Test test1 = null;
	public void print(){
		System.out.println("print：自救");
	}
	
	@Override
	protected void finalize() throws Throwable {//当系统的gc方法被调用时此方法也被调用
		System.out.println("自救");
		test = this;
		//System.out.println(test==null?"死了":"还活着");
	}
	@SuppressWarnings("static-access")
	public  static void main(String[] args) throws Throwable{
		
		test = new Test();
		test = null;
		
		//虚拟机会创建一个finallizer的低优先级的线程因此需要将当前线程休息一秒给finallizer线程执行
		System.gc();
		System.out.println("第一次回收的结果：");
		Thread.currentThread().sleep(1000);
		if(test == null){
			System.out.println("我死了");
		}else{
			System.out.println("我还活着");
		}
		
		//第二次观测
		test = null;
		System.gc();
		System.out.println("第二次回收的结果：");
		Thread.currentThread().sleep(1000);
		if(test == null){
			System.out.println("我死了");
		}else{
			System.out.println("我还活着");
		}
	}

}


