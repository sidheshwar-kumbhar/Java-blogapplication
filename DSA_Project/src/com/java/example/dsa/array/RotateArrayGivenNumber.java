package com.java.example.dsa.array;

public class RotateArrayGivenNumber {
	public static void main(String[] args) {
		int[] numberArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int rotateNumber = 6;
		// int[] numberArray = { 40, 13, 27, 87, 95, 40, 96, 71, 35, 79, 68, 2, 98, 3,
		// 18, 93, 53, 57, 2, 81, 87, 42, 66,
		// 90, 45, 20, 41, 30, 32, 18, 98, 72, 82, 76, 10, 28, 68, 57, 98, 54, 87, 66,
		// 7, 84, 20, 25, 29, 72, 33,
		// 30, 4, 20, 71, 69, 9, 16, 41, 50, 97, 24, 19, 46, 47, 52, 22, 56, 80, 89, 65,
		// 29, 42, 51, 94, 1, 35, 65,
		// 25 };
		// int rotateNumber = 69;
		for (int i = 0; i < numberArray.length; i++) {
			System.out.print(numberArray[i] + " ");
		}
		System.out.print("\n");

		numberArray = getRotateArray(numberArray, rotateNumber);
		for (int i = 0; i < numberArray.length; i++) {
			System.out.print(numberArray[i] + " ");
		}
		System.out.print("\n");

	}

	public static int[] getRotateArray(int[] numberArray, int rotateNumber) {
		int n = numberArray.length;
		if (n < rotateNumber) {
			rotateNumber = rotateNumber % n;
		}
		for (int i = n - 1; i >= rotateNumber;) {
			for (int j = rotateNumber - 1; j >= 0; j--) {
				numberArray = swap(numberArray, i, j);
				i--;
			}
		}

		return numberArray;
	}

	public static int[] swap(int[] numberArray, int index1, int index2) {
		numberArray[index1] = numberArray[index1] + numberArray[index2];
		numberArray[index2] = numberArray[index1] - numberArray[index2];
		numberArray[index1] = numberArray[index1] - numberArray[index2];
		return numberArray;
	}
}