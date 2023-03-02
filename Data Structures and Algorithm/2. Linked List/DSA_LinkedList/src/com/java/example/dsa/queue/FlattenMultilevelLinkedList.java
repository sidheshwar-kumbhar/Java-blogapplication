package com.java.example.dsa.queue;

import com.java.example.dsa.linkedlist.node.ListNode;

public class FlattenMultilevelLinkedList {

	public static void main(String[] args) {
		FlattenMultilevelLinkedList list = new FlattenMultilevelLinkedList();
		ListNode head = list.createList();
		list.flattenList(head);
		list.printList(head);
	}
	
	public void flattenList(ListNode head) {
		ListNode node = head;
		LinkedListQueue queue = new LinkedListQueue();
		while (node.next != null) {
			if(node.child != null) {
				queue.enqueue(node.child);
				node.child = null;
			}
			node = node.next;
		}
		
		while(!queue.isNull()) {
			ListNode tmpNode = queue.peek();
			queue.dequeue();
			node.next = tmpNode;
			while(node.next != null) {
				if(node.child != null) {
					//queue.enqueue(node.child);
					node.child = null;
				}
				node = node.next;
			}
		}
	}

	public ListNode createList(int arr[], int n) {
		ListNode head = null;
		ListNode node = null;
		for (int i = 0; i < n; i++) {
			if (head == null) {
				node = new ListNode(arr[i]);
				head = node;
			} else {
				node.next = new ListNode(arr[i]);
				node.child = null;
				node = node.next;
			}
		}
		return head;
	}

	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println(" NULL ");
	}

	public ListNode createList() {
		int arr1[] = new int[] { 10, 5, 12, 7, 11 };
		int arr2[] = new int[] { 4, 20, 13 };
		int arr3[] = new int[] { 17, 6 };
		int arr4[] = new int[] { 9, 8 };
		int arr5[] = new int[] { 19, 15 };
		int arr6[] = new int[] { 2 };
		int arr7[] = new int[] { 16 };
		int arr8[] = new int[] { 3 };

		/* create 8 linked lists */
		ListNode head1 = createList(arr1, arr1.length);
		ListNode head2 = createList(arr2, arr2.length);
		ListNode head3 = createList(arr3, arr3.length);
		ListNode head4 = createList(arr4, arr4.length);
		ListNode head5 = createList(arr5, arr5.length);
		ListNode head6 = createList(arr6, arr6.length);
		ListNode head7 = createList(arr7, arr7.length);
		ListNode head8 = createList(arr8, arr8.length);

		/* modify child pointers to create the list shown above */
		head1.child = head2;
		head1.next.next.next.child = head3;
//		head3.child = head4;
//		head4.child = head5;
//		head2.next.child = head6;
//		head2.next.next.child = head7;
//		head7.child = head8;

		/*
		 * Return head pointer of first linked list. Note that all nodes are reachable
		 * from head1
		 */
		return head1;
	}
}
