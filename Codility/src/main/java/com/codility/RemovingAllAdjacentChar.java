package com.codility;

public class RemovingAllAdjacentChar {

	public static void main(String[] args) {
		
		String value =  check("ACCAABBC");
		System.out.println(value);

	}

	public static String check(String S) {
		if (S.length() <= 1) {
			return S;
		}
		// System.out.println(str);
		String n = new String();
		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			while (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) {
				if (i < S.length() - 2 && S.charAt(i) != S.charAt(i + 2))
					i += 2;
				else
					i++;
				count++;
			}
			if (i != S.length() - 1)
				n = n + S.charAt(i);
			else {
				if (i == S.length() - 1 && S.charAt(i) != S.charAt(i - 1))
					n = n + S.charAt(i);
			}
		}
		if (count > 0)
			return check(n);
		else
			return n;
	}
}
