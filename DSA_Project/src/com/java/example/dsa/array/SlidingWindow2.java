package com.java.example.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow2 {

	public static void main(String[] args) {
		 int[] intArray = { 1, 2, 3, 7, 5 };
		 int k = 12;
//		int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		int k = 20;
		int n = intArray.length;
		List<Integer> result = calculateMaxSum(intArray, n, k);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static List<Integer> calculateMaxSum(int[] intArray, int n, int k) {
		int arraySum = 0;
		List<Integer> result = new ArrayList<>();
		if (n == 0) {
			result.add(-1);
		}
		int start = 0;
		int end = 0;
		arraySum = intArray[start];
		while (end < n) {
			if (arraySum < k) {
				end++;
				if (end < n)
					arraySum = arraySum + intArray[end];
			} else if (arraySum > k) {
				arraySum = arraySum - intArray[start];
				start++;
			}

			if (arraySum == k) {
				if (start != end) {
					result.add(start + 1);
					result.add(end + 1);
				}
				arraySum = arraySum - intArray[start];
				start++;
				end++;
				if (end < n)
					arraySum = arraySum + intArray[end];
			}
		}

		if (result.size() == 0) {
			result.add(-1);
		}
		return result;
	}
}
