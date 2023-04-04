/*

Nth node from end of linked list
Easy Accuracy: 41.18% Submissions: 278K+ Points: 2

Given a linked list consisting of L nodes and given a number N. 
The task is to find the Nth node from the end of the linked list.

Example 1:

Input:
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output: 8
Explanation: In the first example, there
are 9 nodes in linked list and we need
to find 2nd node from end. 2nd node
from end is 8.  

Example 2:

Input:
N = 5
LinkedList: 10->5->100->5
Output: -1
Explanation: In the second example, there
are 4 nodes in the linked list and we
need to find 5th from the end. Since 'n'
is more than the number of nodes in the
linked list, the output is -1.
Your Task:
The task is to complete the function getNthFromLast() 
which takes two arguments: reference to head and N and you need to return Nth 
from the end or -1 in case node doesn't exist.

Note:
Try to solve in a single traversal.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= L <= 106
1 <= N <= 106

 */
package com.java.example.dsa.gfg.linkedlist;

import java.util.*;

import com.java.example.dsa.Node;

public class NthNodeFromEndOfLinkedList {

	Node head;
	Node tail;

	/* Function to print linked list */
	void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Inserts a new Node at front of the list. */
	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			NthNodeFromEndOfLinkedList llist = new NthNodeFromEndOfLinkedList();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}

			System.out.println(getNthFromLast(llist.head, k));

			t--;
		}
	}

	// Function to find the data of nth node from the end of a linked list.
	public static int getNthFromLast(Node head, int n) {
		Node fast = head;
		Node slow = head;
		if (head == null) {
			return -1;
		}
		while (fast != null) {
			fast = fast.next;
			if (n <= 0) {
				slow = slow.next;
			}
			n--;
		}
		return n <= 0 ? slow.data : -1;
	}
}
