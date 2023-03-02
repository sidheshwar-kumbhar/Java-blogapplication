/**
 Problem Statement
 
You have been given an array 'ARR' of integers consisting of ‘N’ integers and a positive integer ‘K’.
Your task is to find a subarray(contiguous) of size ‘K’ such that the sum of its elements is minimum.
 
Note: You can assume that the value of ‘K’ will always be less than or equal to ‘N’. So, the answer will always exist.
 
Detailed explanation ( Input/output format, Notes, Constraints, Images )
Sample Input 1 :
8 3
10 4 2 5 6 3 8 1
Sample Output 1 :
11
Explanation Of Sample Input
All subarrays of size 3 and their respective sums are-
{10, 4, 1} : sum → 10+4+1 = 15
{4, 2, 5} : sum → 4+2+5 = 11
{2, 5, 6} : sum → 2+5+6 = 13
{5, 6, 3} : sum → 5+6+3 = 14
{6, 3, 8} : sum → 6+3+8 = 17
{3, 8, 1} : sum → 3+8+1 = 12

The subarray with a minimum sum of 11 is {4, 2, 5}.
Sample Input 2 :
8 4
1 -4 2 10 -2 3 1 0 -20
Sample Output 2 :
2

*/


/** Brute force approach: Use tow for loops for the calculations 
 * first will start from i to n-k and second will start from i to k to calculate addition 
 * Time complexity will be O((n-k)+k^2)
 * 
 * Better approach:We can use two pointers one start from 0th item and second will start from 0th item
 * Second will move till the kth item and after the kth item first and second will increment by one till the 
 * send will reach the end and first will be on n-kth item. While moving these two pointer will be add next 
 * item and subtract ith item so sum will be k items. We can check the min sum and keep tracking the min sum
 * at last we return min sum as ans
 * Time complexity will be O(n)
 */

package com.java.example.dsa.array;
import java.util.ArrayList;

public class MinimumSumSubarray {
	public static void main(String args[]) {
		
//		int[] ARR = {10, 4, 2, 5, 6, 3, 8, 1};
//		int k = 3;
//		int n = 8;
		
		int[] arr = {1, -4, 2, 10, -2, 3, 1, 0, -20};
		int k = 4;
		int n = 9;
		
		ArrayList<Integer> arr2 = new ArrayList<>();
		
//		arr2.add(1);
//		arr2.add(-4);
//		arr2.add(2);
//		arr2.add(10);
//		arr2.add(-2);
//		arr2.add(3);
//		arr2.add(1);
//		arr2.add(0);
//		arr2.add(-20);
		
		arr2.add(1200);
		
		int k2 = 1;
		int n2 = 1;
		
		System.out.println("The MIN sum is : " + contiguousSubarray(arr, k, n));
		System.out.println("The MIN sum is : " + minSubarraySum(arr2, n2, k2));
	}
	
	public static long contiguousSubarray(int[] arr, int k, int n) {
		if(n > 0 && k > 0 && arr != null && arr.length > 0) {
			long ans = Long.MAX_VALUE;
			for(int i = 0; i < n - k; i++) {
				long sum = 0;
				for(int j = i; j < i + k; j++) {
					sum += arr[j];
				}
				ans = Math.min(ans, sum);
			}
			return ans;
		}
		return -1;
	}
	
	public static int minSubarraySum(ArrayList<Integer> arr, int n, int k)
    {
        if(n > 0 && k > 0 && arr != null && arr.size() > 0) {
			int ans = Integer.MAX_VALUE;
			for(int i = 0; i <= n - k; i++) {
				int sum = 0;
				for(int j = i; j < i + k; j++) {
					sum += arr.get(j);
				}
				ans = Math.min(ans, sum);
			}
			return ans;
		}
		return -1;
    }
	
	
	
}
