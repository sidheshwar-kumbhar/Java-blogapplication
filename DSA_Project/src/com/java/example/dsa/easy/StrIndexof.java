package com.java.example.dsa.easy;

public class StrIndexof {
	public static void main(String[] args) {
		String str = "This is the example";
		// String str = "Thisexample";
		String val = "xa";

		System.out.println("Index is : " + indexOf(str, val));

	}

	public static int indexOf(String str, String val) {
		if (str == null || str.length() == 0 || val == null || val.length() == 0) {
			return 0;
		}
		int n = str.length();
		int m = val.length();
		for (int i = 0; i <= n - m; i++) {
			for (int j = 0; j < m; j++) {
				if (str.charAt(i + j) != val.charAt(j)) {
					break;
				}
				if (j == m - 1) {
					return i;
				}
			}
		}

		return -1;
	}

}
