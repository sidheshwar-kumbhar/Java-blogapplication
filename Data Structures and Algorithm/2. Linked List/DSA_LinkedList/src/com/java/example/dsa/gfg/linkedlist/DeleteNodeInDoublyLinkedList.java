/*

Delete node in Doubly Linked List
Basic Accuracy: 42.98% Submissions: 58K+ Points: 1 

Given a doubly linked list and a position. The task is to delete a node from given 
position in a doubly linked list.

Example 1:

Input:
LinkedList = 1 <--> 3 <--> 4 
x = 3
Output: 1 3  
Explanation: After deleting the node at
position 3 (position starts from 1),
the linked list will be now as 1->3.

Example 2:

Input:
LinkedList = 1 <--> 5 <--> 2 <--> 9  
x = 1
Output: 5 2 9
Your Task:
The task is to complete the function deleteNode() 
which should delete the node at given position and return the head of the linkedlist.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
2 <= size of the linked list <= 1000
1 <= x <= N

 */
package com.java.example.dsa.gfg.linkedlist;

import java.util.*;

import com.java.example.dsa.Node;

public class DeleteNodeInDoublyLinkedList {
	Node head;
	Node tail;

	void addToTheLast(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail.next.prev = tail;
			tail = tail.next;
		}
	}

	void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			DeleteNodeInDoublyLinkedList list = new DeleteNodeInDoublyLinkedList();

			int a1 = sc.nextInt();
			Node head = new Node(a1);
			list.addToTheLast(head);

			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				list.addToTheLast(new Node(a));
			}
			a1 = sc.nextInt();
			// System.out.println(list.temp.data);
			Node ptr = deleteNode(list.head, a1);
			list.printList(ptr);
			t--;
		}
	}

	// function returns the head of the linkedlist
	public static Node deleteNode(Node head, int x) {
		if (head == null)
			return head;

		int count = 1;

		if (x == count) {
			return head.next;
		}

		while (head.next != null && count < x) {
			count++;
			head = head.next;
		}
		if (count == x) {
			head.prev.next = head.next;
			if (head.next != null) {
				head.next.prev = head.prev;
			}
		}
		while (head.prev != null) {
			head = head.prev;
		}
		return head;
	}
}
