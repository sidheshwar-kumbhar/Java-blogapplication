/*********************************************************************************************** /
//
// Class Name : SinglyLinkedListMain
// File/Class/Function Description: This class is used for run main method
//
// Revision History
//   Date:           			  Changed By    	            Revision Comments
//   15/05/2022 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/************************************************************************************************/
package com.dsa.java.example.dev.v2;

public class SinglyLinkedListMain {
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.displayList();
		singlyLinkedList.insert(0);
		singlyLinkedList.createList();
		singlyLinkedList.displayList();
		singlyLinkedList.displayListRecursively(singlyLinkedList.head);
		System.out.println(singlyLinkedList.search(singlyLinkedList.head, 10));
		System.out.println(singlyLinkedList.search(singlyLinkedList.head, 20));
		System.out.println(singlyLinkedList.size(singlyLinkedList.head));
	}
}
