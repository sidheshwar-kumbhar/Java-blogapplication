/*********************************************************************************************** /
//
// Class Name : SinglyLinkedList
// File/Class/Function Description: This class is used for SinglyLinkedList
//
// Revision History
//   Date:           			  Changed By    	            Revision Comments
//   15/05/2022 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/************************************************************************************************/
package com.dsa.java.example.dev.v2;

public class SinglyLinkedList {

	// Head node to start Singly Linked List
	public Node head;

	/***********************************************************************************************
	 * Function Name: createList() : This function is used to create list
	 * 
	 * @parameter(s) : NA
	 * 
	 * @return: NA
	 * @author Sidheshwar Kumbhar
	 ************************************************************************************************/
	public void createList() {
		if (this.head == null) {
			this.head = new Node(0);
		}
		for (int i = 1; i <= 10; i++) {
			this.insert(i);
		}
	}

	/************************************************************************************************
	 * Function Name: displayList() : This function is used to display nodes from
	 * list using do-while loop
	 * 
	 * @parameter(s) : NA
	 * 
	 * @return: NA
	 * @author Sidheshwar Kumbhar
	 ************************************************************************************************/
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

	/************************************************************************************************
	 * Function Name: displayListRecursively() : This function is used to display
	 * nodes from list using recursively
	 * 
	 * @parameter(s) : NA
	 * 
	 * @return: NA
	 * @author Sidheshwar Kumbhar
	 ************************************************************************************************/
	public void displayListRecursively(Node head) {
		if (head == null) {
			System.out.println(" Null ");
		} else {
			Node correntNode = head;
			System.out.print(correntNode.getData() + " -> ");
			this.displayListRecursively(correntNode.getNext());

		}
	}

	/************************************************************************************************
	 * Function Name: insert() : This function is used to insert data in list
	 * 
	 * @parameter(s) : data - data need to be insert in the list
	 * 
	 * @return: NA
	 * @author Sidheshwar Kumbhar
	 ************************************************************************************************/
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

	/************************************************************************************************
	 * Function Name: insertAfter() : This function is used to insert data in list
	 * after data node
	 * 
	 * @parameter(s) : previousNode - Insert data after this node, dataToBeInserted
	 * - data need to be insert in the list
	 * 
	 * @return: NA
	 * @author Sidheshwar Kumbhar
	 ************************************************************************************************/
	public void insertAfter(Node previousNode, int dataToBeInserted) {
		if (previousNode == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		Node newNode = new Node(dataToBeInserted);
		newNode.next = previousNode.next;
		previousNode.next = newNode;
	}

	/************************************************************************************************
	 * Function Name: search() : This function is used to search on the data using
	 * recursively
	 * 
	 * @parameter(s) : head - Head node, data - data to be search
	 * 
	 * @return: true / false
	 * @author Sidheshwar Kumbhar
	 ************************************************************************************************/
	public boolean search(Node head, int data) {
		if (head == null)
			return false;
		if (head.data == data)
			return true;
		return search(head.next, data);
	}

	/************************************************************************************************
	 * Function Name: size() : This function is used to get size of list
	 * 
	 * @parameter(s) : head - Head node,
	 * 
	 * @return: list size
	 * @author Sidheshwar Kumbhar
	 ************************************************************************************************/
	public int size(Node head) {
		int count = 0;
		Node currNode = head;
		while (currNode != null) {
			count++;
			currNode = currNode.next;
		}
		return count;
	}

	/************************************************************************************************
	 * Function Name: deleteAtPosition() : This function is used to delete node at
	 * position
	 * 
	 * @parameter(s) : head - Head node, pos - position
	 * 
	 * @return: NA
	 * @author Sidheshwar Kumbhar
	 ************************************************************************************************/
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

	/************************************************************************************************
	 * Function Name: deleteByKey() : This function is used to delete node by data
	 * 
	 * @parameter(s) : head - Head node, data - data
	 * 
	 * @return: NA
	 * @author Sidheshwar Kumbhar
	 ************************************************************************************************/
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
	
	/************************************************************************************************
	 * Function Name: printReverse() : This function is used to print linked list reverse by recursively
	 * 
	 * @parameter(s) : head - Head node
	 * 
	 * @return: NA
	 * @author Sidheshwar Kumbhar
	 ************************************************************************************************/
	public void printRecursivelyReverse(Node head) {
		if(head == null) {
			System.out.println();
		}
		
	}
}