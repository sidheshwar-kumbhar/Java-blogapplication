/**
21. Merge Two Sorted Lists
Easy

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

1. The number of nodes in both lists is in the range [0, 50].
2. -100 <= Node.val <= 100
3. Both list1 and list2 are sorted in non-decreasing order.

*/

package com.java.example.dsa.linkedlist;

import com.java.example.dsa.linkedlist.node.ListNode;

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		addNode(list1, 2);
		addNode(list1, 4);

		ListNode list2 = new ListNode(1);
		addNode(list2, 3);
		addNode(list2, 4);

		printData(list1);
		printData(list2);

		ListNode resultList = mergeTwoLists(list1, list2);
		printData(resultList);

	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode resultList = new ListNode(-1);
		ListNode resultHead = resultList;


		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				resultHead.next = list1;
				list1 = list1.next;
			} else {
				resultHead.next = list2;
				list2 = list2.next;
			}
			
			resultHead = resultHead.next ;
		}
		if(list1 == null) {
			resultHead.next = list2;
		} else {
			resultHead.next = list1;
		}
		
		return resultList.next;

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
