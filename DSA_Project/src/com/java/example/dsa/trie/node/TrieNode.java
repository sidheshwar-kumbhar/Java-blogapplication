package com.java.example.dsa.trie.node;

import java.util.LinkedList;

public class TrieNode {
	public char data;
	public boolean isEnd;
	public int count;
	public LinkedList<TrieNode> childList;

	/* Constructor */
	public TrieNode(char c) {
		childList = new LinkedList<TrieNode>();
		isEnd = false;
		data = c;
		count = 0;
	}

	public TrieNode getChild(char c) {
		if (childList != null)
			for (TrieNode eachChild : childList)
				if (eachChild.data == c)
					return eachChild;
		return null;
	}
}
