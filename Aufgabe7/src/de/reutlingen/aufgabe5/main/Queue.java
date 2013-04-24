package de.reutlingen.aufgabe5.main;

import java.util.Iterator;

public class Queue<K> {
	private class ListNode {
		public ListNode next;
		K data;

		// for add method only
		private ListNode(K elem, ListNode next) {
			this.data = elem;
			this.next = next;
		}

		private ListNode() {

		}

		public String toString() {
			return next + " : " + data;
		}

		public ListNode getNext() {
			return next;
		}

		public K getData() {
			return data;
		}
	}

	private ListNode front;
	private ListNode back;

	public Queue() {
		front = null;
	}

	/**
	 * 
	 */
	public String toString() {
		return "Queue [] " + front;
	}

	/**
	 * Methode zum Einfügen eines Elements in die Queue The enqueue method needs
	 * to check first whether or not the list is empty. In that case a new node
	 * is created and the front and back are the same. If the list is not empty,
	 * a new node is added at the back of the old list, and this becomes the
	 * back of the new list.
	 * 
	 * @param element
	 */
	public void push(K element) {
		if (front == null) {
			front = back = new ListNode(element, null);
		} else {
			back = back.next = new ListNode(element, null);
		}
	}

	/**
	 * Methode zum herausnehmen eines Elements aus der Warteschlange
	 * 
	 * @return
	 */
	public K pull() {
		if (front == null) {
			System.out.println("error");
		} else {
			K item = front.data;
			front = front.next;
			return item;
		}
		return null;
	}

	public boolean isEmpty() {
		return front == null;
	}

	/**
	 * Gibt die Anzahl der in der Liste gespeicherten Elemente zurück
	 * 
	 * @return
	 */
	public int size() {
		return 0;

	}

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
			throw new UnsupportedOperationException(
					"Remove not supported for LinkedList<>");
		}
	}

}
