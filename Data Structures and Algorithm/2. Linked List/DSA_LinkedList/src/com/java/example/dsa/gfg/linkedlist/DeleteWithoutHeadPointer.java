/*

Delete without head pointer
Easy Accuracy: 78.57% Submissions: 155K+ Points: 2 

You are given a pointer/ reference to the node which is to be deleted 
from the linked list of N nodes. The task is to delete the node. 
Pointer/ reference to head node is not given. 

Note: No head reference is given to you. It is guaranteed that the node to be deleted 
is not a tail node in the linked list.

Example 1:

Input:
N = 2
value[] = {1,2}
node = 1
Output: 2
Explanation: After deleting 1 from the
linked list, we have remaining nodes
as 2.

Example 2:

Input:
N = 4
value[] = {10,20,4,30}
node = 20
Output: 10 4 30
Explanation: After deleting 20 from
the linked list, we have remaining
nodes as 10, 4 and 30.
Your Task:
You only need to complete the function deleteNode that takes reference to the node that needs to be deleted. The printing is done automatically by the driver code.

Expected Time Complexity : O(1)
Expected Auxilliary Space : O(1)

Constraints:
2 <= N <= 103

*/
package com.java.example.dsa.gfg.linkedlist;

import java.util.*;

import com.java.example.dsa.Node;

public class DeleteWithoutHeadPointer {

	Node head;
	Node tail;

	void printList(Node head) {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.println();
	}

	void addToTheLast(Node node) {

		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	Node search_Node(Node head, int k) {
		Node current = head;
		while (current != null) {
			if (current.data == k)
				break;
			current = current.next;
		}
		return current;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			Delete_Node llist = new Delete_Node();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}

			int k = sc.nextInt();
			Node del = llist.search_Node(llist.head, k);

			if (del != null && del.next != null) {
				deleteNode(del);
			}
			llist.printList(llist.head);
			t--;
		}
	}

	public static void deleteNode(Node del) {
		// Your code here
	}
}

class Delete_Node {
	Node head;
	Node tail;

	void printList(Node head) {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.println();
	}

	void addToTheLast(Node node) {

		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	Node search_Node(Node head, int k) {
		Node current = head;
		while (current != null) {
			if (current.data == k)
				break;
			current = current.next;
		}
		return current;
	}

}