package com.dsa.java.example.dev.v2;


public class SinglyLinkedList {

	public Node head;

	public void createList() {
		if (this.head == null) {
			this.head = new Node(0);
		}
		for (int i = 1; i <= 10; i++) {
			this.insert(i);
		}
	}

	public void displayList() {
		if (this.head == null) {
			System.out.println("Singly Linked List is empty !");
		} else {
			Node correntNode = this.head;
			do {
				System.out.print(correntNode.getData() + " -> ");
				correntNode = correntNode.getNext();
			} while (correntNode != null);
			System.out.println(" Null ");
		}
	}

	public void insert(int data) {
		Node node = new Node(data);
		Node last = this.head;
		if (last == null) {
			last = node;
		} else {
			while (last.getNext() != null) {
				last = last.getNext();
			}
			last.setNext(node);
		}
	}

	public void insertAfter(Node previousNode, int dataToBeInserted) {
		if (previousNode == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		Node newNode = new Node(dataToBeInserted);
		newNode.next = previousNode.next;
		previousNode.next = newNode;
	}

	public boolean search(Node head, int data) {
		if (head == null)
			return false;
		if (head.data == data)
			return true;
		return search(head.next, data);
	}

	public int size(Node head) {
		int count = 0;
		Node currNode = head;
		while (currNode != null) {
			count++;
			currNode = currNode.next;
		}
		return count;
	}

	public void deleteAtPosition(Node head, int pos) {
		System.out.println("trying to delete node at position:" + pos);

		Node currentNode = head;
		Node prev = null;
		int counter = 0;

		if (currentNode != null) {
			if (pos == 0) {
				head = currentNode.next;
				System.out.println("element at position" + pos + " has been deleted");
			} else {
				// Count for the pos to be deleted, keep track of the previous node as it is
				// needed to change currentNode.next
				while (currentNode != null) {
					if (counter == pos) {
						prev.next = currentNode.next;
						System.out.println("element at " + pos + " has been deleted");
						break;
					} else {
						prev = currentNode;
						currentNode = currentNode.next;
						counter++;
					}
				}
			}
		}
		if (pos > counter) {
			System.out.println("no node found at position:" + pos + " ,as it greater than the size of the list");
		}

	}

	public void deleteByKey(Node head, int data) {
		System.out.println("trying to delete node with data:" + data);
		// Store head node
		Node currentNode = head;
		Node prev = null;

		if (currentNode != null) {
			if (currentNode.data == data) {
				head = currentNode.next; // Changed head
				System.out.println("element " + data + " has been deleted");
			} else {
				while (currentNode != null && currentNode.data != data) {
					prev = currentNode;
					currentNode = currentNode.next;
				}
				if (currentNode != null) {
					prev.next = currentNode.next;
					System.out.println("element " + data + " has been deleted");
				} else {
					System.out.println("no node found with data:" + data);
				}
			}
		}
	}
}