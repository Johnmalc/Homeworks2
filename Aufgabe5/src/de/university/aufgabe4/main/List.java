package de.university.aufgabe4.main;

import java.util.Iterator;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class List<K> {
	/*
	 * http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html 
	 * Some information was taken from
	 * http://docs.oracle.com/javase/7/docs/api/index.html?java/util/List.html
	 */
	private ListNode head;
	private class ListNode {
		ListNode next;
		K data;
		
		// for add method only
		private ListNode(K elem) {
			this.data = elem;
		}

		private ListNode() {

		}
		private void setData(K data) {
			this.data = data;
		}

		private void setNext(ListNode next) {
			this.next = next;
		}
		// for interator
		public K getData() {
			return data;
		}

		public ListNode getNext() {
			return next;
		}
	} // ende von private ListNode class

	public List() {
		head = null;
	}

	/**
	 * Fugt erster element in die liste
	 */
	public void insertFirst(K elem) {
		ListNode newHead = new ListNode();
		newHead.setData(elem);
		newHead.setNext(head);
		head = newHead;
	}

	/**
	 * @return alle elemente in der liste
	 * Bischne bearbeitet
	 * 
	 */
	public String toString() {
		ListNode l = head;
		StringBuilder sb = new StringBuilder();
		int i = 1;
		while (l != null) {
			sb.append(i + " "+ l.data + "\n");
			i++;
			l = l.next;
		}
		return sb.toString();
	}

	/**
	 * Abfragen eines Elements an einer bestimmten Position. Die Methode liefert
	 * das Objekt an der Stelle pos zuruck. Falls gilt (pos < 0 || pos >=
	 * size()) soll ein Objekt der folgenden Runtime-Exception geworfen werden:
	 * java.lang.IndexOutOfBoundsException Inspiration to
	 * http://www.technicalypto.com/2010/01/linked-lists.html
	 * 
	 */
	public K get(int pos) {
		ListNode var = head;
		if (pos < 0 || pos >= size()) {
			throw new IndexOutOfBoundsException();
		} else {
			for (int i = 1; i < pos; i++) {
				var = var.next;
			}
			return var.data;
		}
	}

	/**
	 * Hinzufugen eines Elements an einer bestimmten Position: Die Methode hangt
	 * das Objekt elem an die bestehende Liste hinten an. Falls gilt
	 * (elem==null) soll ein Objekt der folgenden Runtime-Exception geworfen
	 * werden: java.lang.NullPointerException
	 * http://stackoverflow.com/questions/
	 * 5236486/adding-items-to-end-of-linked-list I would like to thank to Pavel
	 * Bennett here
	 * http://www.mycstutorials.com/articles/data_structures/linkedlists 
	 * Thank you very much.
	 */
	public void add(K elem) {
<<<<<<< HEAD
			if (elem == null) {
=======
		if (elem == null) {
>>>>>>> f9c2250a6aaac3ecc2747458d2a5649f3f5eb7d6
			throw new NullPointerException();
		} else {
			ListNode newElem = new ListNode();
			newElem.setData(elem); // speichere daten
			newElem.setNext(null); // setze aktuales element auf keine neue referenz  
			if (size() == 0) { 
<<<<<<< HEAD
				head = newElem; // wenn die Loiste noch leer ist, setze aktuelles element als erstes (head)
			} else {
				ListNode l = head;
				int i = 1;
				while (i < size()) {
					l = l.next;
					i++;
				}
				l.setNext(newElem);
=======
				head = newElem; // wenn die Liste noch leer ist, setze aktuelles element als erstes (head)
			} else {
				ListNode k = head;
				int i = 1;
				while (i < size()) {
					k = k.next;
					i++;
				}
				k.setNext(newElem);
>>>>>>> f9c2250a6aaac3ecc2747458d2a5649f3f5eb7d6
			}
		}
	}

	public Iterator<K> getIterator() {
		return new myIterator();
	}
	public class myIterator implements Iterator<K>{
		ListNode current;

		public myIterator() {
			current = head;
		}
		public boolean hasNext() {
			if (current != null) {
				return true;
			} else
				return false;
		}
		@Override
		public K next() {
			ListNode temp = current;
			current = current.getNext();
			return temp.getData();
		}
		
		/**
		 * Method to remove the last element retrieved from the linked list; You
		 * don’t want to support this operation so just throw the exception. If
		 * you did support this operation, you would need to include a check
		 * that next() has been called, and if not, throw IllegalStateException
		 * Ivor.Hortons.Beginning.Java.Java.7.Edition
		 * Not supported
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove not supported for LinkedList<>");
		}	
	}

	/**
	 * Abfragen der Anzahl der Elemente in der Liste: Die Methode gibt die
	 * Anzahl der in der Liste gespeicherten Objekte zuruck.
	 */
	public int size() {
		int anzahl = 0;
		ListNode zahl = head;
		while (zahl != null) {
			anzahl++;
			zahl = zahl.next;
		}
		return anzahl;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	public boolean isEmpty() {
		return head == null;
	}
}
