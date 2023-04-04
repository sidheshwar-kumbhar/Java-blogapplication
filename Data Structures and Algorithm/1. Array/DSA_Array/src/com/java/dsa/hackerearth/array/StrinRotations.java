package com.java.dsa.hackerearth.array;

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class StrinRotations {

	public static void main(String[] args) throws IOException {

		// taking input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// taking total count of testcases
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			// Reading the two Strings
			String s1 = br.readLine();
			String s2 = br.readLine();

			// calling areRotations method
			// of class Rotate and printing
			// "1" if it returns true
			// else "0"
			if (areRotations(s1, s2)) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
	}

	// Function to check if two strings are rotations of each other or not.
	public static boolean areRotations(String s1, String s2) {
		if (s1.length() != s2.length()) {
            return false;
        } else {
        	int size = s2.length();
			StringBuilder sb = new StringBuilder(s2);
			for (int i = 0; i < size; i++) {
				sb = sb.insert(0, sb.charAt(size - 1)).deleteCharAt(sb.length() - 1);
				if (s1.equals(sb.toString())) {
					return true;
				}
			}
			return false;
        }
	}

}