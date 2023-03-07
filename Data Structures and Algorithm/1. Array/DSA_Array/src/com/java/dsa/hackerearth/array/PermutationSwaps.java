/*
Problem
A permutation of length N is an array of N integers such that every integer from 1  to N 
appears exactly once. For example,[2, 3, 5, 4, 1] is a permutation of length 5 , 
while[1, 2, 2],[4, 5, 1, 3] are not permutations.

You are given an array A having N integers. 
You can apply the following operation on the array A any number of times:

. Choose two indices i,j such that 1 <= i <j <= N, then decrease 1 from Ai and add 1 to Aj.

Find if it is possible to convert the array A into a permutation of length N.

Input format

. The first line of input contains an integer T denoting the number of test cases. 
	The description of each test case is as follows:
. The first line of each test case contains an integer N denoting the length of the array A.
. The second line of each test case contains N integers A1, A2, ... , AN, 
	denoting the elements of the array A.

Output format

For each test case, print YES if it is possible to obtain a permutation from the array A 
using the given operation, otherwise print NO.

Constraints
1 <= T <= 10^5
1 <= N <= 3.10^5
1 <= A1 <= 10^9

Sum of N over all test cases does exceed 3.10^5

Sample Input
2
4
3 3 2 2
3
2 1 2

Sample Output
YES
NO

Time Limit: 1
Memory Limit: 256
Source Limit:

Explanation

. In the first test case, apply the operation on indices i = 1, j = 2 making A = [2, 4, 2, 2], 
	then  apply the operation on indices i = 3, j = 4 making A = [2, 4, 1, 3]
	which is permutation of length 4.
. In the second test case, it is impossible to obtain a permutation of length 3 from the given array.
 
 */
package com.java.dsa.hackerearth.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PermutationSwaps {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine().trim());
			String[] arr_str = br.readLine().split(" ");
			long[] arr = new long[N];
			for (int i_wealth = 0; i_wealth < arr.length; i_wealth++) {
				arr[i_wealth] = Long.parseLong(arr_str[i_wealth]);
			}
			System.out.println(isPermutationSwaps(N, arr));
		}

		wr.close();
		br.close();
	}

	static String isPermutationSwaps(int n, long[] pre) {

		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + pre[i - 1];
			if (sum < ((i * (i + 1)) / 2)) {
				return "NO";
			}
		}

		if (sum == ((n * (n + 1)) / 2)) {
			return "YES";
		} else {
			return "NO";
		}
	}

}
