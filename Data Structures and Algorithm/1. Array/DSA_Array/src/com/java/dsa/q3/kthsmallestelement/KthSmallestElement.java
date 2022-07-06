package com.java.dsa.q3.kthsmallestelement;

import java.util.Arrays;

public class KthSmallestElement {

	// Function to return Kth element
	public static int getKthSmallestElement(int[] array, int k) {
		if (array == null) {
			throw new NullPointerException();
		}
		// Sort array
		Arrays.sort(array);
		// Return Kth smallest element
		return array[k - 1];
	}

	public static void main(String[] args) {
		int[] array = { 1, 10, 8, 11, 16, 48, 5, 2 };
		int k = 5;
		System.out.println("Kth smallest element is :" + getKthSmallestElement(array, k));
	}

}
