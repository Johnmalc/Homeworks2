/**
 * 
 */
package aufgabe4;

import java.lang.*;

/**
 * @author krausb
 * 
 */
public class List<K> 
{

	private ListNode head;
	private ListNode temp;
	private ListNode newTail;

	private int anzahl = 0;
	private int position = 0;
	private int anzahlZwei = 0;

	private class ListNode 
	{
		private ListNode next;
		private K data;

		public void setData(K data) 
		{
			this.data = data;
		}

		public void setNext(ListNode next) 
		{
			this.next = next;
		}

	}

	public String toString() 
	{
		ListNode f = head;
		StringBuilder str = new StringBuilder();
		while (f != null) 
		{
			str.append("<" + f.data + ">");
			f = f.next;
		}

		return str.toString();

	}

	public boolean isEmpty() 
	{
		return head == null;

	}

	public void insertFirst(K elem) 
	{
		ListNode newHead = new ListNode();
		newHead.setData(elem);
		newHead.setNext(head);  // Bei erst erstellung ist das naechste element
		head = newHead;			// somit null also Listenende, da die Referenz
		anzahlZwei++;			// head oben in der Klasse nicht initialisiert
								// wurde!
								// bei der naechsten erstellung verweist next
								// nun nicht mehr auf null(da nun das letzt
								// erstellte Element die position des heads
								// einnimmt), sondern WIEDER auf das letzt
								// erstellte Element(da head = newHead)
								// eingefuegtes element wird zum ersten element (head),
								// vorheriges element rutscht an 2 stelle usw.

	}
	
	private int sizeVorbereitung()
	{
		ListNode g = head;

		while (g != null) 
		{
			anzahl++;
			g = g.next;

		}

		return anzahl;
		
	}

	public int size() 
	{
		int ergebniss = sizeVorbereitung();
		anzahl = 0;
		return ergebniss;
		
		


	}
	

	

	public K get(int pos) throws IndexOutOfBoundsException 
	{
		ListNode p = head;

		if (pos < 0 || pos >= size()) 
		{
			throw new IndexOutOfBoundsException("Fehler es wurde keine gueltige Elementposition eingegeben!");
		}

		else 
		{
			while (p != null) 
			{
				if (position == pos)
				{
					temp = p;
				}						
										
				position++;
				p = p.next;						
										
			}
			return temp.data;							
		}
	}
	
	
	public void add(K elem)
	{
		ListNode a = head;
		
		
		// Funktioniert noch nicht
		while(a != null)
		{
			
			
			
			if (a == null)
			{
				
				ListNode newE = new ListNode();
				newE.setData(elem);
				a.next.setNext(newE);
				
				
				
				
				
				
			}
			
			a = a.next;
			
			
		}
		
	}

}
