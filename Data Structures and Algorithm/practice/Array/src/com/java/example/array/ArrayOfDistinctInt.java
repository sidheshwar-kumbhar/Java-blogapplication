package com.java.example.array;

import java.util.Map;
import java.util.HashMap;

// Given an array of distinct integer values, count the number of pair
// of integers that have difference k
// Input {1, 7, 5, 9, 2, 12, 3}  k=2
// Output : (1, 3), (3, 5), (5, 7), (7, 9)
public class ArrayOfDistinctInt {
	public static void main(String[] args) {
		int[] intArray = {0, 1, 7, 5, 9, 2, 12, 3 };
		int k = 2;
		printArray(intArray);
		pringDistinctIntegerValuesPair(intArray, k);

	}

	public static void printArray(int[] intArray) {
		for (int val : intArray) {
			System.out.print(val + " ");
		}
	}
	
	public static void pringDistinctIntegerValuesPair(int[] intArray, int k) {
		Map<Integer, Integer> valMap = new HashMap<Integer, Integer>();
		for (int val : intArray) {
			valMap.put(val, val);
		}
		System.out.println("");
		for (int val : intArray) {
			if (valMap.containsKey(val + k)) {
				System.out.print(" (" + (val + k) + ", " + val + ")");
			}
		}
	}
}