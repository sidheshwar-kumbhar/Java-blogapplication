/*

Implement Stack using Linked List
Basic Accuracy: 53.98% Submissions: 95K+ Points: 1

Let's give it a try! You have a linked list and you have to implement the 
functionalities push and pop of stack using this given linked list. 
Your task is to use the class as shown in the comments in the code editor and complete 
the functions push() and pop() to implement a stack. 

Example 1:

Input: 
push(2)
push(3)
pop()
push(4) 
pop()
Output: 3 4
Explanation: 
push(2)    the stack will be {2}
push(3)    the stack will be {2 3}
pop()      poped element will be 3,
           the stack will be {2}
push(4)    the stack will be {2 4}
pop()      poped element will be 4

Example 2:

Input: 
pop()
push(4)
push(5)
pop()
Output: -1 5
Your Task: You are required to complete two methods push() and pop(). 
The push() method takes one argument, an integer 'x' to be pushed into 
the stack and pop() which returns an integer present at the top and popped 
out from the stack. If the stack is empty then return -1 from the pop() method.

Expected Time Complexity: O(1) for both push() and pop().
Expected Auxiliary Space: O(1) for both push() and pop().

Constraints:
1 <= Q <= 100
1 <= x <= 100

 */

package com.java.example.dsa.gfg.linkedlist;

import java.util.*;
import com.java.example.dsa.StackNode;

public class ImplementStackUsingLinkedList {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			MyStack obj = new MyStack();
			int Q = sc.nextInt();
			while (Q > 0) {
				int QueryType = 0;
				QueryType = sc.nextInt();
				if (QueryType == 1) {
					int a = sc.nextInt();
					obj.push(a);
				} else if (QueryType == 2) {
					System.out.print(obj.pop() + " ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		}
	}
}

// } Driver Code Ends

class MyStack {
	StackNode top;

	// Function to push an integer into the stack.
	void push(int a) {
		StackNode node = new StackNode(a);
		if (top == null) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
	}

	// Function to remove an item from top of the stack.
	int pop() {
		if (top != null) {
			StackNode tmpNode = top;
			top = top.next;
			return tmpNode.data;
		} else {
			return -1;
		}
	}
}
