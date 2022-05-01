package com.tech.amazon;
import java.util.ArrayList;
import java.util.List;

public class Decresing {

	public static void main(String[] args) {
		List<Integer> ratings = new ArrayList<Integer>();

		ratings.add(3);
		ratings.add(2);
		ratings.add(1);
		ratings.add(3);
		

		System.out.println(countDecreasingRatings(ratings));
	}

	public static long countDecreasingRatings(List<Integer> ratingsList) {
		long count = 0l;
		List<String> countOccur = new ArrayList<String>();
		int[] ratings = ratingsList.stream().mapToInt(i -> i).toArray();
		for (int i = 0; i < ratings.length; i++) {
			String s = "";
			int temp = ratings[i] == 0 ? 1 : ratings[i] - 1;
			for (int j = i + 1; j < ratings.length; j++) {
				if (ratings[i] > ratings[j] && temp >= ratings[j]) {
					temp = ratings[j];
					if (!s.contains(String.valueOf(ratings[i]))) {
						s = String.valueOf(ratings[i]);
					}
					if (!s.contains(String.valueOf(ratings[j]))) {

						s += String.valueOf(ratings[j]);
					}
					if (s.length() > 1) {
						countOccur.add(s);
					}
				} else
					break;
			}
		}
		//count = countOccur.where(x -> Int32.Parse(x) > 0).Count() + ratings.Length;
		count = countOccur.size() + ratings.length;
		return count;
	}

}
