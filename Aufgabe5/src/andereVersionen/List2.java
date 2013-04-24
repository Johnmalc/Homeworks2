package andereVersionen;

import java.util.*;

public class List2<K> implements Iterable<K> {
	/*
	 * Kopf der Liste, reprasentiert die ganze Liste
	 */
	ListNode head;
	/**
	 * Kopf wird auf null gesetzt -> kein Verweis auf ein Object
	 */
	public List2() {
		head = null;
	}
	/**
	 * Beginn innere Klasse; ListNode ListNode next ist Variable vom Typ
	 * ListNode, verweist auf die nachste Referenz
	 */
	public class ListNode {
		K data; // Variable vom Typ K
		ListNode next;
		/**
		 * Konstrukto der Klasse ListNode ubergeben vom Typ data next wird auf
		 * null gesetzt, kein Verweis auf eine Referenz
		 */
		public ListNode(K newData) {
			data = newData;
			next = null;
		}
		/**
		 * setter Methode, nachstes Element wird bergeben
		 * 
		 */
		public void setNext(ListNode newNext) {
			next = newNext;
		}
		/**
		 * Getter Methode; Wenn next ungleich null gib next zuruck > Ansonsten
		 * haben wir keinen Verweis auf eine Referenz
		 * 
		 * @return
		 */
		public ListNode getNext() {
			if (next != null) {
				return next;
			}
			return null;
		}

		/**
		 * Liefert true, wenn es ein vorhergehendes/nachfolgendes Element gibt.
		 * 
		 * @return
		 */
		public boolean hasNext() {
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
		/**
		 * has Next liefert true zuruck, wenn falls weitere Elemente vorhanden
		 * sind 
		 * Wenn nicht am Ende der Liste Gib das nachste Element zuruck Wenn
		 * am Ende lieger false zuruck
		 */
		@Override
		public boolean hasNext() {
			if (current != null) {
				return current.hasNext();
			}
			return false;
		}
		/**
		 * Methode next Liefert nachstes Element in der Aufzahlung
		 */
		@Override
		public K next() {
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
