package com.dsa.java.example.dev.v1;

public class SinglyLinkedList {
	public static void main(String[] args) {

		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		Node home = singlyLinkedList.createList();
		singlyLinkedList.displayList(home);
	}

	public Node createList() {
		Node home = null;
		Node correntNode = null;
		Node nextNode = null;
		for (int i = 1; i <= 10; i++) {
			if (i == 1) {
				home = new Node(i, null);
				correntNode = home;
			} else {
				nextNode = new Node(i, null);
				correntNode.setNext(nextNode);
				correntNode = nextNode;
			}
		}

		return home;
	}

	public void displayList(Node home) {
		if (home == null) {
			System.out.print("Singly Linked List is empty !");
		} else {
			Node correntNode = home;
			do {
				System.out.print(correntNode.getData() + " -> ");
				correntNode = correntNode.getNext();
			} while (correntNode != null);
			System.out.print(" Null ");
		}
	}
}