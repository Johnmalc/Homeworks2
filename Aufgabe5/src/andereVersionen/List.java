package andereVersionen;

import java.util.*;

public class List<K> implements Iterable<K> {
	innerData head;
	public List() {
		head = null;
	}
	public class innerData {
		K data;
		innerData next;
		public innerData(K newData) {
			data = newData;
			next = null;
		}
		public void setNext(innerData newNext) {
			next = newNext;
		}
		public innerData getNext() {
			if (next != null) {
				return next;
			}
			return null;
		}
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
		innerData temp = new innerData(newElement);
		if (head != null) {
			temp.setNext(head);
		}
		head = temp;
	}
	public int size() {
		int dataSize = 0;
		innerData iterating = head;
		while (iterating != null) {
			dataSize++;
			iterating = iterating.getNext();
		}
		return dataSize;
	}
	public K get(int pos) {
		innerData iterating = head;
		int i;
		for (i = 0; i < pos && iterating != null; i++, iterating = iterating
				.getNext());
		return iterating.getData();
	}
	public void add(K newElement) {
		innerData temp = new innerData(newElement);
		innerData iterating = head;
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
	public class myIterator implements Iterator<K> {
		public innerData current;
		public myIterator() {
			current = head;
		}
		@Override
		public boolean hasNext() {
			if (current != null) {
				return current.hasNext();
			}
			return false;
		}
		@Override
		public K next() {
			innerData temp = current;
			current = current.getNext();
			return temp.getData();
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
