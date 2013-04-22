package de.university.aufgabe4.anastasia.main;

import java.util.Iterator;

/*
 * import aufgabe4.List.ListNode; 
 * Ich habe das kommentiert,
 * damit ich auf dieser Stufe arbeiten koente
 */
import de.university.aufgabe4.main.Account; //ICh habe keine Unterschiede zwischen beiden Versionen gefunden
//import meineversion.Account;
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
	private ListNode end;
	/*
	 * Von mir aus, brauchen wir diesen Attributen nicht:
	 * 
	 * private int size;
	 * 
	 */
	
	// private boolean giltEs = false;

	private class ListNode {
		ListNode next;
		K data;

		private void setData(K data) {
			this.data = data;
		}

		private void setNext(ListNode next) {
			this.next = next;
		}
	}

	
	/* Brauchen wir auch gar nicht:
	 * head ist so wieso am Anfang null
	 * int size benötigen wir nicht, gafür wir die Moethode size() benutzt
	 * public List() {
	 * head = null; // initialisiert auf null
	 * size = 5; // grosse ist am anfang 0
	 * }
	 * 
	 * 
	 */
	public List() {
		 head = null; // initialisiert auf null
		 end=null; // grosse ist am anfang 0
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
			sb.append("<" + (l.data).toString() + ">");
			l = l.next;
		}
		return sb.toString();

	}

	/**
	 * Abfragen der Anzahl der Elemente in der Liste: Die Methode gibt die
	 * Anzahl der in der Liste gespeicherten Objekte zuruck.
	 */
	
	public int size() {
		int size=0;
		ListNode l = head;
		while(l!=null) {
		size++;
		l=l.next;
		}		
		return size;
}

	/**
	 * Abfragen eines Elements an einer bestimmten Position. Die Methode liefert
	 * das Objekt an der Stelle pos zuruck. Falls gilt (pos < 0 || pos >=
	 * size()) soll ein Objekt der folgenden Runtime-Exception geworfen werden:
	 * java.lang.IndexOutOfBoundsException Inspiration to
	 * http://www.technicalypto.com/2010/01/linked-lists.html
	 * 
	 * @param ??????
	 * 
	 */
	public K get(int pos) {
		if (pos < 0 || pos >= size()) {
			// giltEs = true;
			throw new IndexOutOfBoundsException();
		}
		ListNode te = head; // Move pointer to front
		int counter = 0;
		for (; counter < pos; counter++) {
			te = te.next;
		}
		return (K) te; // TO DO   Oder te.data muss schauen
 
	}
	
	
	/**
	 * Hinzufugen eines Elements an einer bestimmten Position: Die Methode hangt
	 * das Objekt elem an die bestehende Liste hinten an. Falls gilt
	 * (elem==null) soll ein Objekt der folgenden Runtime-Exception geworfen
	 * werden: java.lang.NullPointerException
	 */
	public void add(K elem) {
		ListNode newEnd = new ListNode(); // Create a new ListItem
			
		if (elem == null) { // Is the element empty?
			throw new NullPointerException();
		} else {
			// No, so append new element
			newEnd.setData(elem);
			if (end!=null){
				end.next = newEnd; // Set next variable for old end
			}
			else {
				head=newEnd;
			}
			
			   }
			end = newEnd; // Store new item as end
		}

	}
	
	/* Kukk mal, das ist meine Version von add() Methode. 
	 * Sieht komplizierter aus, funktioniert aber sicher.
	 * Deine ist viel einfacher und ich wuerde lieber deine benutzen. Gut gemacht!!!
	 * 
	 * public void addK(K elem) {
		if (elem==null)
		{
			throw new java.lang.NullPointerException();
		}
		else {
		ListNode newElem = new ListNode();
		newElem.setData(elem);
		newElem.setNext(null);
		if (size()==0)
			{head=newElem;
			System.out.println("Null ;) "+size());
			}
		else {
		ListNode l = head;
		int i=1;
		while(i<(size()))			
			{//System.out.println(l.data);
			l=l.next;
			i++;}
		//System.out.println(l.data);
		l.setNext(newElem);
		}
		
		}
						
	}
	 * 
	 * 
	 */
	
	
	
	// WICHTIG for Iterator
	/**private class myIterator implements Iterator<K> {

		public myIterator() {
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			return null;
		}
		/**
		 * Method to remove the last element retrieved from the linked list You
		 * don’t want to support this operation so just throw the exception If
		 * you did support this operation, you would need to include a check
		 * that next() has been called, and if not, throw IllegalStateException
		 * Ivor.Hortons.Beginning.Java.Java.7.Edition
		 */
	/*	@Override
		public void remove() {
			throw new UnsupportedOperationException(
					"Remove not supported for LinkedList<>");
		}
	}
	public Iterator<K> iterator() {
		return new myIterator();
	}
}*/
