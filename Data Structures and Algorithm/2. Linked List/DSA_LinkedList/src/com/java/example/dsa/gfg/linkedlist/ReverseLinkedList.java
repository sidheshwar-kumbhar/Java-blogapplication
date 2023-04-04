/*

Reverse a linked list
Easy Accuracy: 73.11% Submissions: 234K+ Points: 2

Given a linked list of N nodes. The task is to reverse this list.

Example 1:

Input:
LinkedList: 1->2->3->4->5->6
Output: 6 5 4 3 2 1
Explanation: After reversing the list, 
elements are 6->5->4->3->2->1.

Example 2:

Input:
LinkedList: 2->7->8->9->10
Output: 10 9 8 7 2
Explanation: After reversing the list,
elements are 10->9->8->7->2.
Your Task:
The task is to complete the function reverseList() 
with head reference as the only argument and should return new head after reversing the list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104

 */
package com.java.example.dsa.gfg.linkedlist;

import java.util.*;
import com.java.example.dsa.Node;
import java.io.*;

public class ReverseLinkedList {

	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String args[]) throws IOException {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {

			int n = sc.nextInt();

			Node head = new Node(sc.nextInt());
			Node tail = head;

			for (int i = 0; i < n - 1; i++) {
				tail.next = new Node(sc.nextInt());
				tail = tail.next;
			}

			head = reverseList(head);
			printList(head);
			t--;
		}
	}

	// Function to reverse a linked list.
	public static Node reverseList(Node head) {

		Node current = head;
		Node prv = head;
		Node temp = current.next;
		current.next = null;

		while (temp != null) {
			prv = current;
			current = temp;
			temp = temp.next;
			current.next = prv;
		}

		return current;
	}
}
