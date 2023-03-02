package com.java.example.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PairSum {
	
	public static void main(String args[]) {
//		int[] arr = {1, 2, 3, 4, 5};
//		int sum = 5;
		
//		int[] arr = {2, -3, 3, 3, -2};
//		int sum = 0;
		
//		int[] arr = {2, -6, 2, 5, 2 };
//		int sum = 4;
		
		int[] arr = {-4, 7, -3, 4, -8, 4, 4, 0, -6, -7, 6, 9, 3, 5, 4, -1, -1, -6, -9, 0, 9, -3, 8, 5, 2, 6, 2, 0, 9, -4, -3, 0, 0, 8, 4};
		int sum = -7;
				
		List<int[]> ans = pairSum(arr, sum);
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(Arrays.toString(ans.get(i)));
		}
		
		System.out.println("-----");
		
		ans = pairSum2(arr, sum);
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(Arrays.toString(ans.get(i)));
		}
	}
	
	public static List<int[]> pairSum(int[] arr, int s) {
		List<int[]> ans = new ArrayList<>();
		//Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] + arr[j] == s) {
					int [] ansArr =  {arr[i] ,  arr[j]};
					ans.add(ansArr);
				}
			}
		}
		
		return ans; 
    }
	
	public static List<int[]> pairSum2(int[] arr, int s) {
		List<int[]>tmpAns = new ArrayList<>();
		List<int[]> ans = new ArrayList<>();
		Arrays.sort(arr);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++) {
			int rVal = s - arr[i];
			if(map.containsKey(rVal)){
				int val = map.get(rVal);
				int count = 0;
				while(count <= val) {
					int [] ansArr =  {rVal, arr[i]};
					tmpAns.add(ansArr);
					count++;
				}
				if(arr[i] == arr[i])
					map.put(arr[i], val + 1);
				else 
					map.put(arr[i], 0);
			} else {
				map.put(arr[i], 0);
			}
			
		}
		
		for(int i = tmpAns.size() - 1 ; i >= 0; i--) {
			ans.add(tmpAns.get(i));
		}
		
		return ans; 
    }

}
