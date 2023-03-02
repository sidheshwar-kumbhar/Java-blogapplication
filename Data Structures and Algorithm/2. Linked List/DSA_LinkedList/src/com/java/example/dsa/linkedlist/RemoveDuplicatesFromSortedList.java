/**
83. Remove Duplicates from Sorted List

Easy
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:

1. The number of nodes in the list is in the range [0, 300].
2. -100 <= Node.val <= 100
3. The list is guaranteed to be sorted in ascending order.
 
 */

package com.java.example.dsa.linkedlist;

import java.util.HashSet;

import com.java.example.dsa.linkedlist.node.ListNode;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		addNode(list, 1);
		addNode(list, 2);
		addNode(list, 3);
		addNode(list, 3);
		addNode(list, 3);
		addNode(list, 3);

		printData(list);
		list = deleteDuplicates(list);
		printData(list);

	}

	// Best solution : Time O(n) Space O(1)
	public static ListNode deleteDuplicates2(ListNode head) {
		ListNode node = head;
		ListNode prvNode = head;
		if (head != null)
			head = head.next;

		while (head != null) {
			if (prvNode.val != head.val) {
				prvNode.next = head;
				prvNode = prvNode.next;
			}
			head = head.next;
		}
		if (prvNode != null)
			prvNode.next = null;

		return node;
	}

	// Time O(n) Space O(n)
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode prev = head; // Keep track of the previous node
		if (head != null) {
			ListNode current = head.next;
			HashSet<Integer> set = new HashSet<>();

			set.add(prev.val);

			while (current != null) {
				if (!set.contains(current.val)) {
					set.add(current.val);
					prev.next = current;
					prev = prev.next;
				}
				current = current.next;
			}
			if (prev != null)
				prev.next = null;
		}
		return head;
	}

	public static void printData(ListNode head) {
		if (head != null) {
			while (head.next != null) {
				System.out.print(head.val + " -> ");
				head = head.next;
			}
			System.out.println(head.val + " -> NULL ");
		}
	}

	public static void addNode(ListNode head, int val) {
		ListNode node = new ListNode(val);
		while (head.next != null) {
			head = head.next;
		}
		head.next = node;
	}

}
