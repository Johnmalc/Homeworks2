package de.reutlingen.aufgabe5.ana.main;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 *           
 */

import java.util.*;

public class Queue<K> {
	// ListNode aus der Aufgabe 4 (relax) copy&paste
	private class ListNode<K> {
		ListNode<K> next;
		K data;

		private ListNode(K data, ListNode<K> next) {
			this.next = next;
			this.data = data;
		}

		private K getData() {
			return data;
		}

		private ListNode<K> getNext() {
			return next;
		}
	}

	
	private ListNode<K> erstes;
    private ListNode<K> letztes;

	public Queue() {

	}

	/**
	 * 
	 * @return string
	 */
	public String toString() {
		ListNode <K> k = erstes;
		StringBuilder sb = new StringBuilder();
		while (k != null) {
			sb.append(" < " + k.data.toString() + "> ");
			k = k.next;
		}
		return sb.toString();
	}

	/**
	 * Methode zum Einfugen eines Elements in die Queue The enqueue method needs
	 * to check first whether or not the list is empty.
	 * 
	 * @param element
	 */
	public void push(K item) {
		ListNode <K> LN=new ListNode<K>(item, null);
		if (erstes==null)
		{
		erstes=LN;
		letztes=LN;
		}
		else{
			letztes.next=LN;
			letztes=LN;	
		}
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
		K item = erstes.data;
		erstes = erstes.next;
		return item;
	}

	/**
	 * Gibt true zurueck, wenn die Liste leer ist
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return erstes == null;
	}

	/**
	 * Gibt die Anzahl der in der Liste gespeicherten Elemente zuruck
	 * 
	 * @return count
	 */
	public int size() {
		ListNode<K> node = erstes;
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}

	/**
	 * Implementierung der Methode java.util.Iterator<K> iterator()
	 * 
	 * @return myIterator object
	 */
	public Iterator<K> iterator() {
		return new myIterator();
	}

	public class myIterator implements Iterator<K> {
		ListNode<K> current;

		public myIterator() {
			current = erstes;
		}

		public boolean hasNext() {
			return current != null;
		}

		@Override
		public K next() {
			if (current != null) {
				ListNode<K> temp = current;
				current = current.getNext();
				return temp.getData();
			} else {
				throw new NoSuchElementException();
			}
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
					"Remove not supported for LinkedList");
		}
	}

}
