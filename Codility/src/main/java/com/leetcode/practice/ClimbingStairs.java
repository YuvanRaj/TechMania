package com.leetcode.practice;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(5));
	}

	public static int climbStairs(int n) {
		int count = n % 2 == 0 ? n : n + 1;
		return count;
	}

}
