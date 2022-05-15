package com.dsa.java.example.dev.v2;

public class SinglyLinkedListMain {
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.displayList();
		singlyLinkedList.insert(0);
		singlyLinkedList.createList();
		singlyLinkedList.displayList();
		System.out.println(singlyLinkedList.search(singlyLinkedList.head, 10));
		System.out.println(singlyLinkedList.search(singlyLinkedList.head, 20));
		System.out.println(singlyLinkedList.size(singlyLinkedList.head));
	}
}
