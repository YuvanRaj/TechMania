package com.tech.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OptimizingBoxWeight {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(1,2,2,3,4,5);
		System.out.println(minimalHeaviestSetA(arr));

	}

	public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
		long aSetSum = 0L;
		long bSetSum = 0L;

		for (int a : arr) {
			bSetSum += (long) a;
		}
		int lastElement = Integer.MAX_VALUE;

		arr.sort(Collections.reverseOrder());
		List<Integer> minimalHeaviestSetA = new ArrayList<Integer>();

		for (int a : arr) {
			if (aSetSum > bSetSum && lastElement != a) {
				break;
			}
			lastElement = a;
			minimalHeaviestSetA.add(lastElement);
			aSetSum += (long) lastElement;
			bSetSum -= (long) lastElement;
		}

		Collections.reverse(minimalHeaviestSetA);

		return minimalHeaviestSetA;
	}
}
