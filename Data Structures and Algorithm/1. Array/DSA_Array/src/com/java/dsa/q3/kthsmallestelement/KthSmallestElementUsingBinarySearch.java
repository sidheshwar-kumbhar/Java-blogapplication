package com.java.dsa.q3.kthsmallestelement;

public class KthSmallestElementUsingBinarySearch {

	public static int getCount(int[] array, int mid) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= mid) {
				count++;
			}
		}
		return count;
	}

	// Function to return Kth element
	public static int getKthSmallestElement(int[] array, int k) {
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		// Calculate minimum and maximum value
		for (int i = 0; i < array.length; i++) {
			low = Math.min(low, array[i]);
			high = Math.max(high, array[i]);
		}

		// Our answer range lies between minimum and maximum element of the array
		// on which binary search is applied
		while (low < high) {
			int mid = low + (high - low) / 2;
			// If the count of number or elements in the array less then equal
			// to mid is less than k then increase the number and try to find a better
			// answer
			if (getCount(array, mid) < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		// Return Kth smallest element
		return low;
	}

	public static void main(String[] args) {
		int[] array = { 1, 10, 8, 11, 16, 48, 5, 2 };
		int k = 5;
		System.out.println("Kth smallest element is :" + getKthSmallestElement(array, k));
	}

}
