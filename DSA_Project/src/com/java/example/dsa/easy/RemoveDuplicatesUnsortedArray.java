package com.java.example.dsa.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicatesUnsortedArray {
	public static void main(String[] agrs) {
		int[] arr = { 1, 2, 2, 10, 6, 0, 6, 8, 6, 8, 10 };
		int[] resultArr = getUniqueElements(arr);
		System.out.println(resultArr.length);
		System.out.print("Array : ");
		for (int j = 0; j < resultArr.length; j++) {
			System.out.print(resultArr[j] + " ");
		}
	}

	public static int[] getUniqueElements(int[] arr) {

		if (arr == null || arr.length == 0) {
			return arr;
		}
		Map<Integer, Boolean> numMap = new HashMap<Integer, Boolean>();
		for (int i = 0; i < arr.length; i++) {
			if (!numMap.containsKey(arr[i])) {
				numMap.put(arr[i], true);
			}
		}
		Set<Integer> keySet = numMap.keySet();
		int[] returnArr = new int[keySet.size()];
		Iterator<Integer> iterator = keySet.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			returnArr[i] = iterator.next();
			i++;
		}
		return returnArr;
	}

}
