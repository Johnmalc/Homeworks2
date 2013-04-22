# **Exercise 4** #

Programmieren Sie die Klasse List<K> aus der Vorlesung.

a) Implementieren sie dabei die folgenden Methoden wie in der Vorlesung beschrieben:

    public String toString() {...}
    public boolean isEmpty() {...}
    public void insertFirst(K elem) {...}
# Fertig #

b) Erweitern Sie Ihre Klasse List<K> um die folgenden Methoden:
> 
>  **Abfragen der Anzahl der Elemente in der Liste:**
>  public int size() {...}
>  Die Methode gibt die Anzahl der in der Liste gespeicherten Objekte zurück.
>  
# Fertig #
>  
>  **Abfragen eines Elements an einer bestimmten Position:**
>  public K get(int pos) {...}
>  Die Methode liefert das Objekt an der Stelle pos zurück. Falls gilt (pos < 0 || pos >= size()) soll ein Objekt der folgenden Runtime-Exception geworfen werden: *java.lang.IndexOutOfBoundsException*
# Sollte auch fertig sein #
> 
   **Hinzufügen eines Elements an einer bestimmten Position:**
> public void add(K elem) {...}
> Die Methode hängt das Objekt elem an die bestehende Liste hinten an. Falls gilt (elem==null) soll ein Objekt der folgenden Runtime-Exception geworfen werden: *java.lang.NullPointerException*
# Sollte fertig sein #
Schreiben Sie eine Testklasse Main und Testen Sie die neuen Methoden der Liste ausführlich.

- Testen Sie die Klasse List insbesondere **unter Verwendung der Klasse Account** (aus Aufgabe 1) als Konkretisierung des Typ-Parameters. 
## OK ##
- Fugen Sie beim **Test 2 Account-Objekte der Liste hinzu und geben Sie die Liste auf der Konsole aus**. 
## OK ##
- Prufen Sie vor und nach dem Hinzufügen der Elemente den Rückgabewert der Methode **isEmpty().**
## OK ##
- Fügen Sie ein **weiteres Account-Objekt mit Hilfe der Methode insertFirst(...) in die Liste ein**. Uberprüfen Sie die Korrektheit indem Sie die Liste erneut auf der Konsole ausgeben.
## OK ##
c)Ersetzen Sie das Account-Array in der Klasse CashMachine durch Ihre eigene Klasse List. **Passen Sie ihre Klasse CashMachine entsprechend an.**
## OK ##
d) Implementieren Sie die Methode java.util.Iterator<K> iterator() {...} unter Verwendung einer geeigneten (inneren) Klasse wie in der Vorlesung besprochen. **Testen Sie Ihren Iterator ausführlich!**
