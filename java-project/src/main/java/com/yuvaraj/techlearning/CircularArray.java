package com.yuvaraj.techlearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CircularArray {

	public static void main(String[] args) {
		List<Integer> arr1 = Arrays.asList(1,3,2,3);
		System.out.println(circularArray(3, arr1));
	}
	
	static class Pair { 
        int x, y; 
        Pair(int p, int q) 
        { 
            x = p; 
            y = q; 
        } 
    } 
	
	static final Comparator<Pair> com = new Comparator<Pair>() { 
        public int compare(Pair a, Pair b) 
        { 
            if (Integer.compare(a.x, b.x) != 0) 
                return Integer.compare(a.x, b.x); 
            else
                return Integer.compare(a.y, b.y); 
        } 
    };
	
	public static int circularArray(int n, List<Integer> endNode) {
	    // Write your code here
		int[] arr = endNode.stream()
				.mapToInt(Integer::intValue)
				.toArray();
		
		// Declare a Pair[] array of size n 
        Pair[] val = new Pair[n]; 
  
        // Store all the (element, index) pairs 
        for (int i = 0; i < n; i++) 
            val[i] = new Pair(arr[i], i); 
  
        // Sort the pairs in ascending order of the value 
        Arrays.sort(val, com); 
  
        int min_dist = 0; 
        for (int i = 1; i < n; i++) { 
  
            // Choose the minimum distance path 
            // of the two available 
            min_dist 
                += Math.min(Math.abs(val[i].y - val[i - 1].y), 
                            n - Math.abs(val[i].y - val[i - 1].y)); 
        } 
  
        return min_dist; 
	}

}
