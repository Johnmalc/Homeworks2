package bjorn;

/**
 * @author krausb
 * 
 */
public class List<K> {

	private ListNode head;
	private ListNode temp;
	private int anzahl = 0;
	private int position = 0;

	private class ListNode {
		private ListNode next;
		private K data;

		public void setData(K data) {
			this.data = data;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}

	}

	public String toString() {
		ListNode f = head;
		StringBuilder str = new StringBuilder();
		while (f != null) {
			str.append("<" + f.data + ">");
			f = f.next;
		}

		return str.toString();

	}

	public boolean isEmpty() {
		return head == null;

	}

	public void insertFirst(K elem) {
		ListNode newHead = new ListNode();
		newHead.setData(elem);
		newHead.setNext(head); // Bei erst erstellung ist das naechste element
		head = newHead; // somit null also Listenende, da die Referenz
						// head oben in der Klasse nicht initialisiert
						// wurde!
						// bei der naechsten erstellung verweist next
						// nun nicht mehr auf null(da nun das letzt
						// erstellte Element die position des heads
						// einnimmt), sondern WIEDER auf das letzt
						// erstellte Element(da head = newHead)
						// eingefuegtes element wird zum ersten element (head),
						// vorheriges element rutscht an 2 stelle usw.

	}

	private int sizeVorbereitung() {
		ListNode g = head;

		while (g != null) {
			anzahl++;
			g = g.next;

		}

		return anzahl;

	}

	public int size() {
		int ergebniss = sizeVorbereitung();
		anzahl = 0;
		return ergebniss;

	}

	public K get(int pos) throws IndexOutOfBoundsException {
		ListNode p = head;

		if (pos < 0 || pos >= size()) {
			throw new IndexOutOfBoundsException(
					"Fehler es wurde keine gueltige Elementposition eingegeben!");
		}

		else {
			while (p != null) {
				if (position == pos) {
					temp = p;
				}

				position++;
				p = p.next;

			}
			return temp.data;
		}
	}

	public void add(K elem) throws NullPointerException {

		if (elem == null) {
			throw new NullPointerException(
					"Das zu uebergebende Objekt wurde nicht initialisiert!");
		}

		else {
			ListNode a = head;

			// Funktioniert jetzt ;)
			while (a != null) {
				if (a.next == null) {
					ListNode vorgaenger = new ListNode();
					vorgaenger = a; // Letzter Knoten wird zwischen gespeichert
									// um ein ueberschreiben zu vermeiden

					ListNode newE = new ListNode();
					newE.setData(elem);

					a = newE; // Der neue Knoten nimmt den platz des
								// ursruenglich letzten Kontens ein
					vorgaenger.setNext(a); // Dem urspruenglich letzten Knoten
											// wird der neue Knoten als
											// Nachfolger zugewiesen. Somit
											// rutscht der Urspruenglich letzte
											// Knoten in der Liste um eins nach
											// vorne und ist nun vorletzter.
											// Der neue Knoten uebernimmt den
											// Platz des letzten Knotesns!
				}

				a = a.next;

			}
		}

	}

}
