package de.university.aufgabe4.main;

import java.util.*;

public class List2<K> implements Iterable<K> {

	ListNode head; // Kopf der Liste, repr�sentiert die ganze Liste

	public List2() {
		head = null; // Kopf wird auf null gesetzt -> kein Verweis auf ein
						// Object
	}

	public class ListNode { // Beginn innere Klasse ListNode
		K data; // Variable vom Typ K
		ListNode next; // Variable vom Typ ListNode, verweist auf die n�chste
						// Referenz

		public ListNode(K newData) { // Konstrukto der Klasse ListNode
			data = newData; // �bergeben vom Typ data
			next = null; // next wird auf null gesetzt, kein Verweis auf eine
							// Referenz
		}

		public void setNext(ListNode newNext) { // setter Methode, n�chstes
												// Element wird �bergeben
			next = newNext;
		}

		public ListNode getNext() { // Getter Methode
			if (next != null) { // Wenn next ungleich null gib next zur�ck
				return next;
			}
			return null; // Ansonsten haben wir keinen Verweis auf eine Referenz
		}

		public boolean hasNext() { // Liefert true, wenn es ein
									// vorhergehendes/nachfolgendes Element
									// gibt.
			if (next == null) {
				return false;
			}
			return true;
		}

		public String toString() {
			return data.toString() + " " + next.toString();
		}

		public K getData() {
			return data;
		}
	}

	public class myIterator implements Iterator<K> { // Klasse myIterator
		public ListNode current;

		public myIterator() {
			current = head; // >Konstruktor, Fang am Anfang an
		}

		@Override
		public boolean hasNext() { // has Next liefert true zur�ck, wenn falls
									// weitere Elemente vorhanden sind
			if (current != null) { // Wenn nicht am Ende der Liste
				return current.hasNext(); // Gib das n�chste Element zur�ck
			}
			return false; // Wenn am Ende lieger false zur�ck
		}

		@Override
		public K next() { // Methode next Liefert n�chstes Element in der
							// Aufz�hlung
			ListNode temp = current;
			current = current.getNext();
			return temp.getData();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public String toString() {
		if (head != null) {
			return head.toString();
		}
		return null;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public void insertFirst(K newElement) {
		ListNode port = new ListNode(newElement);
		if (head != null) {
			port.setNext(head);
		}
		head = port;
	}

	public int size() {
		int dataSize = 0;
		ListNode iterating = head;
		while (iterating != null) {
			dataSize++;
			iterating = iterating.getNext();
		}
		return dataSize;
	}

	public K get(int pos) {
		ListNode iterating = head;
		int i;
		for (i = 0; i < pos && iterating != null; i++, iterating = iterating
				.getNext());
		return iterating.getData();
	}

	public void add(K newElement) {
		ListNode temp = new ListNode(newElement);
		ListNode iterating = head;
		if (head == null) {
			head = temp;
			return;
		}
		for (; iterating.hasNext(); iterating = iterating.getNext());
		iterating.setNext(temp);
	}

	@Override
	public Iterator<K> iterator() {
		return new myIterator();
	}
}
