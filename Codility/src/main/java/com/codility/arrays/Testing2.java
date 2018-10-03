package com.codility.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.attribute.AclEntry.Builder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Testing2 {

	public static void main(String[] args) throws IOException {
		/*
		 * String value = getInput(); System.out.println(value);
		 */
		Scanner scanner = new Scanner(System.in);
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter("C:\\Users\\Yuvaraj\\Desktop\\testingyuvi.txt"));

		File file = new File("C:\\Users\\Yuvaraj\\Desktop\\HackerRank.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder builder = new StringBuilder();
		String st;
		while ((st = br.readLine()) != null) {
			builder.append(st);
		}

		String s = builder.toString();
		String result = isValid("aabbc");

		System.out.println(result);

	}

	public static String isValid(String value) {
		Map<Character, Integer> characterMapCount = new HashMap<Character, Integer>();
		int counter = 1;
		int oldValue = 0;
		boolean firstTime = false;
		boolean isValid = true;
		int count = 0;
		for (int i = 0; i < value.length(); i++) {
			if (characterMapCount.get(value.charAt(i)) != null) {
				count = characterMapCount.get(value.charAt(i)) + 1;
				characterMapCount.put(value.charAt(i), count);
			} else {
				count = 1;
				characterMapCount.put(value.charAt(i), count);
			}
		}
		for (Map.Entry<Character, Integer> entry : characterMapCount.entrySet()) {
			int charCount = entry.getValue();
			if (counter == 1) {
				oldValue = charCount;
			} else if (oldValue != charCount && !firstTime) {
				if (charCount - 1 == oldValue) {
					firstTime = true;
				} else if (oldValue > 1  && counter != characterMapCount.size()) {
					isValid = false;
					break;
				}

			} else if (oldValue != charCount && firstTime) {
				isValid = false;
				break;
			}
			counter++;
		}
		if (isValid) {
			return "YES";
		} else {
			return "NO";
		}
	}

}
