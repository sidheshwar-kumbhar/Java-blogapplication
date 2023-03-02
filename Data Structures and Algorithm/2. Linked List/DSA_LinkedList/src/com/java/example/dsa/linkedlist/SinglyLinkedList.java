package com.java.example.dsa.linkedlist;

import com.java.example.dsa.linkedlist.node.DataNode;

public class SinglyLinkedList {
	DataNode head = null;

	public boolean add(int data) {
		DataNode node = new DataNode(data);
		if (head == null) {
			node.count = 1;
			head = node;
		} else {
			DataNode current = this.getLastNode();
			node.count = current.count + 1;
			current.next = node;
		}
		return true;
	}

	public DataNode getLastNode() {
		DataNode node = head;
		while (node.next != null) {
			node = node.next;
		}
		return node;
	}

	public void print() {
		DataNode node = head;
		while (node.next != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.print(node.data + " -> NULL");
	}

	public void printOneGap() {
		DataNode node = head;
		while (node.next != null && node.next.next != null) {
			System.out.print(node.data + " -> ");
			node = node.next.next;
		}
		System.out.print(node.data + " -> NULL");
	}

	public void printReverse(DataNode node) {
		if (node.next != null) {
			printReverse(node.next);
			System.out.print(" <- ");
		} else {
			System.out.print("NULL <- ");
		}
		System.out.print(node.data);
	}

	public SinglyLinkedList copy() {
		DataNode node = head;
		SinglyLinkedList copyLL = new SinglyLinkedList();
		DataNode tmpNode = null;

		tmpNode = new DataNode(node.data);
		tmpNode.count = node.count;
		copyLL.head = tmpNode;

		DataNode current = tmpNode;
		while (node.next != null) {
			node = node.next;
			tmpNode = new DataNode(node.data);
			tmpNode.count = node.count;
			current.next = tmpNode;
			current = tmpNode;
		}
		return copyLL;
	}

	public void printReverseOneGap(SinglyLinkedList singlyLinkedList) {
		DataNode node = singlyLinkedList.head;
		while(node.next != null) {
			DataNode current = node;
			DataNode next = current.next;
			current.next = node;
			node = next;
		}
		singlyLinkedList.head = node;
	}
}
