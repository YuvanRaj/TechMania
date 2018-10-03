package com.codility.arrays;

import java.util.HashMap;
import java.util.Map;

public class Testing1 {
	public static void main(String[] args) {
		Map<Character, Integer> characterMapCount = new HashMap<Character, Integer>();
		int previousCount = 1;
		int currentCount = 1;
		int counter = 0;
		String value = "aabbccddeeeff";
		boolean isValidString = true;
		for (Character ch : value.toCharArray()) {
			if (characterMapCount.get(ch) != null) {
				currentCount = characterMapCount.get(ch) + 1;
				characterMapCount.put(ch, currentCount);
			} else {
				counter++;
				if (counter > 2 && previousCount != currentCount) {
					isValidString = false;
					break;
				}
				previousCount = currentCount;
				currentCount = 1;
				characterMapCount.put(ch, currentCount);
			}
		}
		if (isValidString && previousCount == currentCount) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
