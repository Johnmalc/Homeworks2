package de.reutlingen.aufgabe55;

/**
 * @author Bjoern Kraus(722630), Muhammet Karakus(722629), Ayten Yilmaz(731224)
 * 
 */
public class Queue<K> {
	private QueueNode head;
	private QueueNode tail;

	public class QueueNode {
		private QueueNode next;
		private K data;

		public void setData(K data) {
			this.data = data;
		}

		public void setNext(QueueNode next) {
			this.next = next;
		}

	}

	public String toString() {
		QueueNode start = head;
		QueueNode ende = tail;
		StringBuilder text = new StringBuilder();

		while (start != ende) {
			text.append("" + start.data + "\n" + "\n");
			start = start.next;
		}

		return text.toString();
	}

	public boolean isEmpty() {
		return head == null;

	}

	public void push(K element) {
		QueueNode start = head;
		QueueNode newElem = new QueueNode();
		newElem.setData(element);

		if (start == null) {
			head = newElem;
			head.setNext(tail);
		} else {
			while (start != tail) {
				if (start.next == tail) {
					QueueNode vorgaenger = new QueueNode();
					vorgaenger = start;
					start = newElem;
					vorgaenger.setNext(start);
				}
				start = start.next;
			}
		}
	}

	public K pull() throws NullPointerException {
		if (head == tail) {
			throw new NullPointerException("Keine Element mehr vorhanden!");
		}
		QueueNode temporaer;
		temporaer = head;
		head = head.next;
		return temporaer.data;
	}

	public int size() {
		int anzahl = 0;
		int temporaer;
		QueueNode start = head;
		QueueNode ende = tail;
		while (start != ende) {
			anzahl++;
			start = start.next;
		}
		temporaer = anzahl;
		anzahl = 0;
		return temporaer;
	}
}
