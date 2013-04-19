package meineversion_OhneListKlasse;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList<Account> g = new LinkedList<Account>();
		System.out.println(g.isEmpty());
		g.addFirst(new Account(5651, 5410, 0455, 0456));
		g.get(0);
		System.out.println(g.isEmpty());
		g.add(new Account(65614654, 6546654, 6554164, 65445));
		for (int i = 0; i <g.size(); i++) {
			g.toString();
		}	
		

	}

}
