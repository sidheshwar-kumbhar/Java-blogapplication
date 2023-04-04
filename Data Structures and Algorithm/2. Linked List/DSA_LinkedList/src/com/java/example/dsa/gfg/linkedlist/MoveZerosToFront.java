/*
Move all zeros to the front of the linked list

Easy Accuracy: 53.55% Submissions: 15K+ Points: 2

Given a linked list, the task is to move all 0s to the front of the linked list. 
The order of all another element except 0 should be same after rearrangement.

Example 1:

Input:  0 -> 4 -> 0 -> 5 -> 0
Output: 0 -> 0 -> 0 -> 4 -> 5
Explanation: After moving all 0s of the given
list to the front, the list is:
0 -> 0 -> 0 -> 4 -> 5

Example 2:

Input: 0 -> 1 -> 0 -> 1 -> 2
Output: 0 -> 0 -> 1 -> 1 -> 2
Your Task:
You don't need to read input or print anything. 
Your task is to complete the function moveZeroes() which takes head node of the linked list as 
input parameter.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 50

 */

package com.java.example.dsa.gfg.linkedlist;

import java.util.*;

import com.java.example.dsa.Node;

public class MoveZerosToFront {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Node head = null;
			Node curr = null;
			while (n-- > 0) {
				int a = sc.nextInt();
				if (head == null) {
					head = new Node(a);
					curr = head;
				} else {
					Node temp = new Node(a);
					temp.next = null;
					curr.next = temp;
					curr = temp;
				}
			}
			head = moveZeroes(head);
			while (head != null) {
				System.out.print(head.data + " ");
				head = head.next;
			}
			System.out.println();
		}
	}

	public static Node moveZeroes(Node head) {
		Node prev = head;
		Node curr = head.next;
		while (curr != null) {
			if (curr.data == 0) {
				prev.next = curr.next;
				curr.next = head;
				head = curr;
				curr = prev.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;

	}
}