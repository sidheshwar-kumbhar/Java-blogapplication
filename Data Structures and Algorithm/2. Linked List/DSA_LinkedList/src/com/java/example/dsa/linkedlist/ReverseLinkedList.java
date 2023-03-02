/**
 Reverse a linked list
Easy

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
The task is to complete the function reverseList() with head reference as the only argument and should return new head after reversing the list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104

 */

package com.java.example.dsa.linkedlist;

import com.java.example.dsa.linkedlist.node.Node;

public class ReverseLinkedList {
	public static void main(String[] args) {
		Node list = new Node(1);
		addNode(list, 2);
		addNode(list, 3);
		addNode(list, 4);
		addNode(list, 5);
		addNode(list, 6);
		addNode(list, 7);

		printData(list);
		list = reverseList(list);
		printData(list);
	}

	public static Node reverseList(Node head) {
		if(head == null)
				return head;
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

	public static void printData(Node head) {
		if (head != null) {
			while (head.next != null) {
				System.out.print(head.value + " -> ");
				head = head.next;
			}
			System.out.println(head.value + " -> NULL ");
		}
	}

	public static void addNode(Node head, int val) {
		Node node = new Node(val);
		while (head.next != null) {
			head = head.next;
		}
		head.next = node;
	}

}
