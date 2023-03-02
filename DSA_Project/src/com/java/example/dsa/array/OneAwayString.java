
/**
You are given two strings, string A and string B.
Your task is to determine whether string A can be transformed into string B by performing only one of the following operations at most one (or maybe zero) time.
1. You can delete a character from any position.
2. You can replace a character with any other character.
3. You can insert a character at any position. 
Note :
1. The strings are non-empty.
2. The strings only contain lowercase English letters.

Sample Input 1 :
1
abcde
abcd
Sample Output 1 :
True

Explanation For Sample Input 1 :
For the strings “abcde” and “abcd”, we can observe that string B has one less character 
than the string A and all the characters of the strings are matching up to this length 
and in fact string A has one extra character. This means that we can simply delete this extra 
character and can get a string equal to the string B as the resultant string. Since we only used one
of the operations only once, we can return “true”.


Sample Input 2 :
1
stbr
start
Sample Output 2 :
False

Explanation For Sample Input 2 :
For the strings “stbr” and “start”, we can observe that we require at least two operations to 
convert string A into string B. In one operation, we can replace ‘b’ with ‘a’ and we get “star” as the resultant string. 
This resultant string is not equal to the string B, “start”.
 We still need one more operation to convert it into string B.
 We can achieve this by adding ‘t’ to the resultant string so it will become “start”  But this would take two operations. So we print “false”.

 */
package com.java.example.dsa.array;

public class OneAwayString {
	public static void main(String args[]) {
		String str1 = "abcd"; 
		String str2 = "abcde";
		
		System.out.println(isOneAway(str1, str2));
	}
	
	public static boolean isOneAway(String str1, String str2) {
		if(str1 == null || str2 == null)
			return false;
		
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1 == len2) {
			return isOneAwayReplace(str1, str2);
		} else if(len1 == len2 + 1) {
			return inOneAwayInsert(str1, str2);
		} else if(len1 + 1 == len2) {
			// Same like delete from second string
			return inOneAwayInsert(str2, str1);
		}
		
		
		return false;
	}
	
	public static boolean isOneAwayReplace(String str1, String str2) {
		boolean isReplaced = false;
		for(int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				if(isReplaced) {
					return false;
				}
				isReplaced = true;
			}
		}
		return true;
	}
	
	public static boolean inOneAwayInsert(String str1, String str2) {
		int indexStr1 = 0;
		int indexStr2 = 0;
		
		while(indexStr1 < str1.length()) {
			if(str2.length() <= indexStr2 || str1.charAt(indexStr1) != str2.charAt(indexStr2) ) {
				indexStr1++;
			} else {
				indexStr1++;
				indexStr2++;
			}
		}
		return (indexStr2 + 1 ) == indexStr1;
	}
}
