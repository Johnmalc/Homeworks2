package de.university.aufgabe4.main;

import java.util.Iterator;
/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class List<K> implements Iterator<K> {
	/*
	 * Some information was taken from
	 * http://docs.oracle.com/javase/7/docs/api/index.html?java/util/List.html
	 */
	private ListNode head;
	private int size;
	// private boolean giltEs = false;

	private class ListNode {
		private ListNode next;
		private K data;

		private void setData(K data) {
			this.data = data;
		}

		private void setNext(ListNode next) {
			this.next = next;
		}
	}

	public List() {
		head = null; // initialisiert auf 1
		size = 0; // grosse ist am anfang 0

	}

	public void insertFirst(K elem) {
		ListNode newHead = new ListNode();
		newHead.setData(elem);
		newHead.setNext(head);
		head = newHead;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	public boolean isEmpty() {
		return head == null;

	}
	/**
	 * 
	 * return string
	 */
	public String toString() {
		ListNode l = head;
		StringBuilder sb = new StringBuilder();
		while (l != null) {
			sb.append("<" + l.data + ">");
			l = l.next;
		}
		return sb.toString();

	}

	/**
	 * Abfragen der Anzahl der Elemente in der Liste: Die Methode gibt die
	 * Anzahl der in der Liste gespeicherten Objekte zuruck.
	 */
	public int size() {
		return this.size;

	}

	/**
	 * Abfragen eines Elements an einer bestimmten Position. Die Methode liefert
	 * das Objekt an der Stelle pos zuruck. Falls gilt (pos < 0 || pos >=
	 * size()) soll ein Objekt der folgenden Runtime-Exception geworfen werden:
	 * java.lang.IndexOutOfBoundsException
	 * 
	 * @param giltEs
	 * 
	 */
	public K get(int pos) {
		if (pos < 0 || pos >= size()) {
			// giltEs = true;
			throw new IndexOutOfBoundsException();
		} else {
			// giltEs = false;
			// return
		}
		return null;

	}

	/**
	 * Hinzufugen eines Elements an einer bestimmten Position: Die Methode hangt
	 * das Objekt elem an die bestehende Liste hinten an. Falls gilt
	 * (elem==null) soll ein Objekt der folgenden Runtime-Exception geworfen
	 * werden: java.lang.NullPointerException
	 */
	public void add(K elem) {
		if (elem == null) {
			throw new NullPointerException();
		} else {
			// head.setNext(next);
			// size++;
		}

	}

	// WICHTIG for Iterator

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public K next() {
		return null;
	}

	@Override
	public void remove() {

	}
}
