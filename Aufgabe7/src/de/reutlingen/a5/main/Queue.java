package de.reutlingen.a5.main;

import java.util.*;

public class Queue<K> {
	// ListNode aus der Aufgabe 4 (relax) copy&paste
	// http://cs.lmu.edu/~ray/notes/queues/
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
	private ListNode back = null;
	
	public Queue() {

	}
	/**
	 * 
	 * @return string
	 */
	public String toString() {
		ListNode r = front;
		StringBuilder sb = new StringBuilder();
		while (r != null) {
			sb.append(" < " + r.data.toString() + "> ");
			r = r.next;
		}
		return sb.toString();
	}
	/**
	 * Methode zum Einfugen eines Elements in die Queue
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
	}
	/**
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
			return current != null;
		}

		@Override
		public K next() {
			if (current != null) {
				ListNode temp = current;
				current = current.getNext();
				return temp.getData();
			} else {
				throw new NoSuchElementException();
			}
		}

		/**
		 * Method to remove the last element retrieved from the linked list; You
		 * dont want to support this operation so just throw the exception.
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException(
					"Remove not supported for LinkedList");
		}
	}

}
