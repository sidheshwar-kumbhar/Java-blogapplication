package com.java.example.dsa;

public class Node {
	public int data;
	public Node next;
	public Node prev;

	public Node(int d) {
		data = d;
		next = prev = null;
	}
}