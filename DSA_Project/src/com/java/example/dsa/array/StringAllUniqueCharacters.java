// Is Unique: Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?

/** Brute force approach: ASCII has a total of 128 characters, The maximum it can have is 128 characters. 
* We can compare all the characters with characters using nested for loop. if the same character is found return false.
* Time complexity is O(n^2)
*/

// We can use HashMap or HashSet to verify the unique set the time complexity will be O(n)

// We can use an array same data structure, with a character index. If that index has true value means it is not unique time complexity is O(n)

package com.java.example.dsa.array;

import java.util.HashSet;
import java.util.Set;

public class StringAllUniqueCharacters {

	public static void main(String args[]) {
		String inputString = "abcdefghijkl";

		System.out.println(isUniqueBruteForce(inputString));
		System.out.println(isUniqueHashSet(inputString));
		System.out.println(isUniqueArrayt(inputString));

	}

	static boolean isUniqueBruteForce(String inputString) {
		if (inputString == null || inputString.isEmpty() || inputString.length() > 128) {
			return false;
		}
		int len = inputString.length();
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (inputString.charAt(i) == inputString.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean isUniqueHashSet(String inputString) {
		if (inputString == null || inputString.isEmpty() || inputString.length() > 128) {
			return false;
		}
		int len = inputString.length();
		Set<Character> charSet = new HashSet<Character>();
		for (int i = 0; i < len; i++) {
			if (!charSet.add(inputString.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	static boolean isUniqueArrayt(String inputString) {
		if (inputString == null || inputString.isEmpty() || inputString.length() > 128) {
			return false;
		}
		int len = inputString.length();
		boolean[] charSet = new boolean[128];

		for (int i = 0; i < len; i++) {
			int index = inputString.charAt(i);
			if (charSet[index]) {
				return false;
			}
			charSet[inputString.charAt(i)] = true;
		}
		return true;
	}

}
