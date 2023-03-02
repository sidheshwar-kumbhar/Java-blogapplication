package com.java.example.dsa.linkedlist;

public class SinglyLinkedListMain {
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		singlyLinkedList.print();

		System.out.print("\n");
		singlyLinkedList.printReverse(singlyLinkedList.head);

		System.out.print("\n");
		singlyLinkedList.printOneGap();

		SinglyLinkedList copySinglyLinkedList = singlyLinkedList.copy();
		System.out.print("\n");
		copySinglyLinkedList.print();
		
		singlyLinkedList.printReverseOneGap(copySinglyLinkedList);
		
		System.out.print("\n");
		copySinglyLinkedList.print();
	}
}