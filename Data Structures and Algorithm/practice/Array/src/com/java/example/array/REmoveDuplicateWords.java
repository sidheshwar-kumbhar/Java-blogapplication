package com.java.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/*
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
 

Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
*/
public class REmoveDuplicateWords {
	public static void main(String[] arg) {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 2;

		List<String> list = topKFrequent(words, k);
		System.out.println(list.toString());

	}

	public static List<String> topKFrequent(String[] words, int k) {
		List<String> rst = new ArrayList<>();
		if (words == null || words.length == 0) {
			return rst;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : words) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		List<String> candidates = new ArrayList<String>(map.keySet());
		Collections.sort(candidates,
				(w1, w2) -> map.get(w1) != map.get(w2) ? map.get(w2) - map.get(w1) : w1.compareTo(w2));

		return candidates.subList(0, k);
	}

}


