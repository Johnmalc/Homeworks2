package de.reutlingen.aufgabe5.main;


	
	/**
	 * Implementieren Sie eine Queue (Klasse Queue<K>) welche nach dem First-In 
	 * First-Out Prinzip funktioniert. Die Implementierung soll auf dem Prinzip der
	 *  Verkettung basieren (analog zur Liste). 
	 * @author 
	 *
	 */
public class AnastasiaQueue  <K>{
	/**
	 * a)Implementieren sie dabei die folgenden Methoden:
	 public String toString() {…}
	 public boolean isEmpty() {…}
	 public void push(K element) {…} (Methode zum Einfügen eines Elements in die Queue)
	 public K pull() {…} (Methode zum herausnehmen eines Elements aus der Warteschlange)
	 Public int size() {…} (Gibt die Anzahl der in der Liste gespeicherten Elemente zurück)

	 * 
	 */

	private ListNode<K> top;
	public String toStringListNode() {
		ListNode l = top;
		StringBuilder sb = new StringBuilder();
		int i = 1;
		while (l != null) {
			sb.append(" < " +  l.data.toString()+"> ");
			i++;
			l = l.next;
		}
		
		return  sb.toString();
	}
	/*public String toString(){
		ListNode<K> l=top;
		StringBuilder stringbuilder = new StringBuilder();
		int i = 1;
		while(l!=null)
		{
		stringbuilder.append(" <"+ l.data.toString()+"> ");
		i++;
		l=top.next;		
		}
		return (String) stringbuilder.toString();
		}
	*/

	public boolean isEmpty() {
	return top==null;
	}

	public void push(K element) { //Methode zum Einfügen eines Elements in die Queue
		
	top = new ListNode<K>(top,element);
				
	} 
	public K pull() throws Exception{ //Methode zum herausnehmen eines Elements aus der Warteschlange
			if (top==null) {throw new Exception("…");}
			else{K pull = top.data;
			top=top.next;
			return  pull;}	
	} 



	public int size() {// TO DO
	return 34;	
	}


	}

	class ListNode<K> {
	ListNode<K> next;
	K data;
	ListNode(ListNode<K> next, K data) {
	this.next = next;
	this.data = data;
	}

	void setData(K data) {
	this.data = data;
	}
	void setNext(ListNode<K> next) {
	this.next = next;
	}
	}

	