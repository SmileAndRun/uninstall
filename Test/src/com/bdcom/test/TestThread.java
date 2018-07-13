package com.bdcom.test;

import java.util.Scanner;

public class TestThread {

	public static void createBusyThread() {

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true)
					;
			}
		}, "testThread");
		thread1.start();
	}

	public static void createLockThread(final Object lock){
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		},"testThread1");
		thread.start();
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextLine();
		createBusyThread();
	}

}
