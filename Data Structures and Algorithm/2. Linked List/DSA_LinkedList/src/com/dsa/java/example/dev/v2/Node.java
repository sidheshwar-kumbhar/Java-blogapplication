/**************************************************************************************************************************** /
//
// Class Name : Node
// File/Class/Function Description: This class is used for data node
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   15/05/2022 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/
package com.dsa.java.example.dev.v2;

public class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
