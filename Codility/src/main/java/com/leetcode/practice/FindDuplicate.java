package com.leetcode.practice;

import java.util.Arrays;

public class FindDuplicate {

	public static void main(String[] args) {
		FindDuplicate findDuplicate = new FindDuplicate();
		int[] nums = new int[] {2,2,2,2,2 };
		System.out.println(findDuplicate.findDuplicate(nums));
	}

	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int actualSize = nums.length - 1;
		int total = ((actualSize) * (actualSize + 1)) / 2;
		return sum - total;
	}
}
