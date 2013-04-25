package de.reutlingen.aufgabe5.main;

import java.util.*;

public class Queue<K> {
	// ListNode aus der Aufgabe 4 (relax) copy&paste
	private class ListNode {
		ListNode next;
		K data;

		private ListNode(K data, ListNode next) {
			this.next = next;
			this.data = data;
		}

		private K getData() {
			return data;
		}

		private ListNode getNext() {
			return next;
		}
	}
	// man setzt fur anfang und ende beides auf null
	private ListNode front = null;
	private ListNode back = null;//von mir aus brauchen wir nur eins von beiden: entweder front oder back. Schau skript von der Vorlesung an

	public Queue() {

	}

	public String toStringListNode() {
		ListNode l = front;
		StringBuilder sb = new StringBuilder();
		int i = 1;
		while (l != null) {
			sb.append(" < " +  l.data.toString()+"> ");
			i++;
			l = l.next;
		}
		
		return  sb.toString();
		}
	/**
	 * Wozu ist das ? Was soll return sein Provizorisch
	 */
	public String toString() {
		return " " + getIterator();
	}

	/**
	 * Methode zum Einfugen eines Elements in die Queue The enqueue method needs
	 * to check first whether or not the list is empty.
	 * 
	 * @param element
	 */
	public void push(K item) {
		// speichere neues element in ListNode
		ListNode newNode = new ListNode(item, null);
		if (isEmpty()) {
			front = newNode;
		} else {
			back.next = newNode;
		}
		back = newNode;
	}

	/**
	 * Methode zum herausnehmen eines Elements aus der Warteschlange
	 * 
	 * @return
	 */
	public K pull() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		K item = front.data;
		if (back == front) {
			back = null;
		}
		front = front.next;
		return item;
	}

	public boolean isEmpty() {
		return front == null;
	}

	/**
	 * Gibt die Anzahl der in der Liste gespeicherten Elemente zuruck
	 * 
	 * @return count
	 */
	public int size() {
		ListNode node = front;
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
		// for (ListNode node = front; node != null; node = node.next) {
		// count++;
		// } // war diese, habe in neue geschrieben
		// return count;
		// zum delete
	}
	/**
	 * Copy&paste aus der Aufgabe 4. War Freiwillig
	 * 
	 * @return myIterator object
	 */
	public Iterator<K> getIterator() {
		return new myIterator();
	}

	public class myIterator implements Iterator<K> {
		ListNode current;

		public myIterator() {
			current = front;
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
		 * Ivor.Hortons.Beginning.Java.Java.7.Edition Not supported
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove not supported for LinkedList");
		}
	}

}
