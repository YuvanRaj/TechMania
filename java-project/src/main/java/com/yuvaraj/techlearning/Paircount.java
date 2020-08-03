package com.yuvaraj.techlearning;

import java.util.Arrays;
import java.util.List;

public class Paircount {

	public static void main(String[] args) {
		List<Integer> arr1 = Arrays.asList(1,3,5);
		System.out.println(kDifference(arr1, 2));
	}
	
	public static int kDifference(List<Integer> arr,int k) {
		int count = 0;// Initialize result 
		 
		int[] arr1 = arr.stream()
				.mapToInt(Integer::intValue)
				.toArray();
		
        // Consider all possible pairs and check their sums 
        for (int i = 0; i < arr1.length; i++) 
            for (int j = i + 1; j < arr1.length; j++) 
                if (Math.abs((arr1[i] - arr1[j])) == k ) 
                    count++; 
  
        return count; 
	}

}
