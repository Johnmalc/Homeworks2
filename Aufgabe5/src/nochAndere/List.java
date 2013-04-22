package nochAndere;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.util.Iterator;
public class List<K> {
	private ListNode head;
	static int zlr = 0;
	private class ListNode {
		ListNode next;
		K data;

		public void setData(K data) {
			this.data = data;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}
	}
	// ==========Pruft ob meine List m�glicherweise leer ist==========
	public boolean isEmpty() {
		return head == null;
	}
	// ==========Ausgabe der List==========
	public String toString() {
		ListNode l = head;
		StringBuilder sb = new StringBuilder();
		while (l != null) {
			sb.append("<" + l.data + ">");
			l = l.next;
		}
		return sb.toString();
	}
	// ==========Einfugen eines Elements am Anfang einer List=========
	public void insertFirst(K elem) {
		ListNode newHead = new ListNode();
		newHead.setData(elem);
		newHead.setNext(head);
		head = newHead;
		zlr++;
	}
	// ==========Abfragen der Anzahl der Elemente in der Liste==========
	public int size() {
		return zlr;
	}
	// ==========Abfragen eines Elements an einer bestimmten Position==========
	public K get(int pos) {
		ListNode l = head;

		if (pos < 0 || pos >= size()) {
			throw new IndexOutOfBoundsException();
		}

		for (int i = 1; i < pos; i++) {
			l = l.next;
		}
		return l.data;
	}
	// ==========Hinzufugen eines Elements an einer bestimmten
	// Position==========
	public void add(K elem) {
		ListNode l = head;
		zlr++;

		while (l.next != null) {
			l = l.next;
		}

		if (l.next == null) {
			ListNode newEle = new ListNode();
			newEle.setData(elem);
			newEle.setNext(null);
			l.next = newEle;
		}

		if (elem == null) {
			throw new NullPointerException();
		}
	}
	// ==========Iterator==========

	public class MyIterator<k> implements Iterator {
		ListNode aktuelleposi = head;

		public boolean hasNext() {
			if (aktuelleposi != null) {
				return true;
			} else
				return false;
		}

		public Object next() {
			ListNode pos = aktuelleposi;
			aktuelleposi = aktuelleposi.next;
			return pos.data;
		}

		public void remove() {

		}
	}

	public MyIterator<K> getIterator() {
		return new MyIterator();
	}

}
