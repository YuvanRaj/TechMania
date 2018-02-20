package com.codility.arrays;

import java.util.HashMap;
import java.util.Map;

public class OddOccurencesInArray {

	public static void main(String[] args) {
		int[] arr = { 9, 3, 9, 3, 5 };
		System.out.println("Using HashMap " + solution1(arr));
		System.out.println("Using XOR " + solution2(arr));
	}

	private static int solution2(int[] arr) {
		int val = arr[0];
		for (int i = 1; i < arr.length; i++) {
			val = val ^ arr[i];
		}
		return val;
	}

	private static int solution1(int[] arr) {
		Map<Integer, Integer> opMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (opMap.get(arr[i]) != null) {
				int oldVal = opMap.get(arr[i]) + 1;
				opMap.put(arr[i], oldVal);
			} else {
				opMap.put(arr[i], 1);
			}
		}
		int output = 0;

		for (Map.Entry<Integer, Integer> entry : opMap.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				output = entry.getKey();
				break;
			}
		}
		return output;
	}

}
