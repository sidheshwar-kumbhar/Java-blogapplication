package com.dsa.java.example.practice;

import java.util.ArrayList;

public class FindSubArrayIndex {
	public static void main(String[] args) {
		int[] arr = { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103,
				154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134 };
		int n = arr.length;
		int s = 468;
		ArrayList<Integer> result = subarraySum(arr, n, s);
		for(int val : result) {
			System.out.print(val + " ");
		}
	}

	public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		int first = 0;
		int last = 0;
		int sum = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (n == 0) {
			result.add(-1);
			return result;
		}

		while (first < n && last < n) {
			if (sum < s) {
				sum = sum + arr[last];
				last++;
			} else if (sum > s) {
				sum = sum - arr[first];
				first++;
			} else {
				result.add(first + 1);
				result.add(last);
				return result;
			}

		}
		result.add(-1);
		return result;
	}
}
