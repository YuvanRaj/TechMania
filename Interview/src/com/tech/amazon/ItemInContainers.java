package com.tech.amazon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemInContainers {

	public static void main(String[] args) {
		List<Integer> startIndices = Arrays.asList(1,1);
		List<Integer> endIndices = Arrays.asList(5,6);
		System.out.println(numberOfItems("|**|*|*", startIndices, endIndices));
	}

	public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
		int count = 0;
		List<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < startIndices.size(); i++) {
			int startIndex = startIndices.get(i);
			int endIndex = endIndices.get(i);
			count = 0;
			String filterted = s.substring(startIndex-1, endIndex);
			List<Integer> list = new ArrayList<Integer>();
			char character = '|';
			for (int j = 0; j < filterted.length(); j++) {
				if (filterted.charAt(j) == character) {
					list.add(j);
				}
			}

			String val = "";
			for (int m = 0; m < list.size(); m++) {
				if(m+1 >= list.size())
					break;
				val = filterted.substring(list.get(m)+1, list.get(m + 1));				
				count += val.length();
			}
			results.add(count);
		}

		return results;
	}

}
