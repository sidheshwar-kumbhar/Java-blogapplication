/*
 
Insert in Middle of Linked List
Basic Accuracy: 43.2% Submissions: 75K+ Points: 1

Given a linked list of size N and a key. 
The task is to insert the key in the middle of the linked list.

Example 1:

Input:
LinkedList = 1->2->4
key = 3
Output: 1 2 3 4
Explanation: The new element is inserted
after the current middle element in the
linked list.

Example 2:

Input:
LinkedList = 10->20->40->50
key = 30
Output: 10 20 30 40 50
Explanation: The new element is inserted
after the current middle element in the
linked list and Hence, the output is
10 20 30 40 50.
 

Your Task:
The task is to complete the function insertInMiddle() 
which takes head reference and element to be inserted as the arguments. 
The printing is done automatically by the driver code.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
1 <= N <= 104
 
 */
package com.java.example.dsa.gfg.linkedlist;

import java.util.*;
import com.java.example.dsa.Node;

public class InsertInMiddle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			Node head = new Node(sc.nextInt());
			Node tail = head;

			for (int i = 0; i < n - 1; i++) {
				tail.next = new Node(sc.nextInt());
				tail = tail.next;
			}
			int key = sc.nextInt();
			head = insertInMid(head, key);
			display(head);
			System.out.println();
		}
	}

	public static void display(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}

	public static Node insertInMid(Node head, int data) {
		Node node = new Node(data);
		if (head == null) {
			return node;
		}
		Node tmpHead1 = head;
		Node tmpHead2 = head;
		while (tmpHead1.next != null && tmpHead1.next.next != null) {
			tmpHead1 = tmpHead1.next.next;
			tmpHead2 = tmpHead2.next;
		}
		node.next = tmpHead2.next;
		tmpHead2.next = node;
		return head;
	}
}