package com.java.example.dsa.easy;

public class PluseOne {
	public static void main(String[] args) {
		int[] digits = { 9, 9, 9, 9 };
		int[] result = getPluseOne(digits);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}

	public static int[] getPluseOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = digits[i] + 1;
			if (digits[i] == 10) {
				digits[i] = 0;
			} else {
				return digits;
			}
		}

		int[] result = new int[digits.length + 1];
		result[0] = 1;
		for (int i = 0; i < digits.length; i++) {
			result[i + 1] = digits[i];
		}
		return result;
	}

}
