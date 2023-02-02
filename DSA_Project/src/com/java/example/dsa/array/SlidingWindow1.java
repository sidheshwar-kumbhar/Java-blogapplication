package com.java.example.dsa.array;

// Program to use sliding window to calculate maximum sum of given sub array
public class SlidingWindow1 {

	public static void main(String[] args) {
		int[] intArray = { 1, 2, 5, -1, 4, 0, 6 };
		int k = 2;
		int n = intArray.length;
		System.out.println("The maxmimum sum of array is : " + calculateMaxSum(intArray, n, k));
	}

	public static int calculateMaxSum(int[] intArray, int n, int k) {
		int arraySum = 0;
		int tempArraySum = 0;

		if (n < k) {
			System.out.println("Invalid input");
			return -1;
		}

		if (n == 0) {
			return 0;
		}

		for (int i = 0; i < k; i++) {
			tempArraySum += intArray[i];
		}

		arraySum = tempArraySum;
		for (int i = k; i < n; i++) {
			tempArraySum = tempArraySum - intArray[i - k];
			tempArraySum = tempArraySum + intArray[i];
			arraySum = Math.max(tempArraySum, arraySum);
		}

		return arraySum;
	}

}
