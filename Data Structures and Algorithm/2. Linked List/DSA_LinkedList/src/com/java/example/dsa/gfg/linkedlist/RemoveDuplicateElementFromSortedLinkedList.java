/*

Remove duplicate element from sorted Linked List
Easy Accuracy: 49.37% Submissions: 195K+ Points: 2

Given a singly linked list consisting of N nodes. The task is to remove duplicates 
(nodes with duplicate values) from the given list (if exists).
Note: Try not to use extra space. Expected time complexity is O(N). 
The nodes are arranged in a sorted way.

Example 1:

Input:
LinkedList: 2->2->4->5
Output: 2 4 5
Explanation: In the given linked list 
2 ->2 -> 4-> 5, only 2 occurs more 
than 1 time.
Example 2:

Input:
LinkedList: 2->2->2->2->2
Output: 2
Explanation: In the given linked list 
2 ->2 ->2 ->2 ->2, 2 is the only element
and is repeated 5 times.
Your Task:
The task is to complete the function removeDuplicates() 
which should remove the duplicates from linked list and return the head of the linkedlist.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
1 <= Number of nodes <= 104

 */

package com.java.example.dsa.gfg.linkedlist;

import java.util.*;
import com.java.example.dsa.Node;

public class RemoveDuplicateElementFromSortedLinkedList {

	Node head;
	Node tail;

	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			RemoveDuplicateElementFromSortedLinkedList llist = new RemoveDuplicateElementFromSortedLinkedList();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}

			llist.head = removeDuplicates(llist.head);
			llist.printList();

			t--;
		}
	}

	// Function to remove duplicates from sorted linked list.
	public static Node removeDuplicates(Node head) {
		Node curr = head;
		Node prev = head;
		if (curr == null) {
			return curr;
		}
		while (curr != null) {
			curr = curr.next;
			if (curr != null && prev.data == curr.data) {
				prev.next = curr.next;
			} else {
				prev = prev.next;
			}
		}
		return head;
	}
}
