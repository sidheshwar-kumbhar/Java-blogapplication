package com.java.example.dsa.array;

public class SumOfBitDifferences {

	public static void main(String[] args) {
		int[] decimalNumberArray = { 1, 3, 5 };
		int countBit = 0;
		for (int i = 0; i < decimalNumberArray.length; i++) {
			for (int j = 0; j < decimalNumberArray.length; j++) {
				int diff = decimalNumberArray[i] ^ decimalNumberArray[j];
				countBit += getBitSum(diff);
			}
		}
		System.out.println(countBit);

		System.out.println(getBit(6, 2));

	}

	public static int getBit(int number, int position) {
		return (number >> position) & 1;
	}

	public static int getBitSum(int number) {
		int count = 0;
		while (number != 0) {
			number = number & (number - 1);
			count++;
		}
		return count;
	}

}
