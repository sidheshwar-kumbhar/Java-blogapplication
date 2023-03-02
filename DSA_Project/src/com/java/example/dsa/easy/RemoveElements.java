package com.java.example.dsa.easy;

public class RemoveElements {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		int len = getRemoveElement(arr, val);
		System.out.println("Length : " + len);
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int getRemoveElement(int[] arr, int val) {
		if (arr == null || arr.length == 0)
			return 0;
		int i = 0;
//		int n = arr.length;
//		while (i < n) {
//			if (arr[i] == val) {
//				arr[i] = arr[n - 1];
//				n--;
//			} else {
//				i++;
//			}
//		}
//		return n;
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] != val) {
				arr[i] = arr[j];
				i++;
			}
		}
		return i;
	}
}