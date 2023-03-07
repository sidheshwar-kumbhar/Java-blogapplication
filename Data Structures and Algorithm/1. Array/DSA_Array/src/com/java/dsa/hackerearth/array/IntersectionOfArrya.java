/*
Problem
You are given three sorted arrays arr1, arr2 and arr3. Your task is to return a sorted array of elements that are common to all three arrays.

Input:

n1, n2, n3 - The lengths of arr1, arr2 and arr3 respectively

arr1, arr2, arr3 - Three sorted arrays

Output:

A sorted array of numbers common to arr1, arr2 and arr3.

Constraints:

1 <=  arr1.length, arr2.length, arr3.length <= 1000

1<= arr1[i], arr2[i], arr3[i] <= 2000

There will be at least one element common in all three arrays.

Sample Input
5
5
5
1 2 3 4 5
1 3 4 5 8
1 2 5 7 9
Sample Output
1 5
Time Limit: 2.1
Memory Limit: 256
Source Limit:
	
	
*/

package com.java.dsa.hackerearth.array;

import java.io.*;
import java.util.*;

public class IntersectionOfArrya {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n1 = Integer.parseInt(br.readLine().trim());
		int n2 = Integer.parseInt(br.readLine().trim());
		int n3 = Integer.parseInt(br.readLine().trim());
		String[] arr_arr1 = br.readLine().split(" ");
		int[] arr1 = new int[n1];
		for (int i_arr1 = 0; i_arr1 < arr_arr1.length; i_arr1++) {
			arr1[i_arr1] = Integer.parseInt(arr_arr1[i_arr1]);
		}
		String[] arr_arr2 = br.readLine().split(" ");
		int[] arr2 = new int[n2];
		for (int i_arr2 = 0; i_arr2 < arr_arr2.length; i_arr2++) {
			arr2[i_arr2] = Integer.parseInt(arr_arr2[i_arr2]);
		}
		String[] arr_arr3 = br.readLine().split(" ");
		int[] arr3 = new int[n3];
		for (int i_arr3 = 0; i_arr3 < arr_arr3.length; i_arr3++) {
			arr3[i_arr3] = Integer.parseInt(arr_arr3[i_arr3]);
		}

		int[] out_ = array_intersection(n1, n2, n3, arr1, arr2, arr3);
		System.out.print(out_[0]);
		for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
			System.out.print(" " + out_[i_out_]);
		}

		wr.close();
		br.close();
	}

	static int[] array_intersection(int n1, int n2, int n3, int[] arr1, int[] arr2, int[] arr3) {
		
		ArrayList<Integer> resultList = new ArrayList<>();
		int arr1i = 0, arr2i = 0, arr3i = 0;

		while (arr1i < n1 && arr2i < n2 && arr3i < n3) {
			if ((arr1[arr1i] == arr2[arr2i]) && (arr2[arr2i] == arr3[arr3i])) {
				resultList.add(arr1[arr1i]);
				arr1i = arr1i + 1;
				arr2i = arr2i + 1;
				arr3i = arr3i + 1;
			} else if (arr1[arr1i] < arr2[arr2i] || arr1[arr1i] < arr3[arr3i]) {
				arr1i = arr1i + 1;
			} else if (arr2[arr2i] < arr1[arr1i] || arr2[arr2i] < arr3[arr3i]) {
				arr2i = arr2i + 1;
			} else if (arr3[arr3i] < arr1[arr1i] || arr3[arr3i] < arr2[arr2i]) {
				arr3i = arr3i + 1;
			}
		}
		return resultList.stream().mapToInt(i -> i).toArray();

	}
}