Exercise 4

Programmieren Sie die Klasse List<K> aus der Vorlesung.

a) Implementieren sie dabei die folgenden Methoden wie in der Vorlesung beschrieben:

    public String toString() {...}
    public boolean isEmpty() {...}
    public void insertFirst(K elem) {...}


b) Erweitern Sie Ihre Klasse List<K> um die folgenden Methoden:

    Abfragen der Anzahl der Elemente in der Liste:

    public int size() {...}
    Die Methode gibt die Anzahl der in der Liste gespeicherten Objekte zurück.
    Abfragen eines Elements an einer bestimmten Position:

    public K get(int pos) {...}
    Die Methode liefert das Objekt an der Stelle pos zurück. Falls gilt (pos < 0 || pos >= size()) soll ein Objekt der folgenden Runtime-Exception geworfen werden: java.lang.IndexOutOfBoundsException

    Hinzufügen eines Elements an einer bestimmten Position:

    public void add(K elem) {...}
    Die Methode hängt das Objekt elem an die bestehende Liste hinten an. Falls gilt (elem==null) soll ein Objekt der folgenden Runtime-Exception geworfen werden: java.lang.NullPointerException

Schreiben Sie eine Testklasse Main und Testen Sie die neuen Methoden der Liste ausführlich.

Testen Sie die Klasse List insbesondere unter Verwendung der Klasse Account (aus Aufgabe 1) als Konkretisierung des Typ-Parameters. Fügen Sie beim Test 2 Account-Objekte der Liste hinzu und geben Sie die Liste auf der Konsole aus. Prüfen Sie vor und nach dem Hinzufügen der Elemente den Rückgabewert der Methode isEmpty(). Fügen Sie ein weiteres Account-Objekt mit Hilfe der Methode insertFirst(...) in die Liste ein. Überprüfen Sie die Korrektheit indem Sie die Liste erneut auf der Konsole ausgeben.

c)Ersetzen Sie das Account-Array in der Klasse CashMachine durch Ihre eigene Klasse List. Passen Sie ihre Klasse CashMachine entsprechend  an.

d) Implementieren Sie die Methode java.util.Iterator<K> iterator() {...} unter Verwendung einer geeigneten (inneren) Klasse wie in der Vorlesung besprochen. Testen Sie Ihren Iterator ausführlich!


package de.university.neueVersion.app;
import java.util.Iterator;

public class List<K> implements Iterator<K> {
    /*
	 * Some information was taken from
	 * http://docs.oracle.com/javase/7/docs/api/index.html?java/util/List.html
	 */
	private ListNode head;
	private int size;
	boolean giltEs = false;

	private class ListNode {
		ListNode next;
		K data;

		void setData(K data) {
			this.data = data;
		}

		void setNext(ListNode next) {
			this.next = next;
		}
	}

	public List() {
		head=null; // initialisiert auf 1
		size=0; // grosse ist am anfang 0
		
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
			giltEs = true;
			throw new IndexOutOfBoundsException();
		}else{
			giltEs = false;
			//return 
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

		if(elem== null){
			throw new NullPointerException();
		}else {
		//	head.setNext(next);
			size++;
		}
		
	}

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



