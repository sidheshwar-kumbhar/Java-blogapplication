package com.java.dsa.q2.findminmax;

//Java program of above implementation
public class FindMinMax1 {
	/* Class Pair is used to return two values from getMinMax() */
	static class Pair {

		int min;
		int max;
	}

	static Pair getMinMax(int[] arr, int n) {
		Pair minmax = new Pair();
		int i;

		/* If there is only one element then return it as min and max both */
		if (n == 1) {
			minmax.max = arr[0];
			minmax.min = arr[0];
			return minmax;
		}

		/* If there are more than one elements, then initialize min and max */
		if (arr[0] > arr[1]) {
			minmax.max = arr[0];
			minmax.min = arr[1];
		} else {
			minmax.max = arr[1];
			minmax.min = arr[0];
		}

		for (i = 2; i < n; i++) {
			if (arr[i] > minmax.max) {
				minmax.max = arr[i];
			}
			if (arr[i] < minmax.min) {
				minmax.min = arr[i];
			}
		}

		return minmax;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int[] arr = { 1000, 11, 445, 1, 330, 3000 };
		int arr_size = arr.length;
		Pair minmax = getMinMax(arr, arr_size);
		System.out.println("Minimum element is " + minmax.min);
		System.out.println("Maximum element is " + minmax.max);

	}

}