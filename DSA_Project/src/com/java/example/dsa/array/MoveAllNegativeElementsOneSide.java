package com.java.example.dsa.array;

public class MoveAllNegativeElementsOneSide {

	public static void main(String[] args) {
		int[] arr = { -2, 5, -34, 6, -1, 7, 3, -77, -2, 0, -8, -6, 7, 1 - 10 };
		display(arr);
		getMoveAllNegativeElementsOneSide(arr);
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

	public static void getMoveAllNegativeElementsOneSide(int[] arr) {
		if (arr != null && arr.length > 0) {
			int hi = arr.length - 1;
			int lo = 0;
			while (lo <= hi) {
				if (arr[lo] < 0 && arr[hi] < 0) {
					lo++;
				} else if (arr[lo] >= 0 && arr[hi] < 0) {
					arr[lo] = arr[lo] + arr[hi];
					arr[hi] = arr[lo] - arr[hi];
					arr[lo] = arr[lo] - arr[hi];
					lo++;

				} else {
					hi--;
				}
			}
		}
	}
}
