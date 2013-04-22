/**
 * Schreiben Sie eine Testklasse Main und Testen Sie die neuen Methoden der Liste ausführlich.
 * Testen Sie die Klasse List insbesondere unter Verwendung der Klasse Account (aus Aufgabe 1) 
 * als Konkretisierung des Typ-Parameters. Fügen Sie beim Test 2 Account-Objekte der Liste 
 * hinzu und geben Sie die Liste auf der Konsole aus. Prüfen Sie vor und nach dem Hinzufügen 
 * der Elemente den Rückgabewert der Methode isEmpty(). Fügen Sie ein weiteres Account-Objekt 
 * mit Hilfe der Methode insertFirst(...) in die Liste ein. Überprüfen Sie die Korrektheit 
 * indem Sie die Liste erneut auf der Konsole ausgeben.
 * 
 * 
 */
package anastasia.main;

//import de.university.aufgabe4.main.*;


/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 *
 */
public class MainTest { //Die neue Testklasse Main zum Test der neuen Methoden der Liste 
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Account> listAccounts = new List <Account> ();
			System.out.println(listAccounts.isEmpty());//List ist leer. Muss true gezeigt werden
			listAccounts.add(new Account(23456789, -100.0, 200, 2345)); //Verwendung der Klasse Account
			listAccounts.add(new Account(34567890, -200.0, 300, 3456));
			System.out.println(listAccounts.toString());//gibt die Liste auf der Konsole aus
			System.out.println(listAccounts.isEmpty());//List ist nicht leer. Muss false gezeigt werden
			listAccounts.insertFirst(new Account(45678901, 0.0, 5000, 4567));
			System.out.println(listAccounts.toString());//gibt die Liste auf der Konsole aus
			
			
		
			
			}
		
		



	}

