package com.java.example.dsa.easy;

public class RemoveDuplicates {
	public static void main(String[] agrs) {
		int[] arr = { 1, 2, 2, 6, 6, 8, 8, 10 };
		// int[] arr = { 1, 2, 2, 10, 6, 0, 6, 8, 6, 8, 10 };
		int len = getUniqueElementLength(arr);
		System.out.println(len);
		System.out.print("Array : ");
		for (int j = 0; j < len; j++) {
			System.out.print(arr[j] + ", ");
		}
	}

	public static int getUniqueElementLength(int[] arr) {
		int i = 0;
		if (arr == null || arr.length == 0) {
			return i;
		}
		for (int j = 1; j < arr.length; j++) {
			if (arr[j] != arr[i]) {
				i++;
				arr[i] = arr[j];
			}
		}
		return i + 1;
	}

}
