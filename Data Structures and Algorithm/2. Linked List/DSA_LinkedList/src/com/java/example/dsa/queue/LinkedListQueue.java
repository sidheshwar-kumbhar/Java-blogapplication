package com.java.example.dsa.queue;

import com.java.example.dsa.linkedlist.node.ListNode;

public class LinkedListQueue {
	ListNode head = null;
	ListNode tail = head;
	int capacity = 20;
	int count = 0;

	public static void main(String[] args) {

		LinkedListQueue queue = new LinkedListQueue();
		queue.enqueue(new ListNode(1));
		queue.enqueue(new ListNode(2));
		queue.enqueue(new ListNode(3));
		queue.enqueue(new ListNode(4));
		queue.enqueue(new ListNode(5));
		queue.enqueue(new ListNode(6));
		queue.enqueue(new ListNode(7));
		queue.enqueue(new ListNode(8));
		queue.enqueue(new ListNode(9));
		queue.enqueue(new ListNode(10));
		System.out.println(queue.enqueue(new ListNode(11)));

		queue.print();

		queue.dequeue();

		queue.print();

		ListNode node = queue.peek();
		if (node != null) {
			System.out.println("Peek = " + node.val);
		}

		System.out.println("isFull = " + queue.isFull());

		queue.enqueue(new ListNode(11));

		System.out.println("isFull = " + queue.isFull());
		System.out.println("isNull = " + queue.isNull());

	}

	public boolean enqueue(ListNode node) {
		if (count < capacity) {
			if (tail == null) {
				head = tail = node;
			} else {
				tail.next = node;
				tail = tail.next;
			}
			count++;
			return true;
		}
		return false;
	}

	public boolean dequeue() {
		if (count == 0) {
			return false;
		}
		head = head.next;
		count--;
		return true;
	}

	public ListNode peek() {
		return head;
	}

	public boolean isFull() {
		return !(count < capacity);
	}

	public boolean isNull() {
		return count == 0;
	}

	public void print() {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.val + " - > ");
			node = node.next;
		}
		System.out.println(" NULL ");
	}

}
