package com.yuvaraj.techlearning;

import java.util.Arrays;

public class FindMedian {

	public static void main(String[] args) {
		int[] arr = new int[] {0, 1, 2, 4, 6, 5, 3};
		System.out.println(findMedian(arr));
	}
	
	static int findMedian(int[] arr) {
        Arrays.sort(arr);        
        return arr[((arr.length+1)/2)-1];
    }

}
