package com.java.dsa.q4.sort;

public class SortArrayWithoutUsingSorting {

	public static int[] sort(int[] array) {
		if (array != null && array.length > 0) {
			int high = array.length - 1;
			int low = 0;
			int mid = 0;
			while (mid <= high) {
				if (array[mid] == 0) {
					array[low] = array[low] + array[mid];
					array[mid] = array[low] - array[mid];
					array[low] = array[low] - array[mid];
					mid++;
					low++;
				} else if (array[mid] == 2) {
					array[mid] = array[mid] + array[high];
					array[high] = array[mid] - array[high];
					array[mid] = array[mid] - array[high];
					high--;
				} else {
					mid++;
				}
			}
		}
		return array;
	}

	public static void display(int[] array) {
		for (int count = 0; count < array.length; count++)
			System.out.print(array[count]);
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] array = { 0, 2, 1, 0, 1, 2, 1, 0 };
		display(array);
		sort(array);
		display(array);
	}
}
