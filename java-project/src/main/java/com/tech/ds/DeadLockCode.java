package com.tech.ds;

/**
 * The join() method waits for the current thread to die.
 * Here the Current Thread is Main Thread so the program will be unterminated 
 * @author Yuvaraj
 *
 */
public class DeadLockCode {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Dead Lock in Single Liner");
		System.out.println("Before Dead Lock");
		Thread.currentThread().join();
		System.out.println("After Dead Lock");
	}

}
