package com.java.example.dsa.array;

public class SortArrayZeroOneTwo {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 1, 0, 2, 0, 0, 1 };
		display(arr);
		sort(arr);
		display(arr);
	}

	public static void display(int[] arr) {
		if (arr != null && arr.length > 0) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}

	public static void sort(int[] arr) {
		if (arr != null && arr.length > 0) {
			int hi = arr.length - 1;
			int lo = 0;
			int mid = 0;
			while (mid <= hi) {
				if (arr[mid] == 0) {
					arr[lo] = arr[lo] + arr[mid];
					arr[mid] = arr[lo] - arr[mid];
					arr[lo] = arr[lo] - arr[mid];

					mid++;
					lo++;

				} else if (arr[mid] == 2) {
					arr[mid] = arr[mid] + arr[hi];
					arr[hi] = arr[mid] - arr[hi];
					arr[mid] = arr[mid] - arr[hi];

					hi--;

				} else {

					mid++;

				}
			}
		}
	}
}
