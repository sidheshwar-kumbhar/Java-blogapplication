package com.java.example.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow4 {
	public static void main(String[] args) {
//		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		int s = 15;
//		 int arr[] = { 1, 2, 3, 7, 5 };
//		 int s = 12;
		int arr[] = { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103,
				154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134 };
		int s = 468;

		int n = arr.length;
		List<Integer> result = subarraySum(arr, n, s);
		for (int val : result) {
			System.out.print(val + " ");
		}
	}

	public static List<Integer> subarraySum(int[] arr, int n, int s) {
		List<Integer> result = new ArrayList<Integer>();
		if (arr == null || n == 0) {
			result.add(-1);
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		boolean isEnd = false;
		while (start <= end) {
			if (!isEnd)
				sum = sum + arr[end];
			if (end == n - 1)
				isEnd = true;
			if (sum > s) {
				sum = sum - arr[start];
				start++;
				if (end < n - 1)
					end++;
			} else if (sum < s) {
				end++;
			}
			if (sum == s) {
				result.add(start + 1);
				if (isEnd || start == 0)
					result.add(end + 1);
				else
					result.add(end);
				return result;
			}
		}
		result.add(-1);
		return result;
	}

}
