// Check Permutation:Give two string, write a method to decide if one is a permutation of the other.

/** Brute force approach:Check two string are equals. Run for loop for one string and remove character from second string
 * if after finishing loop second string is empty then one is a permutation of the other
 */

/** Sort both strings and compare the strings
 */

/**We can increment the value in count array for characters in str1 and decrement for characters in str2.
 * Finally, if all count values are 0, then the two strings are Permutation of each other. 
 * Thanks to Ace for suggesting this optimization.
 */


package com.java.example.dsa.array;

import java.util.Arrays;

public class StringCheckPermutation {
	
	public static void main(String args[]) {
		String str1 = "aabcdef";
		String str2 = "dceafba";
		
		System.out.println(isPermutation1(str1, str2));
		System.out.println(isPermutation2(str1, str2));
		//System.out.println(isPermutation3(str1, str2));
		
	}

	public static boolean isPermutation1(String str1, String str2) {
		
		if(str1 == null || str2 == null) {
			return false;
		}
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		if(len1 != len2) {
			return false;
		}
		
		for(int i = 0; i < len1; i++) {
			int chIndex = str2.indexOf(str1.charAt(i));
			if( chIndex == -1) {
				return false;
			} 
			
			if(chIndex == 0) {
				str2 = str2.substring(chIndex +1 , str2.length());
			} else {
				str2 = str2.substring(0 ,  chIndex) + str2.substring(chIndex +1 , str2.length());
			}
		}
		return str2.isEmpty();
	}
	
	public static boolean isPermutation2(String str1, String str2) {
		if(str1 == null || str2 == null) {
			return false;
		}
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		if(len1 != len2) {
			return false;
		}
		
		char[] str1Array = str1.toCharArray();
		char[] str2Array = str2.toCharArray();
		Arrays.sort(str1Array);
		Arrays.sort(str2Array);
		str1 = new String(str1Array);
		str2 = new String(str2Array);
		
		return str1.equals(str2);
	}
}
