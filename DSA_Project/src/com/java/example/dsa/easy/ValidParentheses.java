package com.java.example.dsa.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		String str = "{([])}";
		System.out.println(isValidParentheses(str));
	}

	public static boolean isValidParentheses(String str) {
		Map<Character, Character> parenthesesMap = new HashMap<Character, Character>();
		parenthesesMap.put('}', '{');
		parenthesesMap.put(']', '[');
		parenthesesMap.put(')', '(');

		if (str.length() > 0 && str.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stkVal = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!parenthesesMap.containsKey(ch)) {
				stkVal.push(ch);
			} else {
				if (stkVal.isEmpty()) {
					return false;
				} else {
					if (parenthesesMap.get(ch) != stkVal.pop()) {
						return false;
					}
				}
			}
		}

		return stkVal.isEmpty();
	}
}
