/**
 Remove duplicates from an unsorted linked list
 Easy
 
 Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List. 
 When a value appears in multiple nodes, the node which appeared first should be kept, all others duplicates are to be removed.

Example 1:

Input:
N = 4
value[] = {5,2,2,4}
Output: 5 2 4
Explanation:Given linked list elements are
5->2->2->4, in which 2 is repeated only.
So, we will delete the extra repeated
elements 2 from the linked list and the
resultant linked list will contain 5->2->4
Example 2:

Input:
N = 5
value[] = {2,2,2,2,2}
Output: 2
Explanation:Given linked list elements are
2->2->2->2->2, in which 2 is repeated. So,
we will delete the extra repeated elements
2 from the linked list and the resultant
linked list will contain only 2.
Your Task:
You have to complete the method removeDuplicates() which takes 1 argument: the head of the linked list.  
Your function should return a pointer to a linked list with no duplicate element.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= size of linked lists <= 106
0 <= numbers in list <= 104

 */
package com.java.example.dsa.linkedlist;

import java.util.HashSet;

import com.java.example.dsa.linkedlist.node.ListNode;

public class RemoveDuplicatesFromUnsortedList {

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
