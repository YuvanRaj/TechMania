package com.tech.amazon;
import java.util.HashSet;
import java.util.Set;

public class PasswordStrength {

	public static void main(String[] args) {
		
		System.out.println(findPasswordStrength("abc"));
	}
	
	/**
	 * For all the combination of given password, storing each character in Hashset.
	 * Hashset will maintain only unique elements so the distinct character will always remains in collection
	 * @param password
	 * @return int
	 */
	private static int findPasswordStrength(final String password) {
	    char[] inputArray = password.toCharArray();
	    int total = 0;
	    for (int i = 0; i < inputArray.length; i++) {
	        int count = 1;
	        Set<String> uniqueLkp = new HashSet<String>();
	        uniqueLkp.add(String.valueOf(inputArray[i]));
	        for (int j = i+1; j < inputArray.length; j++) {
	        	uniqueLkp.add(String.valueOf(inputArray[j]));
	            count+=uniqueLkp.size();
	        }
	        total+=count;
	    }
	    return total;
	}

	public static int countdistinct(String s) {
		int ans = 0;
		for (char c = 'A'; c <= 'Z'; c++)
			ans += solve(c, s);
		return ans;
	}

	public static int solve(char c, String s) { // Counts no.of substrings that contain atleast one of the characters as
												// c.
		int cnt = 0, n = s.length(), res = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == c) {
				res += (cnt) * (cnt + 1) / 2;
				cnt = 0;
			} else
				cnt++;
		}
		res += (cnt) * (cnt + 1) / 2;
		return n * (n + 1) / 2 - res;
	}

}
