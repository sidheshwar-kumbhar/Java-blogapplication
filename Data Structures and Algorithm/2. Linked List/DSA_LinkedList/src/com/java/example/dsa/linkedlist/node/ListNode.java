package com.java.example.dsa.linkedlist.node;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode child;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}