package com.yuvaraj.techlearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<Integer> arr1 = Arrays.asList(1,2,3);
    	List<Integer> arr2 = Arrays.asList(2,5,5);
        System.out.println(mergeArrays(arr1, arr2));
    }
    
    public static List<Integer> mergeArrays(List<Integer> a,List<Integer> b){
    	
    	int[] arr1 = a.stream()
				.mapToInt(Integer::intValue)
				.toArray();
    	int[] arr2 = b.stream()
				.mapToInt(Integer::intValue)
				.toArray();
    	
    	int n1=arr1.length;
    	int n2=arr2.length;
    	int i = 0, j = 0, k = 0; 
    	int[] arr3 = new int[n1+n2];
        // Traverse both array 
        while (i<n1 && j <n2) 
        { 
            // Check if current element of first 
            // array is smaller than current element 
            // of second array. If yes, store first 
            // array element and increment first array 
            // index. Otherwise do same with second array 
            if (arr1[i] < arr2[j]) 
                arr3[k++] = arr1[i++]; 
            else
                arr3[k++] = arr2[j++]; 
        } 
      
        // Store remaining elements of first array 
        while (i < n1) 
            arr3[k++] = arr1[i++]; 
      
        // Store remaining elements of second array 
        while (j < n2) 
            arr3[k++] = arr2[j++]; 
    	
        List<Integer> list = Arrays.stream(arr3)		
				.boxed()  	
				.collect(Collectors.toList());
        return list;
    }
}
