/*

Remove duplicates from an unsorted linked list
Easy Accuracy: 45.95% Submissions: 152K+ Points: 2 

Given an unsorted linked list of N nodes. The task is to remove duplicate elements 
from this unsorted Linked List. When a value appears in multiple nodes, 
the node which appeared first should be kept, all others duplicates are to be removed.

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
package com.java.example.dsa.gfg.linkedlist;

import java.util.*;
import com.java.example.dsa.Node;

public class RemoveDuplicatesFromUnsortedLinkedList {

	Node head;
	Node temp;

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
			temp = node;
		} else {
			temp.next = node;
			temp = node;
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

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			RemoveDuplicatesFromUnsortedLinkedList llist = new RemoveDuplicatesFromUnsortedLinkedList();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}
			llist.head = llist.removeDuplicates(llist.head);
			llist.printList();

			t--;
		}
	}

	// Function to remove duplicates from unsorted linked list.
	public Node removeDuplicates(Node head) {
		Node prev = head; // Keep track of the previous node
		if (head != null) {
			Node current = head.next;
			HashSet<Integer> set = new HashSet<>();

			set.add(prev.data);

			while (current != null) {
				if (!set.contains(current.data)) {
					set.add(current.data);
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
}
